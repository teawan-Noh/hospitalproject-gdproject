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
	.showList{
		text-align: right;
	}
	.button{
		text-align: center;
	}
	.input_box{
		text-align: left;
	}
	
</style>
</head>
<body>
	<div class="container mt-3" >
		<div class="show_path">
    		<i class="fas fa-home"></i>
    		<i class="fas fa-chevron-right"></i>
    		소통정보
    		<i class="fas fa-chevron-right"></i>
       		Q&A
    	</div>
    	<div class="show_class">
    		<h2>게시글 작성</h2>
    	</div>	
		<form method="post" action="board_save" enctype="multipart/form-data">
		
		<table border="1" class="table">
		<tbody>
			<tr>
		   		<td>제목 </td>
		   		<td class="input_box">
					<input type="text" name="subject" placeholder="제목을 입력해주세요"/> <br/>
				</td>
			</tr>
			<tr>
		   		<td>내용 </td>
		   		<td class="input_box"><textarea cols="50" rows="10" name="content" placeholder="내용을 입력해주세요"></textarea> </td>
			</tr>
			<tr>
		   		<td>첨부파일 </td>
		   		<td class="input_box">
				<input type="file" name="filename"/><br />
		   		</td>
			</tr>
		</tbody>	
	    </table>
	    <br/>
	    <div class="button">
	    	<input class="button" type="submit" value="수정">
	    </div>
 	</form>
	    <div class="button">
	    	<a href="board_delete?boardno=${board.no}"><button class="button">삭제</button></a>
	    </div>
</div>
</body>
</html>