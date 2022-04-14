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
<c:url value="registration.jsp" var="regLink" />
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
			<fmt:message key="registrationForm" bundle="${ rb }" />
		</h1>
		<div class=main>
			<form method="post" action="action" class="needs-validation">

				<label for="login"><fmt:message key="login" bundle="${ rb }" /></label><br>
				<input type="text" class="form-control" id="login" name="login"
					required>
				<p class=error>
					<c:out value="${errorLoginMessage}" />
				</p>

				<label for="password"><fmt:message key="password"
						bundle="${ rb }" /></label><br> <input type="password"
					class="form-control" id="password" name="password" required>


				<label for="confirmPassword"><fmt:message
						key="confirmPassword" bundle="${ rb }" /></label><br> <input
					type="password" class="form-control" id="confirmPassword"
					name="confirmPassword" required>
				<p class=error>
					<c:out value="${errorPassRegMessage}" />
				</p>
				<label for="surname"><fmt:message key="surname"
						bundle="${ rb }" /></label><br> <input type="text"
					class="form-control" id="surname" name="surname" required>


				<label for="name"><fmt:message key="name" bundle="${ rb }" /></label><br>
				<input type="text" class="form-control" id="name" name="name"
					required> <label for="patronymic"><fmt:message
						key="patronymic" bundle="${ rb }" /></label><br> <input type="text"
					class="form-control" id="patronymic" name="patronymic"> <label
					for="email"><fmt:message key="email" bundle="${ rb }" /></label><br>
				<input type="email" class="form-control" id="email" name="email"
					required> <label for="phone"><fmt:message
						key="phone" bundle="${ rb }" /></label><br> <input type="text"
					class="form-control" id="phone" name="phone"> <br>
				<button type="submit" class="btn btn-secondary pl-3" name="command"
					value="REGISTRATION">
					<fmt:message key="register" bundle="${ rb }" />
				</button>
				<a class="btn btn-light text-dark" href='<c:out value="${regLink}"/>'><fmt:message
						key="resert" bundle="${ rb }" /></a>
			</form>
			<p class=success>
				<c:out value="${successRegMessage}" />
			</p>
			<p class=error>
				<c:out value="${errorRegMessage }" />
			</p>
			<br>
		</div>
		<p class ="ml-4">
			<fmt:message key="comment" bundle="${ rb }" />
		</p>
		<footer class="card-footer text-center fixed bottom">
			<div class="container-fluid">
				<div class="row">
					<p>Copyright©2022 L`Antre Studio</p>
				</div>
			</div>
		</footer>
	</div>
</body>
</html>