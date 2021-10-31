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
    		<div class = "content_header">
    			<form method="post" action="mg_rest_search">
    				<input type="text" name="search" placeholder="이름으로 검색" />
    				<button type = "submit" class="submitbtn">검색</button>
    			</form>
    		</div>
    		<div class = "content_body">
    			<table class="table">
    				<thead>
    					<tr>
    						<th>No.</th>
    						<th>신청자</th>
    						<th>신청일</th>
    						<th>상태</th>
    					</tr>
    				</thead>
    				<tbody>
    					<c:forEach var="rest" items="${restList}">
    						<tr>
    							<td>${rest.rcode}</td>
    							<td>${rest.dname}</td>
    							<fmt:parseDate value="${rest.requestdate}" var="dateFmt" pattern="yyyy-MM-dd HH:mm:ss"/>
			      				<td><fmt:formatDate value="${dateFmt}"  pattern="yyyy-MM-dd"/></td>
    							<td><a href="mg_rest_detail?rcode=${rest.rcode}">${rest.approved}</a></td>
    						</tr>
    					</c:forEach>
    				</tbody>
    			</table>
    		</div>
    	</div>
        
    </div>
    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>