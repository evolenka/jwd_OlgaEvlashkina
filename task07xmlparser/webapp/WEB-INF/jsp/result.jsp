<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html lang="en-us">
<head>
<title>Visits</title>
<link rel="icon" href="favicon.ico">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<img src="img/banner.jpg" alt="dance">
	<c:url value="index.jsp" var="home" />
	<br>
	<a href="<c:out value="${ home }"/>">BACK</a>
	<h1>Dance studio visits</h1>
	<table>
		<tr>
			<th>N</th>
			<th>Date</th>
			<th>Time</th>
			<th>Visit status</th>
			<th>Surname</th>
			<th>Name</th>
			<th>Patronymic</th>
			<th>Phone</th>
			<th>E-mail</th>
			<th>Group</th>
			<th>Dance style</th>
			<th>Level</th>
			<th colspan="2">Teacher</th>
		</tr>
		<c:forEach var="visit" items="${visits}" varStatus="status">
			<tr>
				<td><c:out value="${ status.count }" /></td>
				<td><fmt:formatDate type="date"
						value="${visit.danceClass.date}" pattern="dd.MM.yyyy" /></td>
				<td><fmt:formatDate type="time"
						value="${visit.danceClass.schedule.time}" pattern="HH:mm" /></td>
				<td><c:out value="${visit.status}" /></td>
				<td><c:out value="${visit.client.surname}" /></td>
				<td><c:out value="${visit.client.name}" /></td>
				<td><c:out value="${visit.client.patronymic}" /></td>
				<td><c:out value="${visit.client.phone}" /></td>
				<td><c:out value="${visit.client.email}" /></td>
				<td><c:out value="${visit.danceClass.schedule.group.title}" /></td>
				<td><c:out
						value="${visit.danceClass.schedule.group.teacher.danceStyle}" /></td>
				<td><c:out value="${visit.danceClass.schedule.group.level}" /></td>
				<td><c:out
						value="${visit.danceClass.schedule.group.teacher.surname}" /></td>
				<td><c:out
						value="${visit.danceClass.schedule.group.teacher.name}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>