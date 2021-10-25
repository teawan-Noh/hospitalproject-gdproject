<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
<c:if test="${pcode == null && dcode == null && mcode == null}">
	<a href="patient_input">회원가입</a>
	<a href="patient_login_input">환자 로그인</a>
	<a href="doctor_login_input">의사 로그인</a>
	<a href="manager_login_input">관리자 로그인</a>
</c:if>

<c:if test="${pcode != null || dcode != null || mcode != null}">
	<a href="logout">로그아웃</a>
</c:if>
<c:if test="${pcode != null}">
	<a href="patient_detail" id="patientUpdate">마이페이지</a>
</c:if>
</body>
</html>