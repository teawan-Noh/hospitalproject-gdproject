<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head profile="http://www.w3.org/2005/10/profile">
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "css/main.css" rel = "stylesheet" type = "text/css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div class="main"> 
        <section class="sec1">
            <div class = "mainmenu">
                <h3 class="menu-title">예약</h3>
                <p class="menu-content">진료 예약을 하실 수 있습니다.</p>
            </div>
            <div class = "mainmenu">
                <h3 class="menu-title">예약조회</h3>
                <p class="menu-content">예약내역을 확인할 수 있습니다.</p>
            </div>
            <div class = "mainmenu">
                <h3 class="menu-title">소통정보</h3>
                <p class="menu-content">우리 병원에 궁금한 점을 남겨주시면 담당자가 확인 후 직접 답변해드립니다.</p>
            </div>
            <div class = "mainmenu">
                <h3 class="menu-title">의료진정보</h3>
                <p class="menu-content">우리 병원의 의료진 정보를 확인할 수 있습니다.</p>
            </div>
        </section>
        <section class="sec2">
            <h1>진료 과목 소개</h1>
            <div class="w3-content w3-display-container">
  				<img class="mySlides" src="img/감염내과.jpg" style="width:700px">
  				<img class="mySlides" src="img/내분비대사내과.jpg" style="width:700px">
  				<img class="mySlides" src="img/성형외과.jpg" style="width:700px">
  				<img class="mySlides" src="img/소아청소년과.jpg" style="width:700px">
  				<img class="mySlides" src="img/안과.jpg" style="width:700px">
  				<img class="mySlides" src="img/알레르기내과.jpg" style="width:700px">
  				<img class="mySlides" src="img/이비인후과.jpg" style="width:700px">
  				<img class="mySlides" src="img/정형외과.jpg" style="width:700px">
  				<img class="mySlides" src="img/피부과.jpg" style="width:700px">
  				<img class="mySlides" src="img/흉부외과.jpg" style="width:700px">

  				<button class="w3-button w3-black w3-display-left" onclick="plusDivs(-1)">&#10094;</button>
 				<button class="w3-button w3-black w3-display-right" onclick="plusDivs(1)">&#10095;</button>
			</div>
        </section>
    </div>
<script>
var myIndex = 0;
carousel();

function carousel() {
  var i;
  var x = document.getElementsByClassName("mySlides");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  myIndex++;
  if (myIndex > x.length) {myIndex = 1}    
  x[myIndex-1].style.display = "block";  
  setTimeout(carousel, 3000);
}
</script>
</body>
</html>