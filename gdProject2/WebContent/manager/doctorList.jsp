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
<style>
	.header, .writeButton{
		display: flex;
		justify-content: flex-end
		padding: 10px 0;
	}
	h1{
		padding: 10px;
		text-align: center;
	}
	.table{
		text-align: center;
	}
	a{
		color: black;
	}
	
</style>
<script type="text/javascript">
function button_click() {
	alert("로그인이 필요한 서비스 입니다");
}
</script>
</head>
<body>
	<div class="container mt-3">
		<div class="show_path">
        	<i class="fas fa-home"></i>
        	<i class="fas fa-chevron-right"></i>
        	소통정보
        	<i class="fas fa-chevron-right"></i>
        	Q&A
        </div>
        <div class="show_class">
        	<h2>Q&A</h2>
        </div>
		<div class="header">
			<div>
				<form method="post" action="board_list">
					<select name="search">
						<option value='nickname'>작성자</option>
		  				<option value='titleContent'>제목+내용</option>
					</select>
					<input type="text" name="search" placeholder="검색어를 입력해주세요" />
					<button type="submit">검색</button>
				</form>
			</div>
			
		</div>
			<table class="table table-hover">
			<thead>
				<tr>
					<th>No</th>
			      	<th>제목</th>
			      	<th>작성자</th>
			      	<th>작성일자</th>
			      	<th>조회</th>
			    </tr>
		   </thead>
		   <tbody>
		   		<c:forEach var="qna" items="${qnaList}">
			    <tr>
			      <td>${qna.qno}</td>
			      <td><a href="qna_detail?qno=${qna.qno}">${qna.title}</a></td>
			      <td>${qna.nickname}</td>
			      <fmt:parseDate value="${qna.writedate}" var="dateFmt" pattern="yyyy-MM-dd HH:mm:ss"/>
			      <td><fmt:formatDate value="${dateFmt}"  pattern="yyyy-MM-dd"/></td>
			      <td>${qna.cnt}</td>
			    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		<div class="writeButton">
			<c:if test="${member == null}">
				<a href="login_input" onclick="button_click()"><button type="submit">글 작성</button></a>
			</c:if>
			<c:if test="${member != null}">
				<a href="board_input"><button type="submit">글 작성</button></a>
			</c:if>
		</div>
	</div>
</body>
</html>