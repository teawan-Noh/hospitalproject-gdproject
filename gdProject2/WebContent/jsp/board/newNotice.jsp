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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/updateNotice.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#update").click(function(){
		//제목
		var title_value = $("#title").val();
		
		if(!title_value){
			alert("제목을 입력해주세요.")
			$("#title").focus();
			return false;
		}
		
		//내용
		var content_value = $("#content").val();
		
		if(!content_value){
			alert("내용을 입력해주세요.")
			$("#content").focus();
			return false;
		}
		
		alert("글이 등록되었습니다.");
	});
});
</script>
<title>공지사항 등록</title>
</head>
<body>
	<div id="main">
        <div class="container">
            <section id="bigTitle">
                <h2>공지사항 등록</h2>
            </section>
            <section id="form" class="form-group">
            	<form action="notice_save" method="post" id="form" enctype="multipart/form-data">
            		<label>파일첨부 : <input type="file" name="filename" /></label>
            			<div id="titleDiv">
                        <label for="title" class="form-label smallTitle">제목</label>
                        <input type="text" name="title" id="title" class="form-control" placeholder="제목을 입력하세요.">
                    </div>
                    <div id="contentDiv">
                        <label for="content" class="form-label smallTitle">내용</label>
                        <textarea name="content" id="content" cols="30" rows="10" class="form-control"placeholder="내용을 입력하세요."></textarea>
                    </div>
                    <button type="submit" id="update">등록</button>
                    <button type="button" id="cancle" onclick="location.href='notice_list?reqPage=1'">취소</button>
                </form>
            </section>
            
        </div>
        
    </div>
</body>
</html>