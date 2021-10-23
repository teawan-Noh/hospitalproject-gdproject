<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
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
        .content-header {
        	display: flex;
        	justify-content: space-between;
        }
        .table {
        	border-top: 2px solid rgb(70, 145, 140) !important;
        	border-bottom: 2px solid rgb(70, 145, 140) !important;
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
       		width: 100px;
       		height: 40px;
       		background-color: rgb(70, 145, 140);
       		color: white;
       		font-size: 1.2rem;
       		border:none;
       		border-radius: 5px;
       	}
</style>
</head>
<body>
	<jsp:include page="components/header.jsp"></jsp:include>
	<div class = "main">
		<jsp:include page="components/sidemenu.jsp"></jsp:include>
		<div class ="content">
    		<h1>예약정보 조회</h1>
    		<div class = "content-header">
    			<form method = "post" action = "searchDate">
    				<input type = "date" name = "date" id="date">
    				<button type = "submit" id="submitbtn">검색</button>
    			</form>
    			<h3>예약인원: 총 ${count}명</h3>
    		</div>
    		<div class = "content-body">
    			<table class="table table-hover">
    				<thead>
    					<tr>
    						<th>No.</th>
    						<th>예약일자</th>
    						<th>예약시간</th>
    						<th>환자명</th>
    					</tr>
    					<c:forEach var = "reservation" items = "${reservationList}">
    						<tr>
    							<td></td>
    							<td></td>
    							<td></td>
    							<td></td>
    						</tr>
    					</c:forEach>
    				</thead>
    			</table>
    		</div>
        </div>
    </div>
    <jsp:include page="components/footer.jsp"></jsp:include>
</body>
</html>