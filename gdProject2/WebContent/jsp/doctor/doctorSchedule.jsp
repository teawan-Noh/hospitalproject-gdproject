<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            th .fc-scrollgrid-sync-inner {
                background-color: #468c91;
            }
            a.fc-col-header-cell-cushion {
                color: white;
            }
            .fc-daygrid-day-number {
                color: #468c91;
            }
            .rest,
            .fc-day-past .fc-daygrid-day-number,
            .fc-day-today .fc-daygrid-day-number,
            .fc-day-sat div a,
            .fc-day-sun div a,
            .rest div a {
                color: #b8b8b8;
            }
            .fc .fc-daygrid-day.fc-day-today {
                background-color: rgba(255, 255, 255, 0);
            }
            .fc-h-event {
                background-color: #468c91;
            }
            .fc-header-toolbar {
                padding-top: 1em;
                padding-left: 1em;
                padding-right: 1em;
            }

    </style>
        <script>
    var dataset = [
        <c:forEach var="wait" items="${waitList}">
                {
                	title: '승인 대기',
                	start:'<c:out value="${wait.restdate}" />',
                },
        </c:forEach>
    ];
    var restdataset = [
        <c:forEach var="rest" items="${restList}">
                {
                	title: '휴진',
                	start:'<c:out value="${rest.restdate}" />',
                },
        </c:forEach>
    ];
    $(function () {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
        	height: '700px', // calendar 높이 설정
        	expandRows: true, // 화면에 맞게 높이 재설정
            slotMinTime: "00:00", // Day 캘린더에서 시작 시간
            slotMaxTime: "23:59", // Day 캘린더에서 종료 시간
        	headerToolbar: {
        		left: 'prev,next today',
        		center: 'title',
        		right: 'dayGridMonth,listWeek'
        	},
          initialView: 'dayGridMonth',
          navLinks: false, // 날짜를 선택하면 Day 캘린더나 Week 캘린더로 링크
          editable: false, // 수정 가능?
       	  selectMirror: true,
          selectable: false, // 달력 일자 드래그 설정가능
          nowIndicator: true, // 현재 시간 마크
          dayMaxEvents: true, // 이벤트가 오버되면 높이 제한 (+ 몇 개식으로 표현)
          locale: 'ko', // 한국어 설정
          eventSources : [ //이벤트 여러개 추가되는거 수정 미구현
              
               {
            	  //휴진일
            	  events : [
                      {
                    	 title: "주말",
                         daysOfWeek: ["0", "6"],  
                      }
                  ]
                  , color : "rgb(243, 243, 243)"
                  , textColor : "black"
              }
              , 
              
              {
            	  //승인 대기
            	  events : dataset,
            	  title: "승인 대기중"
                  , color : "#FFD700"
                  , textColor : "black"
              }
              , {
            	  //휴진일
            	  events : restdataset,
            	  title: "휴진"
                  , color : "rgb(243, 243, 243)"
                  , textColor : "black"
              }
          ]
          });
        calendar.render();
    });
    
    </script>
  </head>
  <body>
  	<jsp:include page="../common/header.jsp"></jsp:include>
  	<div class = "main">
  		<jsp:include page="../common/sidemenu.jsp"></jsp:include>
  		<div class = "content">
  		  	<h1>진료 스케줄 조회</h1>
    		<div id="calendar"></div>
  		</div>
  	</div>
    <jsp:include page="../common/footer.jsp"></jsp:include>
  </body>
</html>