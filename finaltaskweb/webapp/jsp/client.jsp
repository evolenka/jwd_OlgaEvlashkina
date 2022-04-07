<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="be_BY" scope="session" />
<fmt:setBundle basename="pagecontent" var="rb" />
<html>
<head>
<title><fmt:message key="clienttitle" bundle="${ rb }" /></title>
<c:url value="favicon.ico" var="icon" />
<link rel="icon" href="<c:out value="${ icon }"/>">
<c:url value="css/style.css" var="stylesheet" />
<link rel="stylesheet" href="<c:out value="${ stylesheet }"/>">
</head>
<body>
	<c:url value="img/banner.jpg" var="img" />
	<img src="<c:out value="${ img }" />" alt="dance">
	<h1>All clients</h1>
	<table>
		<tr>
			<th>N</th>
			<th>Surname</th>
			<th>Name</th>
			<th>Patronymic</th>
			<th>Phone</th>
			<th>E-mail</th>
			<th>Login</th>
		</tr>
		<c:forEach var="client" items="${clients}" varStatus="status">
			<tr>
				<td><c:out value="${ status.count }" /></td>
				<td><c:out value="${client.surname}" /></td>
				<td><c:out value="${client.name}" /></td>
				<td><c:out value="${client.patronymic}" /></td>
				<td><c:out value="${client.phone}" /></td>
				<td><c:out value="${client.email}" /></td>
				<td><c:out value="${client.login}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>