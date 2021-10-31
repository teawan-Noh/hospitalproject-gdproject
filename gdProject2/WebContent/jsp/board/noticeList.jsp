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
            	
            	<form action="notice_list" method="get" id="form">
            	<input type="hidden" name="reqPage" value="1"/>
            	<div class="content_path">
              <i class="fas fa-home"></i>
              
              <i class="fas fa-chevron-right"></i>
             공지사항
           </div>
                	<h2 id="h2">공지사항</h2>
                	<input type="search" id="nsearch" class="form-control"  name="search" placeholder="검색할 제목이나 내용을 입력해주세요." value="${search}"/>
                	<button type="submit" id="nsearchBtn">검색</button>
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
                	<c:forEach var="list" items="${noticeList}">
        	        	<tr>
            	            <td>${list.ncode}</td>
                	        <td><a href="notice_detail?ncode=${list.ncode}&pageNum=${pageGroupResult.selectPageNumber}" id="a">${list.title}</a></td>
                    	    <td>${list.name}</td>
                        	<td>${list.writedate}</td>
                        	<td>${list.cnt}</td>
                    	</tr>
                	</c:forEach>
                </tbody>
            </table>
        
            <p id="info">※제목을 클릭하면 상세조회가 가능합니다.</p>
            <c:if test="${mcode!=null}">
            	<button type="button" id="write" onclick="location.href='notice_input'">글쓰기</button>
            </c:if>
            <ul class="pagination pagination-sm">
				<c:if test="${pageGroupResult.beforePage}">
					<li class="page-item"><a class="page-link" href="notice_list?reqPage=${pageGroupResult.groupStartNumber-1}&search=${search}">이전</a></li>
				</c:if>

				<c:forEach var="index" begin="${pageGroupResult.groupStartNumber}" end="${pageGroupResult.groupEndNumber}">
					<c:choose>
						<c:when test="${pageGroupResult.selectPageNumber==index}">
							<li class="page-item active"><a class="page-link" href="notice_list?reqPage=${index}&search=${search}">${index}</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link" href="notice_list?reqPage=${index}&search=${search}">${index}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${pageGroupResult.afterPage}">
					<li class="page-item"><a class="page-link" href="notice_list?reqPage=${pageGroupResult.groupEndNumber+1}&search=${search}">다음</a></li>
				</c:if>
			</ul>
			</section>
		</div>
		<footer><jsp:include page="../common/footer.jsp"></jsp:include></footer>
	</div>
</body>

</html>