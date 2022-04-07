<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="be_BY" scope="session" />
<fmt:setBundle basename="pagecontent" var="rb" />
<html>
<head>
<title><fmt:message key="schedule" bundle="${ rb }" /></title>
<c:url value="favicon.ico" var="icon" />
<link rel="icon" href="<c:out value="${ icon }"/>">
<c:url value="css/style.css" var="stylesheet" />
<link rel="stylesheet" href="<c:out value="${ stylesheet }"/>">
<body>
	<h1>
		<fmt:message key="schedule" bundle="${ rb }" />
	</h1>
	<table>
		<tr>
			<th><fmt:message key="weekday" bundle="${ rb }" /></th>
			<th><fmt:message key="time" bundle="${ rb }" /></th>
			<th><fmt:message key="duration" bundle="${ rb }" /></th>
		</tr>
		<c:forEach var="schedule" items="${schedule}"
			varStatus="status">
			<tr>
				<td><c:out value="${schedule.weekDay}" /></td>
				<td><c:out value="${schedule.time}" /></td>
				<td><c:out value="${schedule.duration}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>