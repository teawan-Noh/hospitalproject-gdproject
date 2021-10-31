<%@ page language="java" contentType="text/xml; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page trimDirectiveWhitespaces="true" %> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version='1.0' encoding='UTF-8'?>
<schedules>
    <c:forEach var="schedule" items="${scheduleList}">
        <schedule>
        	<c:if test="${schedule.restdate != null}">
        		<restdate>${schedule.restdate}</restdate>
        	</c:if>
        	<c:if test="${schedule.day != null}">
        		<day>${schedule.day}</day>
        	</c:if>
        </schedule>
    </c:forEach>
    
    
    <reservation>
    <c:forEach var="rsv" items="${rsvdates}">
        		<rsv>${rsv}</rsv>
    </c:forEach>
    </reservation>
    
    
    <c:forEach var="wait" items="${waitList}">
    	<waitSchedule>
    		<restdatewait>${wait.restdate}</restdatewait>
       	</waitSchedule>
    </c:forEach>
    <c:forEach var="den" items="${denList}">
    	<denSchedule>
    		<restdateden>${den.restdate}</restdateden>
       	</denSchedule>
    </c:forEach>
</schedules>
