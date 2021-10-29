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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/patientUpdate.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/gdProject2/js/post.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	
	
	$("#save").click(function(){
		var pw_value = $("input[name='pw']").val().replace(/\s/gi, "");
		var pwChk_value = $("input[name='pwChk']").val().replace(/\s/gi, "");
	
		//비밀번호 유효성 검사
		var regulPw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$/;
		var regResult = regulPw.test(pw_value);
	
		if(!regResult){
			alert("영어 대소문자,숫자,특수문자 포함해서 8자리에서 20자리 사이로 입력해주세요.");
			$("#pwChkSpan").html("다시 입력해주세요.");
			$("#pwChkSpan").css({"color":"tomato"});
			$("input[name='pw']").val('');
			$("input[name='pwChk']").val('');
			$("input[name='pw']").focus();
			return false;
		}
		
		//일치여부
		if(pw_value != pwChk_value){
			alert('비밀번호가 일치하지 않습니다. 다시 입력해주세요.');
			$("#pwChkSpan").html("다시 입력해주세요.");
			$("#pwChkSpan").css({"color":"tomato"});
			$('#pw').val('');
			$('#pwChk').val('');
			$("input[name='pw']").focus();
			return false;
		}else if(pw_value == pwChk_value){
			$("#pwChkSpan").html("일치합니다.");
			$("#pwChkSpan").css({"color":"blue"});
		}
		
		if(!pw_value){
			alert("비밀번호를 입력해주세요.")
			$("#pwChkSpan").html("");
			return false;
		}
		
		if(!pwChk_value){
			alert("비밀번호 확인을 입력해주세요.")
			$("#pwChkSpan").html("");
			return false;
		}
		
		//닉네임
		var nick_value = $("input[name='nickName']").val().replace(/\s/gi, "");
		
		if(!nick_value){
			alert("닉네임을 입력해주세요.");
			$("input[name='nickName']").focus();
			$("input[name='nickName']").val('');
			return false;
		}
		
		var regulNickName = /^[a-zA-Z0-9가-힣]{2,20}$/;
		var regNickNameResult = regulNickName.test(nick_value);
		
		if(!regNickNameResult){
			alert("닉네임은 특수문자 제외 2자리 이상으로 입력해주세요.");
			$("input[name='nickName']").focus();
			return false;
		}
		
		//연락처
		var tel_value = $("input[name='tel']").val().replace(/\s/gi, "");
		
		if(!tel_value){
			alert("연락처를 입력해주세요.");
			$("input[name='tel']").focus();
			$("input[name='tel']").val('');
			return false;
		}
		
		var regulTel = /^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}/;
		var regTelResult = regulTel.test(tel_value);
		
		if(!regTelResult){
			alert("전화번호는 010-0000-0000 형식으로 입력해주세요.");
			$("input[name='tel']").focus();
			return false;
		}
		
		//이메일
		var email_value = $("input[name='email']").val().replace(/\s/gi, "");
		
		if(!email_value){
			alert("이메일을 입력해주세요.");
			$("input[name='email']").focus();
			$("input[name='email']").val('');
			return false;
		}
		
		var regulEmail = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]{2,3}/;
		var regEmailResult = regulEmail.test(email_value);
		
		if(!regEmailResult){
			alert("이메일을 형식에 맞게 입력해주세요.");
			$("input[name='email']").focus();
			return false;
		}
		
		//우편번호
		var postcode_value = $("input[name='postcode']").val().replace(/\s/gi, "");
		
		if(!postcode_value){
			alert("우편번호를 입력해주세요.");
			$("input[name='postcode']").focus();
			$("input[name='postcode']").val('');
			return false;
		}
		
		//주소
		var address_value = $("input[name='address']").val();
		
		if(!address_value){
			alert("주소를 입력해주세요.");
			$("input[name='address']").focus();
			return false;
		}
		
		//상세주소
		var address2_value = $("input[name='address2']").val();
		
		if(!address2_value){
			alert("상세주소를 입력해주세요.");
			$("input[name='address2']").focus();
			return false;
		}
		
		
		alert("수정되었습니다.");
		
	});
	
	
	$('#out').click(function() { var result = confirm('탈퇴하시겠습니까?'); 
		if(result) {
			alert("탈퇴되었습니다.")
			location.replace('index.jsp');
		} else { 
			alert("취소되었습니다.")
			location.replace('patient_detail');
		} 
	});

		
});
</script>
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
            <form method="post" action="patient_update?pcode=${patient.pcode}">
                <table>
                    <tr>
                        <th>성명</th>
                        <td>
                        	${patient.name}
                        </td>
                    </tr>

                    <tr>
                        <th>아이디</th>
                        <td>${patient.id}</td>
                    </tr>

                    <tr>
                        <th><label for="nickName" class="form-label">닉네임</label></th>
                        <td><input type="text" name="nickName" id="nickName" class="form-control" value="${patient.nickname}"></td>
                    </tr>

                    <tr>
                        <th><label for="pw" class="form-label">비밀번호</label></th>
                        <td><input type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요" class="form-control"
                                value="${patient.pw}">
                        </td>
                    </tr>
                    <tr>
                        <th><label for="pwChk" class="form-label" id="pwChkLabel">비밀번호 확인</label></th>
                        <td>
                        	<input type="password" name="pwChk" id="pwChk" placeholder="비밀번호를 한번 더 입력하세요" class="form-control" value="${patient.pw}">
                        	<span class="chkResult" id="pwChkSpan"></span>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="tel" class="form-label">연락처</label></th>
                        <td><input type="text" class="form-control" id="tel" value="${patient.tel}" name="tel"></td>
                    </tr>
                    <tr>
                        <th>주소</th>
                        <td class="post">
                            <input type="text" id="sample6_postcode" name="postcode" class="form-control" value="${patient.postcode}" readonly>
                            <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" id="postcodeBtn">
                            <input type="text" id="sample6_address" name="address" class="form-control"
                                value="${patient.address}">
                            <input type="text" id="sample6_detailAddress" name="address2" class="form-control"
                                value="${patient.address2}">
                        </td>
                    </tr>
                    <tr>
                        <th>성별</th>
                        <td>
                            ${patient.gender}
                        </td>
                    </tr>
                    <tr>
                        <th>생년월일</th>
                        <td>1998-04-14</td>
                    </tr>
                    <tr>
                        <th>이메일</th>
                        <td><input type="email" name="email" id="email" class="form-control" value="${patient.email}">
                        </td>
                    </tr>
                </table>
                <div>
                    <button type="submit" id="save">저장</button>
                    <button type="button" id="cancel" onclick="location.href = 'index.jsp'">취소</button>
                    <button type="button" id="out" onclick="location.href = 'patient_delete?pcode=${patient.pcode}'">탈퇴</button>
                </div>
            </form>           
        </div>
    </div>
    </div>
    <footer><jsp:include page="../common/footer.jsp"></jsp:include></footer>
</div>
</body>
</html>