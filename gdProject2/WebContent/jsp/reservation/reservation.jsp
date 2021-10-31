<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta />
        <meta
            http-equiv="Content-Type"
            content="text/html; charset=UTF-8"
            name="viewport"
            content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"
        />
 
        <title>여기에 제목을 입력하십시오</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
        />
        <link rel="stylesheet" href="css/default.css" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>

        <!-- fullcalendar CDN -->
        <link
            href="https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css"
            rel="stylesheet"
        />
        <script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js"></script>
        <!-- fullcalendar 언어 CDN -->
        <script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js"></script>

        <style>      
		    a {
			    display: inline-block;
			    text-decoration: none !important;
			}
			button {
			    border: 0;
			    background: transparent;
			    cursor: pointer;
			}
			ul{
			   padding: 0;
			}
			.home-img{
			   background-image: url("img/home.png");
			    background-size: cover;
			    background-position: center;
			    background-repeat: no-repeat;
			    width: 20px;
			    height: 20px;
			}
			.fmenu{
			   padding-left: 0px;
			}
			.fmenu li:not(.fmenu li:first-child)::before{
			   content: ">";
			}
			
			.container-box {
			    margin: 0 auto;
			    width: 100%;
			    max-width: 1200px;
			}
			.content {
			    flex: 3;
			    max-width: 800px;
			    margin: 50px;
			}
			.select {
			    border: 1px solid #468c91;
			    padding: 25px;
			    margin: 25px 0;
			}
			.card-list {
			    max-width: 800px;
			    margin: 10px 50px;
			    display: flex;
			    flex-wrap: wrap;
			    justify-content: space-around;
			}
			.card-box {
			    display: block;
			    font-size: 24px;
			    border: 1px solid #468c91;
			    border-radius: 5px;
			    padding: 10px 40px;
			    margin: 10px;
			    color: #468c91;
			}      
            th .fc-scrollgrid-sync-inner {
                background-color: #468c91;
            }
            a.fc-col-header-cell-cushion {
                color: white;
            }
            .fc-daygrid-day-number {
                color: #468c91;
            }
            .rest,
            .fc-day-past .fc-daygrid-day-number,
            .fc-day-today .fc-daygrid-day-number,
            .fc-day-sat div a,
            .fc-day-sun div a,
            .rest div a {
                color: #b8b8b8;
            }
            .fc .fc-daygrid-day.fc-day-today {
                background-color: rgba(255, 255, 255, 0);
                /* background-color: var(--fc-today-bg-color,rgba(255,220,40,.15)); */
            }
            .fc-h-event {
                background-color: #468c91;
            }
            .fc-header-toolbar {
                padding-top: 1em;
                padding-left: 1em;
                padding-right: 1em;
            }

            .card-box.subject{
               width: 45%;
            }

            .card-box.doctor {
                display: block;
                font-size: 24px;
                border: 1px solid #468c91;
                border-radius: 5px;
                padding: 10px 0 0 0;
                margin: 10px;
                color: #468c91;
            }
            .card-box.doctor .flex {
                margin: 0 40px;
            }

            .card-box:hover:not(.not-available),
            .card-box.active:not(.not-available) {
                background-color: #468c91;
                color: white;
            }
            .card-box.not-available {
                background-color: #b8b8b8;
                border: none;
                color: white;
            }

            .rsv-time .card-box {
                font-size: 16px !important;
            }
            .doctor-img {
                background-image: url("img/doctor-img.png");
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
                filter: opacity(0.5) drop-shadow(0 0 0 #468c91);
                margin: 25px 20px 25px 0;
                width: 100px;
                height: 100px;
            }

            .card-box button {
                width: 100%;
                background-color: #468c91;
                color: white;
                text-align: center;
            }
            .card-box:hover button,
            .card-box.active button {
                background-color: white;
                color: #468c91;
            }
            .doctor-name {
                margin-top: 25px;
            }
            .doctor-subject {
                font-size: 16px;
            }
            .doctor-code {
                display: none;
            }
            #book {
                margin-left: 0;
            }
            button.card-box{
               display: inline-block;
               margin-left: 0;
            }
        </style>
        <script>
            $(function () {
            	let setting = (${rcode} != 0 || ${rsv} != 0) ? true : false;
               	let pcode = ${pcode};
                let subject = "${subject}";
                let dcode = "${dcode}";
                let dname = "${dname}";

                
                console.log(setting);
                console.log(pcode);
                console.log(subject);
                console.log(dcode);
                console.log(dname);

                

                function XMLToString(oXML) {
                    //code for IE
                    if (window.ActiveXObject) {
                        var oString = oXML.xml;
                        return oString;
                    }
                    // code for Chrome, Safari, Firefox, Opera, etc.
                    else {
                        return new XMLSerializer().serializeToString(oXML);
                    }
                }
 
                //////////달력////////////////
                // calendar element 취득
                var calendarEl = $("#calendar")[0];
                // full-calendar 생성하기
                var calendar = new FullCalendar.Calendar(calendarEl, {
                    height: "600px", // calendar 높이 설정
                    expandRows: true, // 화면에 맞게 높이 재설정
                    slotMinTime: "00:00", // Day 캘린더에서 시작 시간
                    slotMaxTime: "23:59", // Day 캘린더에서 종료 시간
                    // 해더에 표시할 툴바
                    headerToolbar: {
                        left: "prev,next today",
                        center: "title",
                        right: "dayGridMonth,listWeek", //"dayGridMonth,timeGridWeek,timeGridDay,listWeek"
                    },
                    initialView: "dayGridMonth", // 초기 로드 될때 보이는 캘린더 화면(기본 설정: 달)
                    //initialDate: "2021-07-15", // 초기 날짜 설정 (설정하지 않으면 오늘 날짜가 보인다.)
                    navLinks: false, // 날짜를 선택하면 Day 캘린더나 Week 캘린더로 링크
                    editable: false, // 수정 가능?
                    selectable: false, // 달력 일자 드래그 설정가능
                    nowIndicator: false, // 현재 시간 마크
                    dayMaxEvents: true, // 이벤트가 오버되면 높이 제한 (+ 몇 개식으로 표현)
                    locale: "ko", // 한국어 설정
                    eventAdd: function (obj) {
                        console.log(obj);
                    },
                    eventChange: function (obj) {
                        // 이벤트가 수정되면 발생하는 이벤트
                        //console.log(obj);
                        
                    },
                    eventRemove: function (obj) {
                        // 이벤트가 삭제되면 발생하는 이벤트
                        //console.log(obj);
                    },
                    eventDidMount: function(arg){
                       var el = $(arg.el).closest("td.fc-day");
                       $(el).addClass("rest");
                       console.log(el);
                    },
                    datesSet: function(dateInfo){
                       calendar.removeAllEvents();
                        calendar.addEvent({
                            title: "주말",
                            daysOfWeek: ["0", "6"],
                            classNames: ["rest-children"],
                        });
                        let url = "schedule";

                        $.get(url, { dcode: dcode }, function (data) {
                           console.log(XMLToString(data));
                            var schedule = $(data).find("schedule");
                            if ($(schedule).length > 0) {
                                $(schedule).each(function (idx, item) {
                                    var restdate = $(item)
                                        .find("restdate")
                                        .text();
                                    var day = $(item).find("day").text();
                                    if (restdate != "") {
                                        calendar.addEvent({
                                            title: "휴진",
                                            start: restdate,
                                            classNames: ["rest-children"],
                                        });
                                    } else if (day != "") {
                                    	console.log(String(Number(day) - 1));
                                        calendar.addEvent({
                                            title: "휴진",
                                            daysOfWeek: [String(Number(day) - 1)],
                                            classNames: ["rest-children"],
                                        });
                                    }

                                    
                                });

                                   
                            }
                        });
                    },
                    
                    
                    // 달력 날짜를 클릭할 때
                    dateClick: function (date) {
                       console.log(date);
                        var view = date.dayEl;
                        if (
                            !$(view).hasClass("fc-day-future") ||
                            $(view).hasClass("rest") ||
                            $(view).hasClass("fc-day-sun") ||
                            $(view).hasClass("fc-day-sat")
                        ) {
                            alert("해당 날짜는 예약할 수 없습니다.");
                        } else {
                            rsvdate = date.dateStr;
                            rsvtime = "";
                            $("#selected").remove();
                            $("#reservation-time").prepend(
                                "<h2 id='selected'>" + rsvdate + "</h2>"
                            );
                            $(".rsv-time")
                                .children()
                                .each(function (idx, item) {
                                    $(item).remove();
                            });

                            var url = "rsv-time";
                            // 스케줄 ajax

                            let available = [
                                // 예약 가능 리스트
                                "09:00",
                                "09:15",
                                "09:30",
                                "10:00",
                                "10:15",
                                "10:30",
                                "11:00",
                                "11:15",
                                "11:30",
                                "11:45",
                                "13:00",
                                "13:15",
                                "13:30",
                                "14:00",
                                "14:15",
                                "14:30",
                                "15:00",
                                "15:15",
                                "15:30",
                                "16:00",
                                "16:15",
                                "16:30",
                                "17:00",
                                "17:15",
                                "17:30",
                                "17:45",
                            ];
                            $.get(
                                url,
                                { dcode: dcode, rsvdate: rsvdate },
                                function (data) {
                                    let rsv = $(data).find("rsv");
                                    let notavailable = [];
                                    if (rsv != undefined) {
                                        $(rsv).each(function (idx, item) {
                                            notavailable.push(
                                                $(item).text().trim()
                                            );
                                            console.log($(item).text().trim());
                                        });
                                        available.forEach(item => {
                                            if (
                                                notavailable.indexOf(item) == -1
                                            ) {
                                                $(".rsv-time").append(
                                                    "<li class='card-box'>" +
                                                        item +
                                                        "</li>"
                                                );
                                            } else {
                                                $(".rsv-time").append(
                                                    "<li class='card-box not-available'>" +
                                                        item +
                                                        "</li>"
                                                );
                                            }
                                        });
                                    }
                                }
                            );
                        }
                        // 일정 출력

                        /*
                        var schedule = date.dayEl.innerText.split("\n");
                        console.log(schedule[1]);
                        console.log(date.dateStr);
                        console.log(date.dayEl);
                        */
                    },
                    // 이벤트
                    events: [],
                });
                // 캘린더 랜더링
                calendar.render();
                $("#calendar-container").hide();

                // 진료 과목 선택시
                $(".subject").click(function () {
                    $(".doctors")
                        .children()
                        .each(function (idx, item) {
                            $(item).remove();
                        });
                    $("#calendar-container").hide();
                    if ($(this).hasClass("active")) {
                        $(this).removeClass("active");
                        subject = "";
                        dcode = "";
                        dname = "";
                        rsvdate = "";
                        rsvtime = "";
                    } else {
                        $(".subject").each(function (idx, item) {
                            $(item).removeClass("active");
                        });
                        $(this).addClass("active");
                        let url = "subject-doctor";
                        $.get(
                            url,
                            { subject: $(this).text() },
                            function (data) {
                               subject = $(data).find("subject").text();
                               $(data)
                                    .find("doctor")
                                    .each(function (idx, item) {
                                        $(".doctors").append(
                                            '<li class="card-box doctor"><div class="flex"><div class="doctor-img">' +
                                                "</div><div class='doctor-profile'><p class='doctor-name'>" +
                                                $(item).find("name").text() +
                                                "</p><p class='doctor-code'>" +
                                                $(item).find("dcode").text() +
                                                "</p><p class='doctor-subject'>" +
                                                subject +
                                                "</p></div></div>" +
                                                "<button class='doctor-detail'>상세보기</button>" +
                                                "</li>"
                                        );
                                    });
                                
                               console.log(dcode + ", " + dname);
                               console.log(setting);
                                if(dcode != "" && dname != "" && setting){
                                   $(".card-box.doctor .flex").each(function(idx, item){
                                      var name = $(this).find(".doctor-name").text();
                                      var code = $(this).find(".doctor-code").text();
                                      console.log(dname);
                                      console.log(name);
                                      console.log(dcode);
                                      console.log(code);
                                      if(dname == name && dcode == code){
                                         $(this).trigger("click");
                                      }
                                      
                                   })
                                }
                                else if(dcode == "" && dname == "" && setting){
                                   setting = false;
                                }
                                else{
                                   dcode = "";
                                   dname = "";
                                   rsvdate = "";
                                   rsvtime = "";
                                }
                                
                            }
                        );
                    }
                });

                // 의사 선택시 달력 표시
                $(document).on("click", ".card-box.doctor .flex", function () {
                    //let url = "schedules";

                    calendar.removeAllEvents();
                    calendar.addEvent({
                        title: "주말",
                        daysOfWeek: ["0", "6"],
                        classNames: ["rest-children"],
                    });

                    var doctor = $(this).parent(".card-box.doctor");
                    if ($(doctor).hasClass("active")) {
                        $(doctor).removeClass("active");
                        dcode = "";
                        dname = "";
                        rsvdate = "";
                        rsvtime = "";
                        $("#calendar-container").hide();
                    } else {
                        $(".card-box.doctor").each(function (idx, item) {
                            $(item).removeClass("active");
                        });
                        
                        $(".rsv-time")
                            .children()
                            .each(function (idx, item) {
                                $(item).remove();
                            });

                        $("#selected").remove();

                        $(doctor).addClass("active");
                        
                        $("#calendar-container").show();

                        let url = "schedule";
                        dcode = $(this)
                            .children(".doctor-profile")
                            .children(".doctor-code")
                            .text();
                        dname = $(this)
                            .children(".doctor-profile")
                            .children(".doctor-name")
                            .text();

                        // Ajax
                        $.get(url, { dcode: dcode }, function (data) {
                            var schedule = $(data).find("schedule");
                            if ($(schedule).length > 0) {
                                $(schedule).each(function (idx, item) {
                                    var restdate = $(item)
                                        .find("restdate")
                                        .text();
                                    var day = $(item).find("day").text();
                                    if (restdate != "") {
                                        calendar.addEvent({
                                            title: "휴진",
                                            start: restdate,
                                            classNames: ["rest-children"],
                                        });
                                    } else if (day != "") {
                                        calendar.addEvent({
                                            title: "휴진",
                                            daysOfWeek: [String(Number(day) - 1)],
                                            classNames: ["rest-children"],
                                        });
                                    }

                                    
                                });

                                   
                            }
                        });
                        if(setting){
                           setting = false;
                        }
                        else{
                           rsvdate = "";
                           rsvtime = "";
                        }
                    }
                });

                // 의사 상세정보 페이지
                $(document).on("click", ".doctor-detail", function () {
                    //let url = "schedules";
                    var code = $(this)
                        .parent(".card-box")
                        .children(".flex")
                        .children(".doctor-profile")
                        .children(".doctor-code")
                        .text();
                    console.log(code);
                    //$.get(url, { dcode: dcode }, function (data) {});
                    location.href =
                        "doctor_detail?subject=" + subject + "&dcode=" + code;
                });

                // 시간 클릭
                $(document).on("click", ".rsv-time .card-box", function () {
                    if ($(this).hasClass("not-available")) {
                        alert(
                            "이미 예약된 시간입니다.\n다른 시간을 선택해주세요."
                        );
                    } else {
                        $(".rsv-time .card-box").each(function () {
                            $(this).removeClass("active");
                        });
                        rsvtime = $(this).text();
                        $(this).addClass("active");
                    }
                });

                // 예약하기 버튼 클릭
                $(document).on("click", "#book", function () {
                    if (subject == "") {
                        alert("진료과를 선택해주세요.");
                    } else if (dcode == "") {
                        alert("담당 의사를 선택해주세요.");
                    } else if (rsvdate == "") {
                        alert("예약 날짜를 선택해주세요.");
                    } else if (rsvtime == "") {
                        alert("예약 시간을 선택해주세요.");
                    } else {
                    	console.log("adfaf");
                        $("input[name=pcode]").val(pcode);
                        $("input[name=dcode]").val(dcode);
                        $("input[name=rcode]").val("");
                        $("input[name=dname]").val(dname);
                        $("input[name=subject]").val(subject);
                        $("input[name=rsvdate]").val(rsvdate + " " + rsvtime);
                        $("#form-confirm").submit();
                    }
                });
                
                if(subject != ""){
                   $(".subject").each(function(idx, item){
                      var text = $(this).text();
                      if(subject == text){
                         $(this).trigger("click");
                      }
                   });
                }
                
                $(document).on("click", ".card-box.cancel", function(){
                   $("#form-cancel").submit();
                })
                $(document).on("click", ".card-box.update", function(){
                   if (subject == "") {
                        alert("진료과를 선택해주세요.");
                    } else if (dcode == "") {
                        alert("담당 의사를 선택해주세요.");
                    } else if (rsvdate == "") {
                        alert("예약 날짜를 선택해주세요.");
                    } else if (rsvtime == "") {
                        alert("예약 시간을 선택해주세요.");
                    } else {
                    	console.log("Adfafadf");
                          $("input[name=pcode]").val(pcode);
                          $("input[name=rcode]").val(${rcode});
                          $("input[name=dcode]").val(dcode);
                          $("input[name=dname]").val(dname);
                          $("input[name=subject]").val(subject);
                          $("input[name=rsvdate]").val(rsvdate + " " + rsvtime);
                          $("#form-confirm").submit();
                        
                    }
                })
                
            });
        </script>
    </head>
    <body>
        <jsp:include page="../common/header.jsp"></jsp:include>
        <div class="flex container-box">
            <jsp:include page="../common/sidemenu.jsp">
                <jsp:param name="side" value="${side}" />
            </jsp:include>
            <div class="content">
                <ul class="fmenu">
                   <li><div class="home-img"></div></li>
                    <li>예약</li>
                    <li>예약하기</li>
                </ul>
                <h1>예약하기</h1>
                <div class="select">
                    <h2>진료과 선택</h2>
                    <ul class="card-list">
                        <c:forEach var="subject" items="${subjectList}">
                            <li class="card-box subject">${subject.name}</li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="select">
                    <h2>의료진 선택</h2>
                    <ul class="card-list doctors"></ul>
                </div>
                <div class="select">
                    <h2>예약 날짜 선택</h2>
                    <div id="calendar-container">
                        <div id="calendar"></div>
                        <br />
                        <div id="reservation-time">
                            <h2 id="selected"></h2>
                            <ul class="card-list rsv-time"></ul>
                        </div>
                    </div>
                </div>
                <c:if test="${rcode == 0}">
                   <button id="book" class="card-box book">예약하기</button>
                </c:if>
                <c:if test="${rcode != 0}">
                   <button class="card-box update">변경하기</button>
                   <button class="card-box cancel">취소하기</button>
                </c:if>
                <form style="display: none;" id="form-cancel" action="reservation-detail" method="post">
                   <input type="hidden" name="rcode" value="${rcode}"/>
                </form>
                <form style="display: none;" id="form-confirm" action="reservation-confirm" method="post">
                   <input type="hidden" name="pcode" value=""/>
                   <input type="hidden" name="rcode" value=""/>
                   <input type="hidden" name="dcode" value=""/>
                   <input type="hidden" name="subject" value=""/>
                   <input type="hidden" name="dname" value="" />
                   <input type="hidden" name="rsvdate" value=""/>
                </form>
            </div>
        </div>
        <jsp:include page="../common/footer.jsp"></jsp:include>
    </body>
</html>