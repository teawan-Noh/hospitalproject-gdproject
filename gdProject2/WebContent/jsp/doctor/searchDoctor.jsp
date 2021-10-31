<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		.main {
            margin: 0 auto;
            max-width: 1200px;
            display: flex;
        }
        .content {
        	margin: 20px;
        	max-width: 900px;
        }
		.subject {
            height: max-content;
            padding: 20px;
            display: flex;
             flex-wrap: wrap;
        }
        .doctor {
            position: relative;
            width: 380px;
            height: 205px;
            background-color: white;
            border: 3px solid rgb(70, 145, 140);
            margin: 20px;
            display: flex;
            padding: 0;
        }
        .doctor:hover {
        	background-color: rgb(70, 145, 140);
        	color: white;
        }
        .doctor:hover .doctor_detail {
        	background-color: white;
        	color: black;
        }

        .doctor_detail {
            background-color: rgb(70, 145, 140);
            width: 375px;
            height: 50px;
            position: absolute;
            bottom: 0;
            left: 0;
            color : white;
            text-align: center;
            line-height: 50px;
            font-size: 1.3rem;
            margin: 0;
            padding: 0;
        }
        hr {
            background-color: rgb(70, 145, 140);
            height: 3px;
            width: 900px;
        }
        #select, input {
        	width: 300px;
        	height: 50px;
        	border: 1px solid rgb(243, 243, 243);
            border-radius: 5px; 
        }
        button {
        	width: 100px;
        	height: 40px;
      		color: white;
      		background-color: rgb(70, 145, 140);
      		border: none;
      		border-radius: 5px !important;
        }
        .selectedSubject {
        	margin-left: 10px;
        	font-size: 1.5rem;
        }
        .subject span {
        	font-size: 1.3rem;
        }
         .img {
                background-image: url("img/doctor-img.png");
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
                filter: opacity(0.5) drop-shadow(0 0 0 #468c91);
                margin: 25px 20px 25px 25px;
                width: 100px;
                height: 100px;
        }
        .name {
        	margin-top: 40px;
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
        
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="main">
        <jsp:include page="../common/sidemenu.jsp"></jsp:include>
	<div class = "content">
        <ul class="fmenu">
    		<li><div class="home-img"></div></li>
    		<li>의료진</li>
    		<li>의료진 목록조회</li>
    	</ul>
    <h1>의료진 검색</h1>
    <form method = "POST" action = "doctor_list">
    	<select name = "selectSubject" id = "select">
    		<c:forEach var = "subject" items="${subjectList}">
    			<option value = "${subject.scode}">${subject.name}</option>
    		</c:forEach>   
    	</select>
    	<input type = "text" name = "dname" placeholder = "검색하실 이름을 입력해주세요">
    	<button type = "submit">검색</button>
    </form>
    <hr align="left">
    <c:if test="${selectSubject != null }">
    	<span class = "selectedSubject">${selectSubject.name} [Tel: ${selectSubject.tel}]</span>
    </c:if>
    <div class = "subject">
    	<c:if test="${empty doctorList}">
    		<span>진료과를 선택하신 후 검색하실 이름을 입력해주세요.</span>
    	</c:if>
    	<c:if test="${!empty doctorList}">
    		<c:forEach var = "doctor" items = "${doctorList}">
            	<div class = "doctor">
            		<div class = "img"></div>
            		<div class = "name">
     					<span class = "dname">${doctor.name}교수</span><br>
     					<span class = "sname">[${doctor.sname}]</span>
     				</div>
    				<div class = "doctor_detail" onclick="location.href ='doctor_detail?dcode=${doctor.dcode}'">
                		상세보기
            		</div>
            	</div>
    		</c:forEach>
    	</c:if>   
    </div>
    
    <hr>
    </div>
    </div>
    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>