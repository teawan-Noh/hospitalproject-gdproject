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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/noticeDetail.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	
	$("#delete").click(function(){
		var result = confirm('삭제하시겠습니까?');
		
		if(result) {
			alert('삭제되었습니다.');
			location.replace('notice_list?reqPage=1');
		}else{
			alert('취소되었습니다.');
			location.replace('notice_list?reqPage=1');
		}
		
	});
});
</script>
<title>게시글 보기</title>
</head>
<body>
    <h2>게시글 보기</h2>
    <div id="main">
    <p>첨부파일 들어갈 자리</p>
        <table class="table">
            <tbody>
            <c:forEach var="detail" items="${detail}">
            	<tr>
                    <th>제목</th>
                    <td>${detail.title}</td>
                    <th>조회수 </th>
                    <td>${detail.cnt}</td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td>${detail.name}</td>
                    <th>작성일 </th>
                    <td>${detail.writedate}</td>
                </tr>
                <tr class="contents">
                    <th>내용</th>
                    <td>${detail.content}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <c:if test="${mcode!=null}">
        	<a href="notice_update_input?ncode=${ncode}" id="update">수정</a>
			<a href="notice_delete?ncode=${ncode}" id="delete">삭제</a>
        </c:if>
        <button type="button" id="toList" name="listBtn" onclick="location.href='notice_list?reqPage=1'">목록으로</button>
    </div>
</body>
</html>