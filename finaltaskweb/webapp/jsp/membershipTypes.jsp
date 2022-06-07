<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale.language}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="pagecontent" var="rb" />
<html lang="${language}">
<head>

<title>Dance studio</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<c:url
	value="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	var="bootstrap" />
<link rel="stylesheet" href="<c:out value="${bootstrap}"/>">
<c:url value="/css/style.css" var="css" />
<link rel="stylesheet" href="<c:out value="${css}"/>">
<c:url value="img/favicon.ico" var="icon" />
<link rel="icon" href="<c:out value="${icon}"/>">
<c:url value="registration.jsp" var="regLink" />
<c:url value="login.jsp" var="login" />
<c:url value="index.jsp" var="main" />


<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>

</head>
<body>

	<div class=page>
		<nav class="navbar navbar-expand-sm bg-secondary navbar-dark">
			<a class="navbar-brand" href='<c:out value="${main}"/>'> <fmt:message
					key="main" bundle="${ rb }" /></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">
					<li class="nav-item">
						<form method="post" action="action">
							<button type="submit" class="btn btn-secondary" name="command"
								value="READALLSCHEDULE">
								<fmt:message key="schedule" bundle="${ rb }" />
							</button>
						</form>
					</li>
					<li class="nav-item">
						<form method="post" action="action">
							<button type="submit" class="btn btn-secondary" name="command"
								value="READALLTEACHER">
								<fmt:message key="teachers" bundle="${ rb }" />
							</button>
						</form>
					</li>
					<li class="nav-item">
						<form method="post" action="action">
							<button type="submit" class="btn btn-secondary" name="command"
								value="READALLMEMBERSHIPTYPES">
								<fmt:message key="membershiptypes" bundle="${ rb }" />
							</button>
						</form>

					</li>
					<li class="btn-group">
				
							<button type="button" class="btn btn-secondary dropdown-toggle"
								data-toggle="dropdown">
								<fmt:message key="chooseGroup" bundle="${ rb }" />
							</button>
							<div class="dropdown-menu">
								<form method="post" action="action">
									<button type="submit" class="btn btn-light dropdown-item" name= "command" value="READALLSTYLE">
										<fmt:message key="byStyle" bundle="${ rb }" />
										</button>
								</form>
								<form method="post" action="action">
									<button type="submit" class="btn btn-light dropdown-item"
										name= "command" value="READALLWEEKDAY">
										<fmt:message key="byWeekDay" bundle="${ rb }" />
									</button>
									</form>
									<form method="post" action="action">							
									<button type="submit" class="btn btn-light dropdown-item"
										name="command" value="READALLLEVEL">
										<fmt:message key="byLevel" bundle="${ rb }" />
									</button>
									</form>								
							</div>
						</li>
					<li class="nav-item"><a class="btn btn-secondary"
						href='<c:out value="${enrollment}"/>'> <fmt:message
								key="enrollment" bundle="${ rb }" />
					</a></li>
				</ul>
			</div>

			<div class="dropdown">
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