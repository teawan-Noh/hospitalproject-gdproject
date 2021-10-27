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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/patientLogin.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript">
    $(function(){
    	$("#login").click(function(){
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
    	});
    });
    </script>
</head>

<body>
        <header><jsp:include page="../common/header.jsp"></jsp:include></header>
        <div id="main">
            <div id="border">
                <section id="title" class="login_title">
                    <h1>로그인</h1>
                    <p>회원 정보를 입력해주세요.</p>
                </section>
                <section id="form" class="form-group">
                    <form action="patient_login" method="post" name="plogin">
                        <div class="mb-3">
                            <label for="id" class="form-label smallTitle">아이디</label><br>
                            <input type="text" name="id" placeholder="아이디를 입력하세요" class="form-control" id="id"/>
                        </div>
                        <div class="mb-3">
                            <label for="pw" class="form-label smallTitle">비밀번호</label><br>
                            <input type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요" class="form-control">
                        </div>
                        <span id="message">${message}</span>
                            <input type="submit" value="로그인" id="login" name="login"/>
                        <button type="button" onclick="location.href='index.jsp'" id="toMain">메인페이지로</button>
                    </form>
                </section>
            </div>
        </div>
        <footer><jsp:include page="../common/footer.jsp"></jsp:include></footer>
    </div>
</body>

</html>