<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>여기에 제목을 입력하십시오</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
        />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
        <style>

            .side-bar {
                flex: 1;
                max-width:400px;
                padding-top: 50px;
                border-color: #b8b8b8;
            	border-style: solid;
            	border-width: 0px 1px 0px 0px;
            }
            #side-ul{
            	padding: 0px;
            }
            .side-title{
            	border-color: #b8b8b8;
            	border-style: solid;
            	border-width: 0px 0px 1px 0px;
            }
            ul .side-list {
                width: 100%;
                height: 50px;
                padding-left: 25px;
                padding-top: 10px;
                display: block;
                border-color: #b8b8b8;
            	border-style: solid;
            	border-width: 0px 0px 1px 0px;
            }
            #side-img{
            	background-image: url("img/doctor.png");
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
                width: 75px;
                height: 75px;
            }
                        
            #patientMenu{
            	 text-decoration:none;
            	 color:#555;
            }
        </style>
    </head>

    <body>
        <div class="side-bar">
        	<c:if test="${side == 'reservation'}">
	            <div class="flex side-title">
	                <h1>예약</h1>
	                <div id="side-img"></div>
	            </div>
	            <ul id="side-ul">
	                <li class="side-list">예약하기</li>
	                <li class="side-list">예약조회</li>
	            </ul>
            </c:if>
            <c:if test="${side == 'doctor'}">
            	<div class="flex side-title">
	                <h1>의료진</h1>
	                <div id="side-img"></div>
	            </div>
	            <ul id="side-ul">
	                <li class="side-list">의료진 목록조회</li>
	            </ul>
            </c:if>
        	<c:if test="${side == 'reservation'}">
	            <div class="flex side-title">
	                <h1>예약</h1>
	                <div id="side-img"></div>
	            </div>
	            <ul id="side-ul">
	                <li class="side-list">예약하기</li>
	                <li class="side-list">예약조회</li>
	            </ul>
            </c:if>
            <c:if test="${side == 'doctor'}">
            	<div class="flex side-title">
	                <h1>의료진</h1>
	                <div id="side-img"></div>
	            </div>
	            <ul id="side-ul">
	                <li class="side-list">의료진 목록조회</li>
	            </ul>
            </c:if>
            <c:if test="${side == 'patient'}">
            	<div class="flex side-title">
            		<h1>회원서비스</h1>
            		<div id="side-img"></div>
            	</div>
            	<ul id="side-ul">
	                <li class="side-list"><a href="patient_update" id="patientMenu">개인정보수정</a></li>
	            </ul>
            </c:if>

        </div>
    </body>
</html>
