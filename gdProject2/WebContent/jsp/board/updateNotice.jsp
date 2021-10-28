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
			alert("제목을 입력해주세요.")
			$("#content").focus();
			return false;
		}
		
		
		var result = confirm('수정하시겠습니까?');
		
		if(result) {
			alert('수정되었습니다.');
			location.replace('notice_list?reqPage=1');
		}else{
			alert('취소되었습니다.');
			location.replace('notice_list?reqPage=1');
		}
	});
	
});
</script>
<title>공지사항 수정</title>
</head>
<body>

	<div id="main">
        <div class="container">
            <section id="bigTitle">
                <h2>게시글 수정</h2>
            </section>
            <section id="form" class="form-group">
            <c:forEach var="detail" items="${detail}">
            	<form action="notice_update" method="post" id="form" enctype="multipart/form-data">
            		<label>파일첨부 : <input type="file" name="filename"/></label>
            			<div id="titleDiv">
                        <label for="title" class="form-label smallTitle">제목</label>
                        <input type="text" name="title" id="title" class="form-control" value="${detail.title}">
                        <input type="text" name="ncode" id="ncode" class="form-control" value="${ncode}" hidden="hidden">
                    </div>
                    <div id="contentDiv">
                        <label for="content" class="form-label smallTitle">내용</label>
                        <textarea name="content" id="content" cols="30" rows="10" class="form-control">${detail.content}</textarea>
                    </div>
                    <button type="submit" id="update">수정</button>
                    <button type="button" id="cancle" onclick="location.href='notice_list?reqPage=1'">취소</button>
                </form>
                </c:forEach>
            </section>
            
        </div>
    </div>
</body>
</html>