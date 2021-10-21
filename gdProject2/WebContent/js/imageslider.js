//이미지 슬라이더 플러그인 만드는 코드
(function($){
    $.fn.imageSlider = function(options) {
        this.each(function(index){
            //this는 ImageSlider의 객체 자기 자신을 의미하기 때문에 넘어오는 options 값을 
            //this에다가 적용을 하겠다는 코드
            var imageSlider = new ImageSlider(this, options);
        });
        //console.log(this);
        //jQuery체인을 형성을 할 수 있게끔 this를 리턴하고 있다.
        return this;
    }
})(jQuery);

//ImageSlider클래스 정의하기
function ImageSlider(selector, _options) {
    //프로퍼티 선언 및 초기화
    this.$imageSlider = null;   //public
    this._$images = null;       //private

    //현재 인덱스 저장변수
    //-1로 하는 이유는 배열의 인덱스가 0부터 시작하기 때문이다.
    this._currentIndex = -1;
    //이미지의 너비는 이미지가 이전, 다음 버튼을 클릭했을 때, 활성화/비활성화에 사용되는 프로퍼티
    this._imageWidth = 0;

    //a엘러먼트를 저장할 프로퍼티 초기화
    this._$indexItems = null;

    //이미지 자동 전환 기능을 위한 프로퍼티를 선언 및 초기화
    this._timerID = 0;

    //외부에서 이미지 전환 옵션값으로 대체를 위해 주석 처리함
    //this.autoPlayDelayTime = 2000;

    //외부에서 이미지 전환 옵션값들을 저장하기 위한 프로퍼티 선언 및 초기화
    this._options = null;


    //초기화 메서드 호출
    this._init(selector);
    //이미지 초기화 메서드 호출
    this._initImages();
    //외부에서 인스턴스를 생성할 때, 옵션값이 넘어오면 해당하는 옵션값이 생성될 수 있도록 하는
    //_initOptions(_options)를 호출함, 디폴트 옵션값 생성기능도 함
    this._initOptions(_options);

    //이벤트 등록 메서드 호출
    this._initEvent();
    //0번째 인덱스 이미지 활성화(출력하기) 메서드 호출
    //this.showImageAt(0);

    //전환옵션의 값을 활용하여 startIndex값을 설정
    this.showImageAt(this._options.startIndex);  //public

    //웹페이지가 로딩되는 시점부터 이미지 슬라이더가 자동으로 슬라이딩 되는 것을 보여주기 위해서
    //호출함.
    this.startAutoPlay();  //public

}

//기본 옵션 값 설정
//prototype을 사용하지 않았기 때문에 클래스의 프로퍼티로 만들어진 것이다.아래와 같이 클래스 프로퍼티
//로 만드는 경우 여러 개의 이미지 슬라이더 인스턴스가 만들어지더라도 기본 옵션값은 오직 하나만 만들
//어지기 때문에 좀 더 메모리상으로 효율적으로 사용할 수가 있게 되는 것이다.
ImageSlider.defaultOptions = {
    startIndex : 0,
    autoPlay : true,
    autoPlayDelayTime : 2000,
    animationDuration : 1000,
    animationEasing : "easeOutQuint"
}
//extend()는 다수의 객체를 하나의 객체로 합치는 merge기능을 수행을 하는 메서드이다.
//만약에 한개 이상의 객체를 하나로 합치려는 경우에 extend()를 사용해서 새로운 객체를 만들 수도
//있다.만약에 merge대상인 객체가 동일한 프로퍼티를 가지게 되는 경우, 즉 중복되는 프로퍼티의 경우
//는 외부에서 인스턴스를 만들때 넘어오는 옵션값으로 덮어쓰게 된다.
ImageSlider.prototype._initOptions = function(_options) {
    this._options = $.extend({}, ImageSlider.defaultOptions, _options);
}

//요소 초기화 메서드 _init(selector)를 선언 및 구현
ImageSlider.prototype._init = function(selector) {
    this.$imageSlider = $(selector);
    //5개의 이미지가 배열형태로 $images에 저장이 된다.
    this._$images = this.$imageSlider.find(".image-list img");
    
    //이미지 슬라이더의 너비를 구하는 코드
    //이미지 너비는 이미지를 활성화/비활성화에 사용이 될 것임.
    this._imageWidth = this.$imageSlider.find(".slider-body").width();
    //console.log("image-silder의 너비 : " + this._imageWidth);

    //인덱스 메뉴 아이템 a엘러먼트를 5개를 찾아서 배열 형태로 저장하는 코드
    this._$indexItems = this.$imageSlider.find(".index-nav li a");
}

//이미지 요소 초기화 _initImages()를 선언 및 구현
ImageSlider.prototype._initImages = function() {
    this._$images.each(function(){
        $(this).css({
            opacity : 0.0
        });
    });
}

//이벤트 처리 메서드 _initEvent()를 선언 및 구현
ImageSlider.prototype._initEvent = function() {
    var objThis = this;
    //이전 < 이미지 클릭이벤트 등록 코드
    this.$imageSlider.find(".slider-btn-prev").on("click", function(){
        //이전 이미지 출력하는 메서드 호출
        objThis.prevImage();
    });
    //다음 > 이미지 클릭이벤트 등록 코드
    this.$imageSlider.find(".slider-btn-next").on("click", function(){
        //다음 이미지 출력하는 메서드 호출
        objThis.nextImage();
    });

    //인덱스 메뉴 아이템의 mouseenter이벤트를 등록하는 코드
    this._$indexItems.on("mouseenter", function(){
        //slider-body부분 중에 인덱스 메뉴 아이템에 마우스 엔터를 하게 되는 곳이 바로 this가 
        //되어 해당하는 인덱스값을 구하는 코드
        var index = objThis._$indexItems.index(this);
        //console.log("current index값 : " + objThis._currentIndex);
        //console.log("mouseenter이벤트 발생한 index값 : " + index);

        //기존 선택 메뉴 아이템의 인덱스와 신규 선택 아이템 비교 방향 알아내는 코드
        if(objThis._currentIndex > index) {
            objThis.showImageAt(index, "prev");
        }
        else{
            objThis.showImageAt(index, "next");
        }
    });

    //마우스 커서가 이미지 슬라이더 영역에 들어오면 슬라이딩 효과가 멈추어야 하므로
    //stopAutoPlay()호출하는 이벤트 등록
    this.$imageSlider.on("mouseenter", function(){
        objThis.stopAutoPlay();
    });
    //마우스 커서가 이미지 슬라이더 영역 밖으로 나가면 슬라이딩 효과가 다시 진행되어야 하므로
    //startAutoPlay()호출하는 이벤트 등록
    this.$imageSlider.on("mouseleave", function(){
        objThis.startAutoPlay();
    });
}
//이전 이미지 출력하는 prevImage()를 선언 및 구현
ImageSlider.prototype.prevImage = function() {
    //this.showImageAt(this.currentIndex - 1);

    //이미지를 이전 출력효과(애니메이션 기능)를 보이기 위해서 매개변수로 prev값을 넘기고 있다.
    this.showImageAt(this._currentIndex - 1, "prev");
}
//다음 이미지 출력하는 nextImage()를 선언 및 구현
ImageSlider.prototype.nextImage = function() {
    //this.showImageAt(this._currentIndex + 1);

    //이미지를 다음 출력효과(애니메이션 기능)를 보이기 위해서 매개변수로 next값을 넘기고 있다.
    this.showImageAt(this._currentIndex + 1, "next");
}

//인덱스를 매개변수로 받아서 해당 이미지를 출력하는 showImageAt(index)를 선언 및 구현
ImageSlider.prototype.showImageAt = function(index, direction) {
    //인덱스 값을 구하는 코드
    if(index < 0) {  //인덱스가 음수라면....
        index = this._$images.length - 1; //인덱스가 4로 만드는 코드
    }

    if(index >= this._$images.length) { //인덱스가 $images의 길이이 5와 같거나 크다면...
        index = 0;
    }
    //인덱스 출력해보는 테스트 코드
    //console.log("현재 인덱스 : " + this._currentIndex + ", 새로운 인덱스 : " + index);

    //인덱스 값에 해당하는 이미지 요소 구하는 코드
    var $currentImage = this._$images.eq(this._currentIndex);
    //새로운 인덱스 값에 해당하는 이미지 요소 구하는 코드
    var $newImage = this._$images.eq(index);

    //현재 이미지는 비활성화
    // $currentImage.css({
    //     opacity : 0.0
    // });
    //신규 이미지는 활성화
    // $newImage.css({
    //     left : 0,
    //     opacity : 1.0
    // });

    if(direction == "prev" || direction == "next") {
        //currentEndLeft값은 780으로 설정함
        var currentEndLeft = this._imageWidth;
        //nextStartLeft값은 -780으로 설정함
        var nextStartLeft = -this._imageWidth;

        //다음 이미지를 클릭했다면...
        if(direction == "next") {
            currentEndLeft = -this._imageWidth;  //-780
            nextStartLeft = this._imageWidth;    //780
            //console.log("currentEndLeft : " + currentEndLeft);
            //console.log("nextStartLeft : " + nextStartLeft);
        }
        //현재 이미지를 비활성화 애니메이션 기능을 하는 코드
        $currentImage.stop().animate({
            left : currentEndLeft,
            opacity : 0.0
        }, this._options.animationDuration, this._options.animationEasing);
        //신규 이미지 활성화 전에 애니메이션 위치 설정하는 코드
        $newImage.css({
            left : nextStartLeft,
            opacity : 0.0 
        });
        //신규 이미지 활성화 애니메니션 적용하는 코드
        $newImage.stop().animate({
            left : 0,
            opacity : 1.0
        }, this._options.animationDuration, this._options.animationEasing);
    }
    else {  //direction값이 없거나 prev, next가 아닌 경우는 애니메이션 없이 이미지 활성화/비활성화
        $currentImage.css({
            opacity : 0
        });

        $newImage.css({
            left : 0,
            opacity : 1.0
        });
    }
    //현재 인덱스와 동일한 인덱스 아이템 선택
    this._selectIndexAt(index);

    //현재 이미지 인덱스 값을 새로운 인덱스 값으로 저장하는 코드(업데이트)
    //this._currentIndex = index;

    //현재 이미지 인덱스 값 업데이트
    var oldIndex = this._currentIndex;
    this._currentIndex = index;
    //이미지 변경시 발생되는 change이벤트를 생성해주는 _dispatchChangeEvent()호출하고 있다.
    this._dispatchChangeEvent(oldIndex, this._currentIndex);
}
//index에 해당하는 메뉴 아이템을 선택 상태로 만드는 메서드를 정의 및 구현
ImageSlider.prototype._selectIndexAt = function(index){
    //기존 선택 인덱스 메뉴 아이템이 존재한다면....select선택자를 제거하는 코드
    if(this._currentIndex != -1) {
        this._$indexItems.eq(this._currentIndex).removeClass("select");    
    }
    //신규 이미지의 인덱스값에 select선택자를 추가하는 코드   
    this._$indexItems.eq(index).addClass("select");    
}

//change라는 이벤트를 사용자 정의 이벤트로 만들어서 기존 선택 이미지 인덱스와 
//신규 선택 이미지 인덱스를 포장해서 이벤트를 발생하는 메서드 정의 및 구현
ImageSlider.prototype._dispatchChangeEvent = function(oldIndex, newIndex) {
    //사용자 이벤트 생성
    var event = jQuery.Event("change");
    //oldeIndex와 newIndex를 event객체에 포장을 하는 코드
    event.oldIndex = oldIndex;
    event.newIndex = newIndex;
    
    //위와 같이 생성 및 값을 포장한 event객체를 가지고 강제로 이벤트를 발생을 시키는 코드
    this.$imageSlider.trigger(event);
    console.log("change이벤트 발생함.");
}

//자동 전환(오토플레이 기능)을 하는 메서드 정의 및 구현
ImageSlider.prototype.startAutoPlay = function(){
    if(this._options.autoPlay == true) {
        if(this._timerID == 0){
            //함수형태로 nextImage()가 만들어져 있다면 this없이 호출이 가능하나,
            //ImageSlider클래스 안에 메서드로 nextImage()가 구현되어 있어서 
            //메서드를 찾지 못해 실행이 되지 않는다.
            // this._timerID = setInterval(function(){
            //     this.nextImage();
            // }, this.autoPlayDelayTime);
            
            //jQuery.proxy(대상함수, context, 추가 인자값들) -- 메서드 원형
            //대상함수 : context를 변경할 대상함수를 지정하는 매개변수
            //context : 대상함수에 입힐 context지정
            //추가 인자값 : proxy메서드가 실행될 때, 필요한 추가 인자값을 의미(생략 가능)
            //프록시(proxy)는 대리인이라는 뜻이다.즉, 사용자가 원하는 행동을 하기 전에 한 번
            //거쳐가는 단계를 말한다.프록시 패턴은 중간 단계를 거쳐서 원래 객체로 도달하게 
            //만드는 패턴을 의미한다. 중간 단계에서는 캐싱이나 에러 처리 같은 것도 할수 있는 패턴
            //클래스 안에 있는 멤버 메서드를 사용을 하기 위해서는 proxy()를 통해서 접근을 하면
            //된다.
            this._timerID = setInterval($.proxy(function(){
                this.nextImage();
            }, this), this._options.autoPlayDelayTime);
            //console.log(this);
        }
    }
}
//오토 플레이 기능을 멈추게 하는 메서드 정의 및 구현
ImageSlider.prototype.stopAutoPlay = function() {
    if(this._options.autoPlay == true) {
        //타이머 아이디가 생성이 되었다면 0이 아니기 때문에....
        if(this._timerID != 0) {
            clearInterval(this._timerID);
            this._timerID = 0;            
        }
    }
}