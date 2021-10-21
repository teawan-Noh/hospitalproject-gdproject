<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head profile="http://www.w3.org/2005/10/profile">
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "css/imageslider.css" rel = "stylesheet" type = "text/css">
<link href = "css/main.css" rel = "stylesheet" type = "text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src = "js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src = "js/imageslider.js"></script>
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
            <div class="image-slider" id="imageSlider1">
                <div class="slider-body">
                    <div class="image-list">
                    <!-- 이미지 안나옴 -->
                        <img src="./img/산부인과.jpg">
                        <img src="img/소아청소년과.png">
                        <img src="img/소화기내과.jpg">
                        <img src="img/신경과.jpg">
                        <img src="img/심장내과.jpg">
                        <img src="img/외과.jpg">
                        <img src="img/이비인후과.jpg">
                        <img src="img/재활의학과.jpg">
                        <img src="img/정신건강의학과.jpg">
                        <img src="img/정형외과.jpg">
                    </div>
                    <ul class="index-nav">
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                    </ul>
                </div>
            
                <div class="slider-btn-prev">
                    <h3><</h3>		
                </div>
                <div class="slider-btn-next">
                    <h3>></h3>
                </div>
            </div>
        </section>
    </div>
</body>
</html>