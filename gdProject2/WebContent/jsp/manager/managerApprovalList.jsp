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
        		<h1>승인관리</h1>
        	</div>
    		<div class = "content_header">
    			<form method="post" action="mg_approval_search">
    				<input type="text" name="search" placeholder="이름으로 검색" />
    				<button type = "submit" id="submitbtn">검색</button>
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
    					<c:forEach var="approval" items="${approvalList}">
    						<tr>
    							<td>${approval.acode}</td>
    							<td>${approval.dname}</td>
    							<fmt:parseDate value="${approval.approvedate}" var="dateFmt" pattern="yyyy-MM-dd HH:mm:ss"/>
			      				<td><fmt:formatDate value="${dateFmt}"  pattern="yyyy-MM-dd"/></td>
    							<td>${approval.approved}</a></td>
    						</tr>
    					</c:forEach>
    				</tbody>
    			</table>
    		</div>
    		<!-- 페이지처리 -->
        	<div>
        		<ul class="pagination pagination-sm justify-content-center" style="margin:20px 0">
					<c:if test="${pageGroupResult.beforePage}">
						<li class="page-item"><a class="page-link" href="memo_search?reqPage=${pageGroupResult.groupStartNumber-1}">before</a></li>
					</c:if>
					<c:forEach var="index" begin="${pageGroupResult.groupStartNumber}" end="${pageGroupResult.groupEndNumber}">
					<c:choose>
						<c:when test="${pageGroupResult.selectPageNumber == index}">
						<li class="page-item active">
							<a class="page-link" href="memo_search?reqPage=${index}">${index}</a>
						</li>
						</c:when>
					<c:otherwise>
						<li class="page-item">
							<a class="page-link" href="memo_search?reqPage=${index}">${index}</a>
						</li>
				</c:otherwise>
				</c:choose>
			</c:forEach>
		
				<c:if test="${pageGroupResult.afterPage}">
				<li class="page-item">
					<a class="page-link" href="memo_search?reqPage=${pageGroupResult.groupEndNumber+1}">after</a>
				</li>
				</c:if>
				</ul>
        	</div>
    	</div>
        
    </div>
    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>