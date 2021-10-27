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
<title>게시글 보기</title>
</head>
<body>
    <h2>게시글 보기</h2>
    <div id="main">
    
    	<c:if test="${mcode==null}">
    		<p>첨부파일</p>
    	</c:if>
		<c:if test="${mcode!=null}">
        <form action="singleUpload" method="post" enctype="multipart/form-data">
			파일 : <input type="file" name="filename"/><br/>
			<input type="submit" value="업로드"/>
		</form>
		</c:if>
        <table class="table">
            <tbody>
            <c:forEach var="detail" items="${detail}">
            	<tr>
                    <th>제목</th>
                    	<c:if test="${mcode==null}">
                    		<td>${detail.title}</td>
                  	 	</c:if>
                    	<c:if test="${mcode!=null}">
                    		<td><input type="text" name="title" value="${detail.title}"/></td>
                    	</c:if>
                    
                    
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
                    <c:if test="${mcode==null}">
                    		<td>${detail.content}</td>
                  	 	</c:if>
                    	<c:if test="${mcode!=null}">
                    		<td><textarea name="content" cols="30" rows="10">${detail.content}</textarea></td>
                    	</c:if>
                </tr>
            </c:forEach>
                
            </tbody>
        </table>
        <c:if test="${mcode!=null}">
        	<a href="notice_update?ncode=${notice.ncode}">수정</a>
			<a href="notice_delete?ncode=${notice.ncode}">삭제</a>
        </c:if>
        
    </div>
</body>
</html>