<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	 			<td>${board.id}</td>
	 			<td>조회수 </td>
	 			<td>${board.cnt}</td>
			</tr>
			<tr>
		 		<td>제목 </td>
		   		<td>${board.subject} </td>
		 		<td>작성일 </td>
		   		<td>${board.wdate} </td>
			</tr>
			<tr class="contents_box">
				<td >
					이미지랑 내용 들어갈자리
					${board.img}
					${board.content}
		 	  	</td>
			</tr>
			</tbody>	
	   	</table>
	   	<br/>
	   	<div id="button">
	   		<div class="button">
	   		<input type="submit" value="수정">
	   		</div>
	   	</div>
	    <div class="button">
	    	<a href="board_delete?boardno=${board.no}"><button class="button">삭제</button></a>
	    </div>
	</div>
</body>
</html>