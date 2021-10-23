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
		.subject {
            height: max-content;
            padding: 20px;
        }
        .doctor {
            position: relative;
            width: 450px;
            height: 150px;
            background-color: white;
            border: 3px solid rgb(70, 145, 140);
            margin: 20px;
        }
        .doctor_detail {
            background-color: rgb(70, 145, 140);
            width: 450px;
            height: 50px;
            position: absolute;
            bottom: 0;
            color : white;
            text-align: center;
            line-height: 50px;
            font-size: 1.3rem;
        }
        hr {
            background-color: rgb(70, 145, 140);
            height: 3px;
            width: 1000px;
        }
</style>
</head>
<body>
	<jsp:include page="components/header.jsp"></jsp:include>
	<div class="main">
        <jsp:include page="components/sidemenu.jsp"></jsp:include>
	<div class = "content">
        <a href = "index.jsp"><img src = "" alt = "집 아이콘"></a>
        > 의료진
    <h1>의료진 검색</h1>
    <form method = "POST" action = "search_doctor">
    <select>
        <option value = ""></option>
    </select>
    <input type = "text" name = "dname" placeholder = "검색하실 이름을 입력해주세요">
    </form>
    <hr align="left">
    <div class = "subject">
        <div class = "doctor">
            	홍길동 감염내과
            <div class = "doctor_detail">
                	상세보기
            </div>
        </div>
    </div>
    <c:forEach var = "doctor" items = "${doctorList}">
    	${subject}
    	<div class = "doctor_card">
    	${doctor}${doctor.subject}
    	</div>
    </c:forEach>
    <hr>
    </div>
    </div>
    <jsp:include page="components/footer.jsp"></jsp:include>
</body>
</html>