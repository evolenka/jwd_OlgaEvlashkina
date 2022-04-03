<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="be_BY" scope="session" />
<fmt:setBundle basename="pagecontent" var="rb" />
<html>
<head>
<title><fmt:message key="title" bundle="${ rb }" /></title>
<link rel="icon" href="favicon.ico">
<link rel="stylesheet" href="css/style.css">
<body>
	<form method="post" action="action">
		<button type="submit" name="command" value="READALLSCHEDULE">
			<fmt:message key="schedule" bundle="${ rb }" />
		</button>
	</form>
	<form method="post" action="action">
		<button type="submit" name="command" value="READALLTEACHER">
			<fmt:message key="teachers" bundle="${ rb }" />
		</button>
	</form>
	<form method="post" action="action">
		<button type="submit" name="command" value="READALLMEMBERSHIPTYPES">
			<fmt:message key="membershiptypes" bundle="${ rb }" />
		</button>
	</form>
	<form method="post" action="action">
		<button type="submit" name="command" value="READALLCLIENT">
			<fmt:message key="clients" bundle="${ rb }" />
		</button>
	</form>
</body>
</html>
