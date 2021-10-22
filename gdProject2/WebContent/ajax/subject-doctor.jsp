<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version='1.0' encoding='UTF-8'?>
<subject-doctor>
	<subject>${subject}</subject>
	<c:forEach var="doctor" items="${doctorList}">
		<doctor>
			<dcode>${doctor.dcode}</dcode>
			<name>${doctor.name}</name>
		</doctor>
	</c:forEach>
</subject-doctor>