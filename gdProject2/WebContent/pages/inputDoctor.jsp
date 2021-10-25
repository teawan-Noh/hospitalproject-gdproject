<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 자바스크립트 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	//아이디 중복확인
	$("#idcheck").click(function(){
		//사용자가 입력한 값 얻어오기
		var id_value = $("input[name='id']").val().replace(/\s/gi, "");
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
		var url = "didcheck";
		
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
		$("#idChkBtncheck").prop("checked", true);
		
	});
	
	//비밀번호 일치여부 판단
	$("input[name='pwdchk']").focusout(function(){
		var pwd_value = $("input[name='pwd']").val().replace(/\s/gi, "");
		var pwdchk_value = $("input[name='pwdchk']").val().replace(/\s/gi, "");
		
		//비밀번호 유효성 검사
		var regulPw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$/;;
		var regResult = regulPw.test(pwd_value);
		
		if(!regResult){
			alert("영어 대소문자,숫자,특수문자 포함해서 8자리에서 20자리 사이로 입력해주세요.");
			$("input[name='pwd']").focus();
		}
		
		//일치여부
		if(pwd_value != pwdchk_value){
			$("#pwChkSpan").html("일치하지 않습니다.");
			$("#pwChkSpan").css({"color":"tomato"});
			$("input[name='pwd']").val('');
			$("input[name='pwdchk']").val('');
			$("input[name='pwd']").focus();
			return false;
		}else if(pwd_value == pwdchk_value){
			$("#pwChkSpan").html("일치합니다.");
			$("#pwChkSpan").css({"color":"blue"});
		}
		
		if(!pwd_value){
			alert("비밀번호를 입력해주세요.")
			$("#pwChkSpan").html("");
			return false;
		}
		
		if(!pwdchk_value){
			alert("비밀번호 확인을 입력해주세요.")
			$("#pwChkSpan").html("");
			return false;
		}
	});
	
	//회원가입 버튼을 눌렀을때 나머지 유효성 검사
	$("#savebtn").click(function(){
		
		//이름
		var name_value = $("input[name='name']").val().replace(/\s/gi, "");
		
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
		
		//면허번호
		var licenseno_value = $("input[name='licenseno']").val();
		
		if(!licenseno_value){
			alert("면허번호를 입력해주세요.");
			$("input[name='licenseno']").focus();
			return false;
		}
		
		var reglino = /^[0-9]{6}/;
		var reglinoResult = reglino.test(licenseno_value);
		
		if(!reglinoResult){
			alert("면허번호는 여섯자리 숫자 형태로 입력해주세요.");
			$("input[name='licenseno']").focus();
			return false;
		}
		
		//진료과
		var subject_value = $("#selectBox option:selected").val();
		
		if(subject_value == 0){
			alert("진료과를 선택해주세요.");
			return false;
		}
		
		//아이디
		var id_value = $("input[name='id']").val().replace(/\s/gi, "");
		
		if(!id_value){
			alert("아이디를 입력해주세요.")
			$("input[name='id']").focus();
			return false;
		}
		
		if($("#idChkBtncheck").is(":checked") != true){
			alert("아이디 중복검사를 해주세요.")
			return false;
		}
		
		//비밀번호
		var pwd_value = $("input[name='pwd']").val().replace(/\s/gi, "");
		
		if(!pwd_value){
			alert("비밀번호를 입력해주세요.")
			$("input[name='pwd']").focus();
			return false;
		}
		
		//비밀번호 확인
		var pwdchk_value = $("input[name='pwdchk']").val().replace(/\s/gi, "");
		
		if(!pwdchk_value){
			alert("비밀번호 확인을 입력해주세요.")
			$("input[name='pwdchk']").focus();
			return false;
		}
		
		//우편번호
		var postcode_value = $("input[name='postcode']").val().replace(/\s/gi, "");
		
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
		
		//생년월일
		var birth_value = $("input[name='birth']").val();
		
		if(!birth_value){
			alert("생년월일을 입력해주세요.");
			return false;
		}
		
		//연락처
		var tel_value = $("input[name='tel']").val().replace(/\s/gi, "");
		
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

		//이메일
		var email_value = $("input[name='email']").val().replace(/\s/gi, "");
		
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
		
		alert("가입되었습니다.");
	});
});
</script>
</head>
<style>
        .main{
        	max-width: 1200px;
        	margin: 0 auto;
        	display: flex;
        }
        .content {
        	margin: 20px;
        }
        input, #selectBox {
            width: 600px;
            height: 40px;
            border: 1px solid rgb(243, 243, 243);
            border-radius: 5px;
        }
        textarea {
        	border: 1px solid rgb(243, 243, 243);
            border-radius: 5px;
        }

        #idcheck {
            width: 100px;
            height: 35px;
            color: white;
            background-color: rgb(70, 145, 140);
            border: none;
            border-radius: 5px;
        }

        #postbtn {
            width: 140px;
            height: 35px;
            background-color: rgb(223, 220, 220);
            border: none;
            border-radius: 5px;
        }
        table {
            width: 800px;
            border-top: 4px solid rgb(70, 145, 140);
            border-left: none;
            border-right: none;
            border-bottom: 4px solid rgb(70, 145, 140);
            padding-top: 0;
            border-collapse: collapse;
        }

        th {
            background-color: rgb(148, 220, 215);
            margin: 0;
            padding: 10px;
            color: #555;
            font-size: 1.1rem;
            width: 150px;
        }
        tr {
            background-color: white;
            height: 45px;
            border-bottom: 1px solid rgb(223, 220, 220) !important;
        }
        td {
            padding: 5px;
        }
        .post input {
            margin-bottom: 5px;
        }

        #savebtn {
            width: 70px;
            height: 35px;
            color: white;
            background-color: rgb(70, 145, 140);
            border: none;
            border-radius: 3px;
            margin-top: 30px;
            margin-left: 350px;
        }
        #cancel {
        	width: 70px;
            height: 35px;
            color: white;
            background-color: rgb(70, 145, 140);
            border: none;
            border-radius: 3px;
            margin-top: 30px;
            margin-left: 20px;
        }
        #sample6_postcode{
        	width: 300px;
        }
        #id {
        	width: 230px;
        }
        .pwdform {
        	width: 300px;
        }
        
</style>
</head>
<body>
	<jsp:include page="../components/header.jsp"></jsp:include>
	<div class = "main">
		<jsp:include page="../components/sidemenu.jsp"></jsp:include>
		<div class ="content">
    	<h1>의사 등록</h1>
        	<form method="post" action="doctor_save">
            	<table>
                <tr>
                    <th>성명</th>
                    <td><input type="text" name="name" placeholder="이름을 입력해주세요."></td>
                </tr>
                <tr>
                    <th>면허번호</th>
                    <td><input type="text" name="licenseno" placeholder="의사면허번호를 입력해주세요."></td>
                </tr>
                <tr>
                    <th>진료과</th>
                    <td>
                    	<select id="selectBox" name="selectsubject">
                    		<option value = 0>진료과 선택</option>
                    		<c:forEach var="subject" items="${subjectList}">
                    			<option value = "${subject.scode}">${subject.name}</option>
                    		</c:forEach>
                    	</select>
                    </td>
                </tr>
                <tr>
                    <th>아이디</th>
                    <td>
                        <input type="text" name="id" id="id" placeholder="아이디를 입력해주세요.">
                        <button type="button" id="idcheck">중복검사</button>
                        <span class="chkResult" id="idChk"></span>
                        <input type="checkbox" id="idChkBtncheck" hidden="hidden"/>
                    </td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td><input type="password" name="pwd" class = "pwdform" placeholder="비밀번호를 입력해주세요." ></td>
                </tr>
                <tr>
                    <th>비밀번호 확인</th>
                    <td>
                    	<input type="password" name="pwdchk" class = "pwdform" placeholder="비밀번호를 다시 입력해주세요.">
                    	<span class="chkResult" id="pwChkSpan"></span>
                    </td>
                </tr>
                <tr>
                    <th>주소</th>
                    <td class = "post">
                        <input type="text" id="sample6_postcode" name="postcode" placeholder="우편번호" readonly>
                        <input type="button" id="postbtn" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
                        <input type="text" id="sample6_address" name="address" placeholder="주소"><br>
                        <input type="text" id="sample6_detailAddress" name="address2" placeholder="상세주소"><br>
                    </td> 
                </tr>
                <tr>
                    <th>생년월일</th>
                    <td>
                        <input type = "date" name = "birth">
                    </td>
                </tr>
                <tr>
                    <th>경력사항</th>
                    <td>
                        <textarea name="career" placeholder="ex) 2001~2005 대한의사협회 부회장, 2005~2007 대한의사협회 회장 형식으로  쉼표(,)로 구분하여 입력해주세요." rows="5" cols="75"></textarea>    
                    </td>
                </tr>
                <tr>
                    <th>휴대폰</th>
                    <td><input type = "tel" name = "tel" placeholder="ex)010-0000-0000 의 형식으로 입력해주세요."></td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td><input type="email" name="email" placeholder="이메일을 입력해주세요."></td>
                </tr>
            </table>
            <div>
            	<button type = "submit" id = "savebtn">저장</button>
            	<button type = "button" id = "cancel" onclick="location.href = 'index.jsp'">취소</button>
            </div>
        </form>
        </div>
    </div>
    <jsp:include page="../components/footer.jsp"></jsp:include>
        <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
    	function sample6_execDaumPostcode() {
        	new daum.Postcode({
            	oncomplete: function(data) {
             
                var addr = ''; // 주소 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>
</body>
</html>