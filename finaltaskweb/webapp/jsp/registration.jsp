<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="en_US" scope="session" />
<fmt:setBundle basename="pagecontent" var="rb" />
<html>
<head>
<title><fmt:message key="registrationpagetitle" bundle="${ rb }" /></title>
<c:url value="favicon.ico" var="icon" />
<link rel="icon" href="<c:out value="${ icon }"/>">
<c:url value="css/style.css" var="stylesheet" />
<body>
	<h1> <fmt:message key="registrationForm" bundle="${ rb }" /></h1>
	<form method="post" action= "action">
		<label for="login"><fmt:message key="login" bundle="${ rb }" /></label><br>
		<input type="text" id="login" name="login"> <c:out value="${errorLoginMessage}"/><br>
		<label for="password"><fmt:message key="password" bundle="${ rb }" /></label><br>
		<input type="text" id="password" name="password"><br>
		<label	for="confirmPassword"><fmt:message key="confirmPassword" bundle="${ rb }" /></label><br>
	    <input type="text" id="confirmPassword" name="confirmPassword"> <c:out value="${errorPassRegMessage}" /><br>
		<label for="surname"><fmt:message key="surname" bundle="${ rb }" /></label><br>
		<input type="text" id="surname"	name="surname"><br>
		<label for="name"><fmt:message	key="name" bundle="${ rb }" /></label><br>
		<input type="text"	id="name" name="name"><br>
		<label for="patronymic"><fmt:message key="patronymic" bundle="${ rb }" /></label><br>
		<input type="text" id="patronymic" name="patronymic"><br>
		<label for="email"><fmt:message key="email" bundle="${ rb }" /></label><br>
		<input type="text" id="email" name="email"><br>
		<label for="phone"><fmt:message key="phone" bundle="${ rb }" /></label><br>
		<input type="text" id="phone" name="phone"><br>
		<button type="submit" name="command" value= "REGISTRATION">
		<fmt:message key="register" bundle="${ rb }" />
		</button>
		</form>
	<c:out value="${succesRegMessage}"/>
	<c:out value="${errorRegMessage }"/><br>
	<p> <fmt:message key="comment" bundle="${ rb }" /></p>
</body>
</html>