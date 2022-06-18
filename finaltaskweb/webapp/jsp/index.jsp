<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u"%>
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
</head>
<body class="index">
	<div class="wrapper">
		<u:mainmenu />
		<div class="content conteiner-fluid">
			<div class="row">
				<div class="col-lg-4"></div>
				<div class="col-lg-4">
					<h1 class="title">L`Antre Studio</h1>
				</div>
				<div class="col-sm-6 col-lg-3">
					<blockquote class="blockquote blockquote-custom">
						<p>"Nobody cares if you cannot dance well. Just get up and
							dance. Great dancers are great because of their passion"</p>
						<footer class="blockquote-footer"> Martha Graham </footer>
					</blockquote>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-2 col-lg-4"></div>
				<div class="col-sm-8 col-lg-4">
					<u:login />
				</div>
			</div>
		</div>
		<u:footer />
	</div>
</body>
</html>