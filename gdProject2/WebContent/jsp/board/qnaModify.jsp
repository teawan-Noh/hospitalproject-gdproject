<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
       		width: 90px;
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
       	table tr .input_box{
       		text-align: left;
       	}
       	table tr .input_title{
       		width: 395px;
       	}
       	.approve_reject_button{
       		text-align: center;
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
        		<h2>게시글 수정</h2>
        	</div>
    		
    		<div class = "content_body">
    			<form method="post" action="qna_save" enctype="multipart/form-data">
				<table border="1" class="table">
				<tbody>
					<tr>
				   		<td>제목 </td>
				   		<td class="input_box">
							<input class="input_title" type="text" name="title" value="${qnadetail.title}"/> <br/>
						</td>
					</tr>
					<tr>
				   		<td>내용 </td>
				   		<td class="input_box"><textarea cols="50" rows="10" name="content">${qnadetail.content}</textarea> </td>
					</tr>
					<tr>
				   		<td>첨부파일 </td>
				   		<td class="input_box">
						<input type="file" name="filename"/>${qnadetail.img}<br />
				   		</td>
					</tr>
				</tbody>	
			    </table>
			    <br/>
			  	<div class="approve_reject_button">
		            <button class="submitbtn" type = "submit">수정</button>
		            <!-- <button class="submitbtn" type = "button" onclick="location.href = 'jsp/qnaList.jsp'">취소</button> -->
		        </div>
 			</form>
    		</div>
        </div>
    </div>
    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>