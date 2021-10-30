<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/noticeList.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/8a3e72a4c8.js" crossorigin="anonymous"></script>
    <title>공지사항</title>
</head>

<body>
	<div class="container">
	<header><jsp:include page="../common/header.jsp"></jsp:include></header>
        <div id="main">
        	 <section id="searchSection">
            	<form action="notice_search" method="post" id="form">
                	<div class="content_path">
              <i class="fas fa-home"></i>
              
              <i class="fas fa-chevron-right"></i>
             공지사항
           </div>
                	<h2 id="h2">공지사항</h2>
                	<input type="search" id="nsearch" class="form-control"  name="search" placeholder="검색할 제목이나 내용을 입력해주세요." />
                	<button type="submit" id="nsearchBtn" name="searchBtn">검색</button>
                	<button type="button" id="toList" name="backBtn" onclick="location.href='notice_list?reqPage=1'">전체보기</button>
           		</form>
			 </section>
	
			<section id="tableSection">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>글번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성일</th>
                        <th>조회수</th>
                    </tr>
                </thead>
                <tbody>
    	            <c:forEach var="list" items="${searchList}">
        	        	<tr>
            	            <td>${list.ncode}</td>
                	        <td><a href="notice_detail?ncode=${list.ncode}">${list.title}</a></td>
                    	    <td>${list.name}</td>
                        	<td>${list.writedate}</td>
                        	<td>${list.cnt}</td>
                    	</tr>
                	</c:forEach>
                </tbody>
            </table>
            <c:if test="${mcode!=null}">
            	<button type="button" id="write" onclick="location.href='notice_input'">글쓰기</button>
            </c:if>
            
			</section>
		</div>
		<footer><jsp:include page="../common/footer.jsp"></jsp:include></footer>
	</div>
</body>

</html>