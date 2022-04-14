<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var = "language" value ="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale.language}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="pagecontent" var="rb" />
<html lang="${language}">
<head>
<c:url
	value="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	var="bootstrap" />
<link rel="stylesheet" href="<c:out value="${bootstrap}"/>">
<c:url value="/css/style.css" var="css" />
<link rel="stylesheet" href="<c:out value="${css}"/>">
<c:url value="/img/favicon.ico" var="icon" />
<link rel="icon" href="<c:out value="${ icon }"/>">
<c:url value="index.jsp" var="main" />
<title>Dance studio</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class=page>
		<nav class="navbar navbar-expand-md bg-secondary navbar-dark">
			<a class="navbar-brand" href='<c:out value="${main}"/>'> <fmt:message
					key="main" bundle="${ rb }" /></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<div class="btn-group btn-group-lg">
					<form method="post" action="action">
						<button type="submit" class="btn btn-secondary" name="command"
							value="READALLSCHEDULE">
							<fmt:message key="schedule" bundle="${ rb }" />
						</button>
					</form>
					<form method="post" action="action">
						<button type="submit" class="btn btn-secondary" name="command"
							value="READALLTEACHER">
							<fmt:message key="teachers" bundle="${ rb }" />
						</button>
					</form>
					<form method="post" action="action">
						<button type="submit" class="btn btn-secondary" name="command"
							value="READALLMEMBERSHIPTYPES">
							<fmt:message key="membershiptypes" bundle="${ rb }" />
						</button>
					</form>
					<div class="btn-group">
						<div class="dropdown">
							<button type="button" class="btn btn-secondary dropdown-toggle"
								data-toggle="dropdown">
								<fmt:message key="enrolment" bundle="${ rb }" />
							</button>
							<div class="dropdown-menu">
								<form method="post" action="action">
									<button type="submit" class="dropdown-item btn btn-light"
										name="command" value="ENROLMENT">
										<fmt:message key="enrolment" bundle="${ rb }" />
									</button>
								</form>
								<form method="post" action="action">
									<button type="submit" class="dropdown-item btn btn-light"
										name="command" value="ENROLMENT">
										<fmt:message key="enrolment" bundle="${ rb }" />
									</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="language float-right">
				<form>
							<select id="language" name="language" onchange="submit()">
						<option value="en_US" ${language == 'en' ? 'selected' : ''}>EN</option>
						    <option value="ru_RU" ${language == 'ru' ? 'selected' : ''}>RU</option>
						    <option value="be_BY" ${language == 'be' ? 'selected' : ''}>BY</option>
					</select>
				</form>
			</div>
		</nav>
		<h1 class="mt-3 mb-3">
			<fmt:message key="membershippagetitle" bundle="${ rb }" />
		</h1>
		<table class="table mx-auto">
			<tr>
				<th><fmt:message key="membershiptitle" bundle="${ rb }" /></th>
				<th><fmt:message key="membershipquantity" bundle="${ rb }" /></th>
				<th><fmt:message key="membershipprice" bundle="${ rb }" /></th>
			</tr>
			<c:forEach var="membershipType" items="${membershipTypes}"
				varStatus="status">
				<tr>
					<td><c:out value="${membershipType.title}" /></td>
					<c:choose>
						<c:when test="${membershipType.maxClassQuantity !=  0 }">
							<td><c:out value="${membershipType.maxClassQuantity}" /></td>
						</c:when>
						<c:otherwise>
							<td>-</td>
						</c:otherwise>
					</c:choose>
					<td><fmt:formatNumber value="${membershipType.price}"
							type="currency" /></td>
				</tr>
			</c:forEach>
		</table>
		<footer class="card-footer">
			<div class="container-fluid text-center">
				<div class="row">
					<p>Copyright©2022 L`Antre Studio</p>
				</div>
			</div>
		</footer>
	</div>
</body>
</html>