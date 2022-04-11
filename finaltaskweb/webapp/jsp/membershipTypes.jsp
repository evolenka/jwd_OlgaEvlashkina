<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="be_BY" scope="session" />
<fmt:setBundle basename="pagecontent" var="rb" />
<html>
<head>
<title><fmt:message key="membershippagetitle" bundle="${ rb }" /></title>
<c:url value="favicon.ico" var="icon" />
<link rel="icon" href="<c:out value="${ icon }"/>">
<c:url value="css/style.css" var="stylesheet" />
<link rel="stylesheet" href="<c:out value="${ stylesheet }"/>">
<body>
	<h1>
		<fmt:message key="membershippagetitle" bundle="${ rb }" />
	</h1>
	<table>
		<tr>
			<th><fmt:message key="membershiptitle" bundle="${ rb }" /></th>
			<th><fmt:message key="membershipquantity" bundle="${ rb }" /></th>
			<th><fmt:message key="membershipprice" bundle="${ rb }" /></th>
		</tr>
		<c:forEach var="membershipType" items="${membershipTypes}"
			varStatus="status">
			<tr>
				<td><c:out value="${membershipType.title}" /></td>
				<td><c:out value="${membershipType.maxClassQuantity}" /></td>
				<td><c:out value="${membershipType.price}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>