<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<!-- css파일  -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/patient/join.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/reset.css">

<!-- 부트스트랩 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
 
<!-- 다음 우편번호 api-->
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/gdProject2/js/post.js"></script>

<!-- 자바스크립트 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	
	//아이디 중복확인
	$("#idChkBtn").click(function(){
		//사용자가 입력한 값 얻어오기
		var id_value = $("input[name='id']").val();
		//입력여부 검사
		if(!id_value){
			alert("아이디를 입력해주세요.")
			$("input[name='id']").focus();
			return false;
		}
		
		//아이디 유효성 검사
		var regulId = /^[a-zA-Z0-9]{4,20}$/;
		
		var regResult = regulId.test(id_value);
		if(!regResult){
			alert("영어 대소문자,숫자만 가능하며, 4자리에서 20자리 사이로 입력해주세요.");
			$("#idChk").html("다시 입력해주세요.");
			return false;
		}
		
		//ajax
		var url = "idcheck";
		
		$.get(url,{"id_value":id_value},function(data){
			var result_text = $(data).find("result").text();
			var result = eval(result_text);
			
			if(result){
				$("#idChk").html("사용가능한 아이디입니다.");
				$("#idChk").css({"color":"blue"});
			}else{
				$("#idChk").html("사용 불가능합니다. 다시 입력해주세요.");
			}
		});
		
	});
	
	
	
	
	//비밀번호 일치여부 판단
	$("input[name='pwChk']").focusout(function(){
		var pw_value = $("input[name='pw']").val();
		var pwChk_value = $("input[name='pwChk']").val();
		
		//비밀번호 유효성 검사
		var regulPw = /^[a-zA-Z0-9]{8,20}$/;
		var regResult = regulPw.test(pw_value);
		
		if(!regResult){
			alert("영어 대소문자,숫자만 가능하며, 8자리에서 20자리 사이로 입력해주세요.");
			$("input[name='pw']").focus();
		}
		
		//일치여부
		if(pw_value != pwChk_value){
			$("#pwChkSpan").html("일치하지 않습니다.");
			$("#pwChkSpan").css({"color":"tomato"});
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
	});
	
	//회원가입 버튼을 눌렀을때 나머지 유효성 검사
	$("#join").click(function(){
		
		//아이디
		var id_value = $("input[name='id']").val();
		
		if(!id_value){
			alert("아이디를 입력해주세요.")
			$("input[name='id']").focus();
			return false;
		}
		
		//비밀번호
		var pw_value = $("input[name='pw']").val();
		
		if(!pw_value){
			alert("비밀번호를 입력해주세요.")
			$("input[name='pw']").focus();
			return false;
		}
		
		//비밀번호 확인
		var pwChk_value = $("input[name='pwChk']").val();
		
		if(!pwChk_value){
			alert("비밀번호 확인을 입력해주세요.")
			$("input[name='pwChk']").focus();
			return false;
		}
		
		//닉네임
		var nick_value = $("input[name='nickName']").val();
		
		if(!nick_value){
			alert("닉네임을 입력해주세요.");
			$("input[name='nickName']").focus();
			return false;
		}
		
		var regulNickName = /^[a-zA-Z0-9가-힣]{2,20}$/;
		var regNickNameResult = regulNickName.test(nick_value);
		
		if(!regNickNameResult){
			alert("닉네임은 특수문자 제외 2자리 이상으로 입력해주세요.");
			$("input[name='nickName']").focus();
			return false;
		}
		
		//이름
		var name_value = $("input[name='name']").val();
		
		if(!name_value){
			alert("이름을 입력해주세요.");
			$("input[name='name']").focus();
			return false;
		}
		
		var regulName = /^[a-zA-Z가-힣]{2,20}$/;
		var regNameResult = regulName.test(name_value);
		
		if(!regNameResult){
			alert("이름은 특수문자 제외 2자리 이상으로 입력해주세요.");
			$("input[name='name']").focus();
			return false;
		}
		
		//연락처
		var tel_value = $("input[name='tel']").val();
		
		if(!tel_value){
			alert("연락처를 입력해주세요.");
			$("input[name='tel']").focus();
			return false;
		}
		
		var regulTel = /^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}/;
		var regTelResult = regulTel.test(tel_value);
		
		if(!regTelResult){
			alert("전화번호는 010-0000-0000 형식으로 입력해주세요.");
			$("input[name='tel']").focus();
			return false;
		}
		
		//성별
		var radio_checked = $("input:radio[name='gender']").is(":checked");
		if(!radio_checked){
			alert("성별을 선택해주세요.");
			return false;
		}
		
		//이메일
		var email_value = $("input[name='email']").val();
		
		if(!email_value){
			alert("이메일을 입력해주세요.");
			$("input[name='email']").focus();
			return false;
		}
		
		var regulEmail = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]{2,3}/;
		var regEmailResult = regulEmail.test(email_value);
		
		if(!regEmailResult){
			alert("이메일을 형식에 맞게 입력해주세요.");
			$("input[name='email']").focus();
			return false;
		}
		
		//생년월일
		var birth_value = $("input[name='birth']").val();
		
		if(!birth_value){
			alert("생년월일을 입력해주세요.");
			return false;
		}
		
		//우편번호
		var postcode_value = $("input[name='postcode']").val();
		
		if(!postcode_value){
			alert("우편번호를 입력해주세요.");
			$("input[name='postcode']").focus();
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
		
	});
	
	
	
});
</script>
</head>
<body>
    <div class="container">
    <header><jsp:include page="/components/header.jsp"></jsp:include></header>
    <div id="main" class="join">
        <div class="border">
            <section id="title" class="join_title">
                <h1>회원가입</h1>
                <p>회원 정보를 입력해주세요.</p>
            </section>
            <section id="form" class="form-group">
                <form action="patient_input" method="POST" name="join" id="join_form">
                    <div class="mb-3">
                        <label for="id" class="form-label smallTitle">아이디</label>
                        <span class="chkResult" id="idChk"></span>
                        <br>
                        <input type="text" name="id" placeholder="아이디를 입력하세요" class="form-control" id="id"/>
                        <button id="idChkBtn" type="button">중복확인</button>
                    </div>

                    <div class="mb-3">
                        <label for="pw" class="form-label smallTitle">비밀번호</label>
                        <span class="chkResult" id="pwSpan"></span>
                        <label for="pwChk" class="form-label smallTitle" id="pwChkLabel">비밀번호 확인</label>
                        <span class="chkResult" id="pwChkSpan"></span><br>
                        <input type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요" class="form-control">
                        <input type="password" name="pwChk" id="pwChk" placeholder="비밀번호를 한번 더 입력하세요" class="form-control">
                    </div>

                    <div class="mb-3">
                        <label for="nickName" class="form-label smallTitle">닉네임</label>
                        <label for="name" class="form-label smallTitle" id="nameLabel">이름</label><br>
                        <input type="text" name="nickName" id="nickName" placeholder="닉네임을 입력하세요" class="form-control">
                        <input type="text" name="name" id="name" placeholder="이름을 입력하세요" class="form-control">
                    </div>

                    <div class="mb-3">
                        <label for="tel" class="form-label smallTitle">연락처</label>
                        <label for="male" class="form-label smallTitle" id="genderLabel">성별</label><br>

                        <input type="text" class="form-control" id="tel" name="tel" placeholder="예시) 010-0000-0000" >

                        <span id="radios">
                            <input type="radio" name="gender" class="radio" id="male" value="male">남자
                            <input type="radio" name="gender" class="radio" id="female" value="female">여자
                            <input type="radio" name="gender" class="radio" id="other" value="other">기타
                        </span>
                        
                    </div>

                    <div class="mb-3">
                        <label for="email" class="form-label smallTitle">이메일</label>
                        <label for="birth" class="form-label smallTitle" id="birthLabel">생년월일</label><br>
                        <input type="email" name="email" id="email" placeholder="이메일을 입력하세요" class="form-control">
                        <input type="date" name="birth" id="birth" placeholder="생년월일을 입력하세요" class="form-control">
                    </div>

                    <div class="mb-3">
                        <label for="sample6_postcode" class="form-label smallTitle">주소</label><br>
                        <input type="text" id="sample6_postcode" placeholder="우편번호" name="postcode" class="form-control">
                        <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" id="postcodeBtn"><br>
                        <input type="text" id="sample6_address" placeholder="주소" name="address" class="form-control">
                        <input type="text" id="sample6_detailAddress" placeholder="상세주소" name="address2" class="form-control"><br>
                    </div>
                    <input type="submit" value="회원가입" id="join" name="join"/>
                    <button type="button" onclick="location.href='index.jsp'" id="cancle">취소</button>
                </form>
               
            </section>
            
        </div>

    </div>
    <footer><jsp:include page="/components/footer.jsp"></jsp:include></footer>
   </div>
</body>
</html>