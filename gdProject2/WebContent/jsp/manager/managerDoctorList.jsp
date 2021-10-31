<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/jsp/common/bootstrapInclude.jsp"/>
<script type="text/javascript">
$(document).ready(function(){
	//select
	var subject = "${subject_val}";
	
	$('select option').each(function(){
		if(subject == $(this).val()){
			$(this).attr('selected','selected')
		}
	});
	
	$(document).on("click", "#delete_btn", function(){
		var dcodeValue = $(this).val();
    	if(confirm("삭제하시겠습니까?") == true){
    		alert("삭제되었습니다.");
       		location.href = "mg_doctor_delete?dcode=" + dcodeValue;
    	}
    });
	
});
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
	<div class="main">
		<jsp:include page="../common/sidemenu.jsp">
        	<jsp:param name="side" value="${side}" />
        </jsp:include>
		<div class="content">
			<div class="content_path">
        		<i class="fas fa-home"></i>
        		<i class="fas fa-chevron-right"></i>
        		업무관리
        		<i class="fas fa-chevron-right"></i>
        		진료과별의사조회
        	</div>
    		<div class="content_class">
        		<h2>진료과별의사조회</h2>
        	</div>
    		<div class="content_header">
    			<form method="post" action="mg_doctor_search">
    				<select name='subject'>
						<option value='list'>진료과목</option>
						<c:forEach var="subject" items="${subjectList}">
							<option value='${subject.scode}'>${subject.name}</option>
						</c:forEach>
					</select>
    				<button type = "submit" id="submitbtn">검색</button>
    			</form>
    		</div>
    		<div class="content_body">
    			<table class="table">
    				<thead>
    					<tr>
    						<th>의사코드</th>
    						<th>성명</th>
    						<th class="subject"> 진료과</th>
    						<th>의사면허번호</th>
    						<th>계정삭제</th>
    					</tr>
    				</thead>
    				<tbody>
    					<c:forEach var="doctor" items="${doctorList}">
    						<tr>
    							<td>${doctor.dcode}</td>
    							<td>${doctor.dname}</td>
    							<td class="subject">${doctor.sname}</td>
    							<td>${doctor.licenseno}</td>
    							<td>
    								<button id="delete_btn" value="${doctor.dcode}" >삭제</button>
    							</td>
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