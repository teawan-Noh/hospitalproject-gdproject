<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>여기에 제목을 입력하십시오</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"rel="stylesheet"/>
        <link rel="stylesheet" href="css/default.css" />
        <link href = "css/main.css" rel = "stylesheet" type = "text/css">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">	
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    </head>
	<body>
        <jsp:include page="jsp/common/header.jsp"></jsp:include>  
	<div class="main"> 
        <section class="sec1">

        	<c:if test="${doctor == null && manager == null }">
        		<div class = "mainmenu" style = "cursor:pointer" onclick="location.href='reservation'">
                	<h3 class="menu-title">예약</h3>
                	<p class="menu-content">진료 예약을 하실 수 있습니다.</p>
            	</div>
            	<div class = "mainmenu" style = "cursor:pointer" onclick="location.href='reservation-list?reqPage=1'">
                	<h3 class="menu-title">예약조회</h3>
                	<p class="menu-content">예약내역을 확인할 수 있습니다.</p>
            	</div>
            	<div class = "mainmenu" style = "cursor:pointer" onclick="location.href='qna_list'">
                	<h3 class="menu-title">소통정보</h3>
                	<p class="menu-content">우리 병원에 궁금한 점을 남겨주시면 담당자가 확인 후 직접 답변해드립니다.</p>
            	</div> 
            	<div class = "mainmenu" style = "cursor:pointer" onclick="location.href='doctor_search'">
                	<h3 class="menu-title">의료진정보</h3>
                	<p class="menu-content">우리 병원의 의료진 정보를 확인할 수 있습니다.</p>
            	</div>
        	</c:if>
            <c:if test="${doctor != null }">
            	<div class = "mainmenu" style = "cursor:pointer" onclick="location.href='schedule_check'">
                	<h3 class="menu-title">스케줄 조회</h3>
                	<p class="menu-content">월별 스케줄을 확인하세요.</p>
            	</div>
            	<div class = "mainmenu" style = "cursor:pointer" onclick="location.href='rest'">
                	<h3 class="menu-title">휴진 신청</h3>
                	<p class="menu-content">휴진 일정을 신청하시면 관리자가 확인 후 승인해드립니다.</p>
            	</div>
            	<div class = "mainmenu" style = "cursor:pointer" onclick="location.href='reservation-doctor-list?reqPage=1'">
                	<h3 class="menu-title">예약정보 조회</h3>
                	<p class="menu-content">예약된 환자 목록을 조회해보세요.</p>
            	</div>
            	<div class = "mainmenu" style = "cursor:pointer" onclick="location.href='doctor_search'">
                	<h3 class="menu-title">의료진정보</h3>
                	<p class="menu-content">우리 병원의 의료진 정보를 확인할 수 있습니다.</p>
            	</div>
            </c:if>
            <c:if test="${manager != null }">
            	<div class = "mainmenu" style = "cursor:pointer" onclick="location.href='mg_doctor_list'">
                	<h3 class="menu-title">의사 조회</h3>
                	<p class="menu-content">진료과 별로 의사목록을 조회할 수 있습니다.</p>
            	</div>
            	<div class = "mainmenu" style = "cursor:pointer" onclick="location.href='mg_patient_list'">
                	<h3 class="menu-title">환자 조회</h3>
                	<p class="menu-content">환자 목록을 조회할 수 있습니다.</p>
            	</div>
            	<div class = "mainmenu" style = "cursor:pointer" onclick="location.href='doctor_input'">
                	<h3 class="menu-title">의사 등록</h3>
                	<p class="menu-content">의사 선생님을 등록하세요.</p>
            	</div>
            	<div class = "mainmenu" style = "cursor:pointer" onclick="location.href='mg_rest_list'">
                	<h3 class="menu-title">스케줄 승인</h3>
                	<p class="menu-content">신청된 스케줄을 확인하시고 승인 여부를 알려주세요.</p>
            	</div>
            </c:if>
            
        </section> 
        <section class="sec2">
            <h1>진료 과목 소개</h1>
            <div class="w3-content w3-display-container">
  				<img class="mySlides" src="img/감염내과.jpg" style="width:700px">
  				<img class="mySlides" src="img/내분비대사내과.jpg" style="width:700px">
  				<img class="mySlides" src="img/성형외과.jpg" style="width:700px">
  				<img class="mySlides" src="img/소아청소년과.jpg" style="width:700px">
  				<img class="mySlides" src="img/안과.jpg" style="width:700px">
  				<img class="mySlides" src="img/알레르기내과.jpg" style="width:700px">
  				<img class="mySlides" src="img/이비인후과.jpg" style="width:700px">
  				<img class="mySlides" src="img/정형외과.jpg" style="width:700px">
  				<img class="mySlides" src="img/피부과.jpg" style="width:700px">
  				<img class="mySlides" src="img/흉부외과.jpg" style="width:700px">

  				<button class="w3-button w3-black w3-display-left" onclick="plusDivs(-1)">&#10094;</button>
 				<button class="w3-button w3-black w3-display-right" onclick="plusDivs(1)">&#10095;</button>
			</div>
        </section>
    </div>
<script>
var myIndex = 0;
carousel();
function carousel() {
  var i;
  var x = document.getElementsByClassName("mySlides");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  myIndex++;
  if (myIndex > x.length) {myIndex = 1}    
  x[myIndex-1].style.display = "block";  
  setTimeout(carousel, 3000);
}
</script>
<jsp:include page="jsp/common/footer.jsp"></jsp:include>

</body>
</html>

