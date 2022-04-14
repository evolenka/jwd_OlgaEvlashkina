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
<c:url value="img/favicon.ico" var="icon" />
<link rel="icon" href="<c:out value="${ icon }"/>">
<c:url value="registration.jsp" var="regLink" />
<c:url value="login.jsp" var="login" />
<c:url value="index.jsp" var="main" />
<title>Dance studio</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class=index>
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
						<button type="button" class="btn btn-secondary dropdown-toggle"
							data-toggle="dropdown">
							<fmt:message key="enrolment" bundle="${ rb }" />
						</button>
						<div class="dropdown-menu">
							<form method="post" action="action">
								<button type="submit" class="btn btn-light dropdown-item"
									data-toggle="dropdown" name="command" value="ENROLMENT">
									<fmt:message key="enrolment" bundle="${ rb }" />
								</button>
							</form>
							<form method="post" action="action">
								<button type="submit" class="btn btn-light dropdown-item"
									data-toggle="dropdown" name="command" value="ENROLMENT">
									<fmt:message key="enrolment" bundle="${ rb }" />
								</button>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="dropdown">
							<form>
							<select id="language"name="language" onchange="submit()">
							<option value="en_US" ${language == 'en' ? 'selected' : ''}>EN</option>
						    <option value="ru_RU" ${language == 'ru' ? 'selected' : ''}>RU</option>
						    <option value="be_BY" ${language == 'be' ? 'selected' : ''}>BY</option>
					     </select>
				</form>
			</div>
		</nav>
		<div class="mainIndex container-fluid">
			<div class="row">
				<div class="col-md-6 col-xl-4 ">
					<form method="post" action="action">
						<label for="login"><fmt:message key="login"
								bundle="${ rb }" /></label><br> <input type="text" id="login"
							name="login"><br> <label for="password"><fmt:message
								key="password" bundle="${ rb }" /></label><br> <input
							type="password" id="password" name="password"><br> <br>
						<button type="submit" class="btn btn-secondary" name="command"
							value="LOGINATION">
							<fmt:message key="logIn" bundle="${ rb }" />
						</button>
					</form>
					<a href='<c:out value="${login}"/>'><fmt:message
							key="messagePass" bundle="${ rb }" /></a> <br>
					<fmt:message key="messageregistration" bundle="${ rb }" />
					<a href='<c:out value="${regLink}"/>'><fmt:message
							key="registrationLink" bundle="${ rb }" /></a>
				</div>
				<div class="title col-md-6 col-xl-3">
					<h1>L`Antre Studio</h1>
				</div>
				<div class="col-md-6 col-xl-5">
					<blockquote class="blockquote blockquote-custom">
						<p>"Nobody cares if you cannot dance well. Just get up and
							dance. Great dancers are great because of their passion"</p>
						<footer class="blockquote-footer"> Martha Graham </footer>
					</blockquote>
				</div>
			</div>
		</div>
		<div class="phone container-fluid">
			<div class="row">
				<div class="col-xl-12">
					<h4>+375(29) 999-000-000</h4>
					<h4>+375(44) 999-000-000</h4>
				</div>
			</div>
		</div>
		<footer class="card-footer sticky-top">
			<div class="container-fluid">
				<div class="row">
					<p>Copyright©2022 L`Antre Studio</p>
				</div>
			</div>
		</footer>
	</div>
</body>
</html>