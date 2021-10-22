<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			}else{
				$("#idChk").html("사용 불가능합니다. 다시 입력해주세요.");
			}
		});
		
	});
	
});
</script>
</head>
<body>
    <div class="container">
    <header></header>
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
                        <label for="pwChk" class="form-label smallTitle" id="pwChkLabel">비밀번호 확인</label>
                        <span class="chkResult">일치하지않습니다.</span><br>
                        <input type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요" class="form-control">
                        <input type="text" name="pwChk" id="pwChk" placeholder="비밀번호를 한번 더 입력하세요" class="form-control">
                    </div>

                    <div class="mb-3">
                        <label for="nickName" class="form-label smallTitle">닉네임</label>
                        <label for="name" class="form-label smallTitle" id="nameLabel">이름</label><br>
                        <input type="text" name="nickName" id="nickName" placeholder="닉네임을 입력하세요" class="form-control">
                        <input type="text" name="name" id="name" placeholder="이름을 입력하세요" class="form-control">
                    </div>

                    <div class="mb-3">
                        <label for="tel" class="form-label smallTitle">연락처</label>
                        <label for="radio" class="form-label smallTitle" id="genderLabel">성별</label><br>

                        <input type="text" class="form-control" id="tel" placeholder="-을 빼고 입력해주세요">

                        <span id="radios">
                            <input type="radio" id="radio" class="radio">남자
                            <input type="radio" class="radio">여자
                            <input type="radio" class="radio">기타
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
                        <input type="text" id="sample6_detailAddress" placeholder="상세주소" name="addressDetail" class="form-control"><br>
                    </div>
                    <input type="submit" value="회원가입" id="join" name="join"/>
                    <button type="button" id="cancle">취소</button>
                </form>
               
            </section>
            
        </div>

    </div>
    <footer></footer>
   </div>
</body>
</html>