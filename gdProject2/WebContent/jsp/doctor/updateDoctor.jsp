<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
$("input[name='pwdchk']").focusout(function(){
	var pwd_value = $("input[name='pwd']").val().replace(/\s/gi, "");
	var pwdchk_value = $("input[name='pwdchk']").val().replace(/\s/gi, "");
	
	//비밀번호 유효성 검사
	var regulPw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$/;;
	var regResult = regulPw.test(pwd_value);
	
	if(!regResult){
		alert("영어 대소문자,숫자,특수문자 포함해서 8자리에서 20자리 사이로 입력해주세요.");
		$("input[name='pwd']").val('');
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

//수정 버튼을 눌렀을때 나머지 유효성 검사
$("#updatebtn").click(function(){
	
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
	
	alert("수정되었습니다.");
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
        input {
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
            border-bottom: 1px solid rgb(223, 220, 220);
            padding-top: 0;
            border-collapse: collapse;
        }

        th {
            background-color: rgb(148, 220, 215);
            margin: 0;
            padding: 10px;
            color: #555;
            font-size: 0.9rem;
            width: 150px;
        }
        tr {
            background-color: white;
            height: 45px;
        }
        td {
            padding: 5px;
        }
        .post input {
            margin-bottom: 5px;
        }

        #updatebtn {
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
	<div class = "main">
		<jsp:include page="../common/sidemenu.jsp"></jsp:include>
		<div class ="content">
		<ul class="fmenu">
    		<li><div class="home-img"></div></li>
    		<li>마이페이지</li>
    		<li>개인정보수정</li>
    	</ul>
    	<h1>개인정보수정</h1>
    	<c:forEach var="doctor" items="${doctor}">
        	<form method="post" action="doctor_update?dcode=${doctor.dcode}">
            	<table border="1px solid">
                <tr>
                    <th>성명</th>
                    <td>${doctor.name}</td>
                </tr>
                <tr>
                    <th>면허번호</th>
                    <td>${doctor.licenseno}</td>
                </tr>
                 <tr>
                    <th>진료과</th>
                    <td>${doctor.sname}</td>
                </tr>
                <tr>
                    <th>아이디</th>
                    <td>${doctor.id}</td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td><input type="password" name="pwd" value = "${doctor.pw}"></td>
                </tr>
                <tr>
                    <th>비밀번호 확인</th>
                    <td>
                    	<input type="password" name="pwdchk" value = "${doctor.pw}">
                    	<span class="chkResult" id="pwChkSpan"></span>
                    </td>
                </tr>
                <tr>
                    <th>주소</th>
                    <td class = "post">
                        <input type="text" id="sample6_postcode" name = "postcode" value = "${doctor.postcode}" readonly>
                        <input type="button" id="postbtn" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
                        <input type="text" id="sample6_address" name = "address" value="${doctor.address}"><br>
                        <input type="text" id="sample6_detailAddress" name = "address2" value="${doctor.address2}"><br>
                        
                    </td> 
                </tr>
                <tr>
                    <th>생년월일</th>
                    <td>${doctor.birth}</td>
                </tr>
                <tr>
                    <th>경력사항</th>
                    <td>
                        <textarea name="career" rows="5" cols="75">${doctor.career}</textarea>    
                    </td>
                </tr>
                <tr>
                    <th>휴대폰</th>
                    <td><input type = "tel" name = "tel" value="${doctor.tel}"></td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td><input type="email" name="email" value="${doctor.email}"></td>
                </tr>
            </table>
            
            <div>
            	<button type = "submit" id = "updatebtn">수정</button>
            	<button type = "button" id = "cancel" onclick="location.href = 'index.jsp'">취소</button>
            </div>
        </form>
        </c:forEach>
        </div>
    </div>
    <jsp:include page="../common/footer.jsp"></jsp:include>
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