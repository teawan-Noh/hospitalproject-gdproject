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
	.header, #button{
		display: flex;
		justify-content: space-between;
		padding: 10px 0;
	}
	.button{
		width: 100%;
	}
	h1{
		padding: 10px;
		text-align: center;
	}
	.table{
		text-align: center;
	}
	.showList, #button{
		text-align: right;
	}
	
</style>
</head>
<body>
	<div class="container mt-3" >	
		<form method="post" action="board_update">
			<h1>일반게시판(상세보기)</h1>
			<p class="showList"><a href="board_list">[목록보기]</a><p>
			<table border="1" class="table table-striped">
			<thead class="table-dark">
				<tr>
					<th colspan="2">상세보기</th>
				</tr>
			</thead>
			<tbody>
				<tr class="table-primary">
			   		<td>작성자 </td>
		   			<td>${board.id}
						<input type="text" name="id" value="${board.id}" hidden="hidden"/> <br/>
						<input type="text" name="no" value="${board.no}" hidden="hidden"/>
					</td>
				</tr>
				<tr>
			   		<td>제목 </td>
			   		<td><input type="text" name="subject" value="${board.subject}"> </td>
				</tr>
				<tr class="table-primary">
		   			<td>내용 </td>
		   			<td>
		   				<textarea cols="50" rows="10" name="content">${board.content}</textarea>
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
 		</form>
	    <div class="button">
	    	<a href="board_delete?boardno=${board.no}"><button class="button">삭제</button></a>
	    </div>
	</div>
</body>
</html>