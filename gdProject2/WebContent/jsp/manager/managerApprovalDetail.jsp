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
        #date{
        	width: 300px;
        	height: 50px;
        	border: 1px solid rgb(243, 243, 243);
        	border-radius: 5px;
       	}
       	#submitbtn {
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
        		업무관리
        		<i class="fas fa-chevron-right"></i>
        		승인관리
        	</div>
    		<div class="content_class">
        		<h2>승인관리</h2>
        	</div>
    		
    		<div class = "content_body">
    			<table border="1" class="table">
					<tbody>
						<tr>
		   					<td>작성자 </td>
	 						<td>${qnadetail.nickname}</td>
						</tr>
						<tr>
		   					<td>작성일</td>
		   					<td>
		   						<fmt:parseDate value="${qnadetail.writedate}" var="dateFmt" pattern="yyyy-MM-dd HH:mm:ss"/>
			    				<fmt:formatDate value="${dateFmt}"  pattern="yyyy-MM-dd"/>
		   					</td>
						</tr>
						<tr>
		 					<td>휴진기간</td>
		   					<td>
		   						<fmt:parseDate value="${qnadetail.writedate}" var="dateFmt" pattern="yyyy-MM-dd HH:mm:ss"/>
			    				<fmt:formatDate value="${dateFmt}"  pattern="yyyy-MM-dd"/>
		   					</td>
						</tr>
						<tr>
		   					<td>사유 </td>
	 						<td>${qnadetail.nickname}</td>
						</tr>
					</tbody>	
	   			</table>
    		</div>
    		<div class="approve_reject_button">
    			<button type = "submit" id="submitbtn">승인</button>
    			<a href="qna_delete?qno=${qnadetail.qno}">
    				<button type = "submit" id="submitbtn">거절</button>
		   		</a>
	    	</div>
        </div>
    </div>
    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>