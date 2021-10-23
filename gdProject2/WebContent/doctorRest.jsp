<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
        <link rel="stylesheet" href="css/default.css" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>

        <!-- fullcalendar CDN -->
        <link href="https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css" rel="stylesheet"/>
        <script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js"></script>
        <!-- fullcalendar 언어 CDN -->
        <script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js"></script>
    <script>

      document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
        	height: '700px', // calendar 높이 설정
        	headerToolbar: {
        		left: 'prev',
        		center: 'title',
        		right: 'next'
        		},
          initialView: 'dayGridMonth',
          navLinks: false, // 날짜를 선택하면 Day 캘린더나 Week 캘린더로 링크
          editable: false, // 수정 가능?
          selectable: false, // 달력 일자 드래그 설정가능
          nowIndicator: true, // 현재 시간 마크
          dayMaxEvents: true, // 이벤트가 오버되면 높이 제한 (+ 몇 개식으로 표현)
          locale: 'ko', // 한국어 설정
        });
        calendar.render();
      });

    </script>
    <style>
    	.main {
    		margin: 0 auto;
    		max-width: 1200px;
    		display: flex;
    	}
    	#calendar {
    		width: 800px;
    		margin: 20px;
    	}
    	.content {
    		margin: 20px;
    	}
    	a {
    		text-decoration: none !important;
    	}
    	.icons {
    		display: flex;
    	}
    	.icon {
    		width: 20px;
    		height: 20px;
    		border-radius: 45px;
    		margin-left: 20px;
    	}
    	#icon1 {
    		background-color: rgb(70, 145, 140);
    	}
    	#icon2 {
    		background-color: 	#FFD700;
    	}
    	#icon3 {
    		background-color: rgb(243, 243, 243);
    	}
    </style>
  </head>
  <body>
  	<jsp:include page="components/header.jsp"></jsp:include>
  	<div class = "main">
  		<jsp:include page="components/sidemenu.jsp"></jsp:include>
  		<div class = "content">
  		  	<h1>휴진 신청</h1>
    		<div id="calendar"></div>
    		<div class = "icons">
    			<div class = "icon" id = "icon1"></div> 진료일 
    			<div class = "icon" id = "icon2"></div> 승인 대기중 
    			<div class = "icon" id = "icon3"></div> 휴진 
    		</div>
    		
  		</div>
  	</div>
    <jsp:include page="components/footer.jsp"></jsp:include>
  </body>
</html>