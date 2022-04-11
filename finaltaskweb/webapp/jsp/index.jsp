<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="en_US" scope="session" />
<fmt:setBundle basename="pagecontent" var="rb" />
<html lang="en">
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<title>Dance studio</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<c:url value="img/favicon.ico" var="icon" />
<link rel="icon" href="<c:out value="${ icon }"/>">
<c:url value="registration.jsp" var="regLink" />
<c:url value="index.jsp" var="main"/>
<c:url value="img/bg.jfif" var="img"/>
</head>
<body>
<div class="page-title">...</div>
	<nav class="navbar navbar-expand-md bg-secondary navbar-dark">
		<a class="navbar-brand" href='<c:out value="${main}"/>'>
		<fmt:message key="main" bundle="${ rb }" /></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<div class="btn-group">
					<form method="post" action="action">
						<button type="submit" class="btn btn-light" name="command" value="READALLSCHEDULE">
							<fmt:message key="schedule" bundle="${ rb }" />
						</button>
					</form>
					<form method="post" action="action">
						<button type="submit" class="btn btn-light" name="command" value="READALLTEACHER">
							<fmt:message key="teachers" bundle="${ rb }" />
						</button>
					</form>
				<form method="post" action="action">
						<button type="submit" class="btn btn-light" name="command"
							value="READALLMEMBERSHIPTYPES">
							<fmt:message key="membershiptypes" bundle="${ rb }" />
						</button>
					</form>
				 <div class="btn-group">
				  <button type="button" class="btn btn-light dropdown-toggle" data-toggle="dropdown">
						<fmt:message key="enrolment" bundle="${ rb }" />
						</button>
				<div class="dropdown-menu">
				<form method="post" action="action">
						<button type="submit" class="btn btn-light" data-toggle="dropdown" name="command"
							value="ENROLMENT">
							<fmt:message key="enrolment" bundle="${ rb }" />
						</button>
					</form>
					<form method="post" action="action">
						<button type="submit" class="btn btn-light" data-toggle="dropdown" name="command"
							value="ENROLMENT">
							<fmt:message key="enrolment" bundle="${ rb }" />
						</button>
					</form>
		 			</div>
				</div>
			</div>
		</div>
	</nav>
	<div class="container" style="margin-top: 30px">
		<div class="row">
			<div class="col-md-2">
				<form method="post" action="action">
					<label for="login"><fmt:message key="login"
							bundle="${ rb }" /></label><br> <input type="text" id="login"
						name="login"><br> <label for="password"><fmt:message
							key="password" bundle="${ rb }" /></label><br> <input type="text"
						id="password" name="password"><br> <br>
					<button type="submit" class="btn btn-light" name="command" value="LOGINATION">
						<fmt:message key="logIn" bundle="${ rb }" />
					</button>
				</form>
				<p>
					<fmt:message key="messageregistration" bundle="${ rb }" />
					<a href='<c:out value="${regLink}"/>'><fmt:message
							key="registrationLink" bundle="${ rb }" /></a>
				</p>
			</div>
			<div class="col-md-10">
			<h2>L`Antre Studio</h2>
				<h5>Title description, Dec 7, 2017</h5>
				<div class="fakeimg">Fake Image</div>
			</div>
		</div>
	</div>
	</div>
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<p>
			<fmt:message key="footer" bundle="${ rb }" />
		</p>
	</div>
</body>
</html>


