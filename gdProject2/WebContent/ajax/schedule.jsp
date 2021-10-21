<%@ page language="java" contentType="text/xml; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page trimDirectiveWhitespaces="true" %> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version='1.0' encoding='UTF-8'?>
<schedules>
    <c:forEach var="schedule" items="${scheduleList}">
        <schedule> </schedule>
    </c:forEach>
</schedules>
