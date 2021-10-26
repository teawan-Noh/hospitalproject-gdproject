<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>여기에 제목을 입력하십시오</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
  		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="css/default.css" />
        
        <style>
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
            .name {
                margin-top: 25px;
                font-size: 2rem !important;
            }
            .table {
            	margin-top: 30px;
            }
            .sname {
                font-size: 20px;
            }
            .table th {
            	padding-left: 150px !important;
            }
            #reservationbtn {
            	width: 100px;
            	height: 35px;
            	background-color: rgb(70, 145, 140);
            	color: white;
            	border: none;
            	border-radius: 5px;
            	margin-left: 20px;
            }
            #backbtn {
            	width: 150px;
            	height: 35px;
            	background-color: rgb(243, 243, 243);
            	border: none;
            	border-radius: 5px;
            }
        </style>
    </head>
    <body>
<<<<<<< HEAD
        <jsp:include page="/jsp/common/header.jsp"></jsp:include>
=======
        <jsp:include page="../common/header.jsp"></jsp:include>
>>>>>>> branch 'develop' of https://github.com/sunne090/gdProject2.git
        <div class="flex container-box">
<<<<<<< HEAD
            <jsp:include page="/jsp/common/sidemenu.jsp"></jsp:include>
=======
            <jsp:include page="../common/sidemenu.jsp"></jsp:include>
>>>>>>> branch 'develop' of https://github.com/sunne090/gdProject2.git
            <div class="content">
                <ul>
                    <li>의료진</li>
                    <li>의료진 목록조회</li>
                </ul>
                <div class="flex">
                	<div class="doctor-img"></div>
                	<c:forEach var = "doctor" items="${doctor}">
                		<div>
                			<span class = "sname">${doctor.sname}</span><br>
                			<span class = "name">${doctor.name}교수</span>
                			<div>
                				<table class = "table">
                					<tr>
                						<th>약력</th>
                					</tr>			
                						<c:set var="keywordArr" value="${fn:split(doctor.career,',')}"></c:set>
										<c:forEach var="word" items="${keywordArr}">
    										<tr><td>${word}</td></tr>
										</c:forEach>
                				</table>
                				<form method = "post" action = "reservation?dcode=${doctor.dcode}&scode=${doctor.scode}">
                					<button type = "button" id = "backbtn" onclick="location.href = 'doctor_search'">목록으로 돌아가기</button>
                					<button type = "submit" id = "reservationbtn">예약</button>
                				</form>
                			</div>
                		</div>
                	</c:forEach>
                </div>
            </div>
        </div>
        <jsp:include page="../common/footer.jsp"></jsp:include>
    </body>
</html>
