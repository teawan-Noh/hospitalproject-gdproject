<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/patient/patientUpdate.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/gdProject2/js/post.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>개인정보수정</title>
</head>
<body>
<div class="container">
<header><jsp:include page="../common/header.jsp"></jsp:include></header>
	<div id="main">
	<div class="flex container-box">
    	<jsp:include page="../common/sidemenu.jsp"></jsp:include>
        <div class="content">
        
            <h2>개인정보수정</h2>
            <form method="post" action="patient_update">
                <table>
                    <tr>
                        <th>성명</th>
                        <td>김이름</td>
                    </tr>

                    <tr>
                        <th>아이디</th>
                        <td>kimid</td>
                    </tr>

                    <tr>
                        <th><label for="nickName" class="form-label">닉네임</label></th>
                        <td><input type="text" name="nickName" id="nickName" class="form-control" value="김네임"></td>
                    </tr>

                    <tr>
                        <th><label for="pw" class="form-label">비밀번호</label></th>
                        <td><input type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요" class="form-control"
                                value="12341234a!">
                        </td>
                    </tr>
                    <tr>
                        <th><label for="pwChk" class="form-label" id="pwChkLabel">비밀번호 확인</label></th>
                        <td><input type="password" name="pwChk" id="pwChk" class="form-control" value="12341234a!"></td>
                    </tr>
                    <tr>
                        <th><label for="tel" class="form-label">연락처</label></th>
                        <td><input type="text" class="form-control" id="tel" value="010-1111-1111"></td>
                    </tr>
                    <tr>
                        <th>주소</th>
                        <td class="post">
                            <input type="text" id="sample6_postcode" name="postcode" class="form-control" value="60000">
                            <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" id="postcodeBtn">
                            <input type="text" id="sample6_address" name="address" class="form-control"
                                value="주소주소주소주소주소주소주소주소">
                            <input type="text" id="sample6_detailAddress" name="addressDetail" class="form-control"
                                value="상세주소주소주소주소주소주소주소">
                        </td>
                    </tr>
                    <tr>
                        <th><label for="radio" class="form-label" id="genderLabel">성별</label></th>
                        <td>
                            <span id="radios">
                                <input type="radio" id="male" class="male" value="male" name="radio">남자
                                <input type="radio" id="female" class="female" value="female" name="radio" checked>여자
                                <input type="radio" id="other" class="other" value="other" name="radio">기타
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <th>생년월일</th>
                        <td>1998-04-14</td>
                    </tr>
                    <tr>
                        <th><label for="email" class="form-label">이메일</label></th>
                        <td><input type="email" name="email" id="email" class="form-control" value="email@email.com">
                        </td>
                    </tr>
                </table>
                <div>
                    <button type="submit" id="save" onclick="location.href = 'patient_update'">저장</button>
                    <button type="button" id="cancel" onclick="location.href = 'index.jsp'">취소</button>
                    <button type="button" id="out" onclick="location.href = 'index.jsp'">탈퇴</button>
                </div>
            </form>
        
        </div>
    </div>
    </div>
    <footer><jsp:include page="../common/footer.jsp"></jsp:include></footer>
   </div>
</body>
</html>