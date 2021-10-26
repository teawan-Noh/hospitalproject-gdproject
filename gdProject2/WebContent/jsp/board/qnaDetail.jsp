<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../common/bootstrapInclude.jsp"/>
<style>
	.table{
		text-align: center;
	}
	.showList, #button{
		text-align: right;
	}
	.contents_box{
		width: 100%;
	}
	.modify_delete_button{
		display: flex;
		justify-content: flex-end;
	}
	.coment_box{
		display: flex;
		width: 100%;
	}
	.coment_input{
		width: 90%;
	}
	.comment_box{
		display: flex;
	}
	
</style>
</head>
<body>
	<div class="container mt-3">
		<div class="show_path">
    		<i class="fas fa-home"></i>
    		<i class="fas fa-chevron-right"></i>
    		소통정보
    		<i class="fas fa-chevron-right"></i>
			Q&A
    	</div>
    	<div class="show_class">
    		<h2>Q&A 게시판</h2>
    	</div>	
		<table border="1" class="table">
		<tbody>
			<tr>
		   		<td>작성자 </td>
	 			<td>${qnadetail.nickname}</td>
	 			<td>조회수 </td>
	 			<td>${qnadetail.cnt}</td>
			</tr>
			<tr>
		 		<td>제목 </td>
		   		<td>${qnadetail.title} </td>
		 		<td>작성일 </td>
		   		<td>
		   			<fmt:parseDate value="${qnadetail.writedate}" var="dateFmt" pattern="yyyy-MM-dd HH:mm:ss"/>
			    	<fmt:formatDate value="${dateFmt}"  pattern="yyyy-MM-dd"/>
		   		</td>
			</tr>
			<tr class="contents_box">
				<td >
					${qnadetail.img}
					${qnadetail.content}
		 	  	</td>
			</tr>
			</tbody>	
	   	</table>
	   	<br/>
	   	<div class="modify_delete_button">
		   	<div class="button">
		   		<div class="button">
		   		<input type="submit" value="수정">
		   		</div>
		   	</div>
		    <div class="button">
		    	<a href="qna_delete?qno=${qnadetail.qno}"><button class="button">삭제</button></a>
		    </div>
	    </div>
	    <form method="post" action="board_modify">
	    <div class="coment_box">
	    	<div class="coment_input">
	    		<input class="coment_input" type="text" name="coment" placeholder="내용을 입력해주세요"/>
	    	</div>
	    	<div>
	    		<input class="button" type="submit" value="등록">
	    	</div>
	    </div>
	    </form>
	    <div>
	    	답변
	    </div>
	    <div class="comment_box">
	    	<div>${qnadetail.ccontent}</div>
	    	<div>${qnadetail.id}</div>
	    	<div>
	    		<fmt:parseDate value="${qnadetail.cwritedate}" var="dateFmt2" pattern="yyyy-MM-dd HH:mm:ss"/>
			    <fmt:formatDate value="${dateFmt2}"  pattern="yyyy-MM-dd"/>
	    	</div>
	    </div>
	</div>
</body>
</html>