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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/patient/patientLogin.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
    <div class="container">
        <header><jsp:include page="/components/header.jsp"></jsp:include></header>
        <div id="main">
            <div id="border">
                <section id="title" class="login_title">
                    <h1>로그인</h1>
                    <p>회원 정보를 입력해주세요.</p>
                </section>
                <section id="form" class="form-group">
                    <form action="login" method="post" name="plogin">
                        <div class="mb-3">
                            <label for="id" class="form-label smallTitle">아이디</label><br>
                            <input type="text" name="id" placeholder="아이디를 입력하세요" class="form-control" id="id"/>
                        </div>
                        <div class="mb-3">
                            <label for="pw" class="form-label smallTitle">비밀번호</label><br>
                            <input type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요" class="form-control">
                        </div>
                            <input type="submit" value="로그인" id="login" name="login"/>
                        <button type="button" onclick="location.href='index.jsp'" id="toMain">메인페이지로</button>
                    </form>
                </section>
            </div>
        </div>
        <footer><jsp:include page="/components/footer.jsp"></jsp:include></footer>
    </div>
</body>

</html>