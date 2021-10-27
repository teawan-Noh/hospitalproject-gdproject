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
</head>
<style>
        .main{
        	max-width: 1200px;
 			margin: 0 auto;
        	display: flex;
        }
        .content {
        	margin: 20px;
        	width: 800px;
        }
        .content_header {
        	display: flex;
        	justify-content: space-between;
        	justify-content: flex-end;
        }
        .table {
        	border-top: 2px solid rgb(70, 145, 140) !important;
        }
        .table thead {
        	background-color: rgb(243, 243, 243) !important;
        }
       	.submitbtn {
       		width: 75px;
       		height: 28px;
       		background-color: rgb(70, 145, 140);
       		color: white;
       		font-size: 1.1rem;
       		border:none;
       		border-radius: 5px;
       	}
       	.table{
       		text-align: center;
       	}
       	table tr .subject{
       		padding-left: 30px;
       	}
       	.modify_delete_button{
       		text-align: right;
       	}
       	.comment_box{
       		display: flex;
       		justify-content: space-between;
       	}
       	.comment_box .comment_box_left{
       		width: 70%;
       	}
       	.comment_box .comment_box_right{
       		display: flex;
       		justify-content: space-between;
       		width: 25%;
       	}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class = "main">
		<jsp:include page="../common/sidemenu.jsp">
        	<jsp:param name="side" value="${side}" />
        </jsp:include>
		<div class ="content">
			<div class="content_path">
        		<i class="fas fa-home"></i>
        		<i class="fas fa-chevron-right"></i>
        		소통정보
        		<i class="fas fa-chevron-right"></i>
        		Q&A
        	</div>
    		<div class="content_class">
        		<h2>Q&A 게시판</h2>
        	</div>
    		
    		<div class = "content_body">
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
    		</div>
    		<div class="modify_delete_button">
    			<a href="qna_modify?qno=${qnadetail.qno}">
    				<button type = "submit" class="submitbtn">수정</button>
		   		</a>
    			<a href="qna_delete?qno=${qnadetail.qno}">
    				<button type = "submit" class="submitbtn">삭제</button>
		   		</a>
	    	</div>
	    	<form method="post" action="board_modify">
	    	<div class="coment_box">
	    		<input class="coment_input" type="text" name="coment" placeholder="내용을 입력해주세요"/>
	    		<button type = "submit" class="submitbtn">등록</button>
	    	</div>
	    	</form>
	    	<div>
	    		<h4>답변<h4>
	    	</div>
	    	<div class="comment_box">
	    		<div class="comment_box_left">
	    			<div>${qnadetail.ccontent}</div>
	    		</div>
	    		<div class="comment_box_right">
	    			<div>${qnadetail.id}</div>
	    			<div>
	    				<fmt:parseDate value="${qnadetail.cwritedate}" var="dateFmt2" pattern="yyyy-MM-dd HH:mm:ss"/>
			    		<fmt:formatDate value="${dateFmt2}"  pattern="yyyy-MM-dd"/>
	    			</div>
	    		</div>
	    	</div>
        </div>
    </div>
    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>