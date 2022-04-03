<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html lang="en-us">
<head>
<title>Teachers</title>
<link rel="icon" href="favicon.ico">
</head>
<body>
	<br>
	<h1>All teachers</h1>
	<table>
		<tr>
			<th>N</th>
			<th>Surname</th>
			<th>Name</th>
			<th>DanceStyle</th>
			<th>Portfolio</th>
			<th>Login</th>
		</tr>
		<c:forEach var="teacher" items="${teachers}" varStatus="status">
			<tr>
				<td><c:out value="${ status.count }" /></td>
				<td><c:out value="${teacher.surname}" /></td>
				<td><c:out value="${teacher.name}" /></td>
				<td><c:out value="${teacher.danceStyle}" /></td>
				<td><c:out value="${teacher.portfolio}" /></td>
				<td><c:out value="${teacher.login}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>