<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../common/bootstrapInclude.jsp"/>
<script type="text/javascript">
/* $(document).ready(function(){
	//select
	var subject = "${subject_val}";
	
	$('select option').each(function(){
		if(subject == $(this).val()){
			$(this).attr('selected','selected')
		}
	});
	
}); */
</script>
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
       	.writeButton{
       		text-align: right;
       	}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="main">
		<jsp:include page="../common/sidemenu.jsp">
        	<jsp:param name="side" value="${side}" />
        </jsp:include>
		<div class="content">
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
    		<div class="content_header">
    			<form method="post" action="qna_search">
    				<select name='searchType'>
						<option value='nickname'>작성자</option>
		  				<option value='titleContent'>제목+내용</option>
					</select>
					<input type="text" name="searchValue" placeholder="검색어를 입력해주세요" />
    				<button type = "submit" class="submitbtn">검색</button>
    			</form>
    		</div>
    		<div class="content_body">
    			<table class="table">
					<thead>
						<tr>
							<th>No.</th>
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
    		</div>
    		<div class="writeButton">
				<c:if test="${member == null}">
					<a href="qna_input" onclick="button_click()"><button type="submit" class="submitbtn">글 작성</button></a>
				</c:if>
				<c:if test="${member != null}">
					<a href="qna_input"><button type="submit" class="submitbtn">글 작성</button></a>
				</c:if>
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
							<a class="page-link" href="mg_doctor_search?reqPage=${index}">${index}</a>
						</li>
						</c:when>
					<c:otherwise>
						<li class="page-item">
							<a class="page-link" href="mg_doctor_search?reqPage=${index}">${index}</a>
						</li>
				</c:otherwise>
				</c:choose>
			</c:forEach>
		
				<c:if test="${pageGroupResult.afterPage}">
				<li class="page-item">
					<a class="page-link" href="mg_doctor_search?reqPage=${pageGroupResult.groupEndNumber+1}">after</a>
				</li>
				</c:if>
				</ul>
        	</div>
    	</div>
        
    </div>
    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>