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
<c:url
	value="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	var="bootstrap" />
<link rel="stylesheet" href="<c:out value="${bootstrap}"/>">
<c:url value="/css/style.css" var="css" />
<link rel="stylesheet" href="<c:out value="${css}"/>">

<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script
	src="//ajax.aspnetcdn.com/ajax/jquery.ui/1.10.3/jquery-ui.min.js"></script>
<c:url value="img/favicon.ico" var="icon" />
<link rel="icon" href="<c:out value="${ icon }"/>">
<c:url value="registration.jsp" var="regLink" />
<c:url value="login.jsp" var="login" />
<c:url value="index.jsp" var="main" />
<c:url value="enrollment.jsp" var="enrollment" />
<title>Dance studio</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript">
	$(function() {

		$('#datepicker').datepicker();

	});
</script>
</head>
<body>
	<!--<script>
$(function(){
	$("#datepicker").datepicker({
	    beforeShowDay: function(date) {
	        var day = date.getDay();
	        return [(day != 1 && day != 2), ''];
	    }
	});
</script>-->
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
		<h2 class="mt-3 mb-3">
			<fmt:message key="firstStep" bundle="${ rb }" />
		</h2>
	    <c:if test="${not empty styles}">
		<form method="post" action="action">
			<c:forEach var="style" items="${styles}">
				<input type="radio" id="style" name="style" value="${style}"
					required>
				<label for="style"> <c:out value="${style}" /></label>
				<br>
			</c:forEach>
			<a class="btn btn-light" href='<c:out value="${enrollment}"/>'> <fmt:message
					key="back" bundle="${ rb }" /></a>
			<button type="submit" class="btn btn-light" name="command"
				value="READGROUPBYSTYLE">
				<fmt:message key="next" bundle="${ rb }" />
			</button>
		</form>
		</c:if>
		 <c:if test="${not empty levels}">
		<form method="post" action="action">
			<c:forEach var="level" items="${levels}">

				<input type="radio" id="level" name="level" value="${level}"
					required>
				<label for="level"> <c:out value="${level}" /></label>
				<br>
			</c:forEach>
			<a class="btn btn-light" href='<c:out value="${enrollment}"/>'> <fmt:message
					key="back" bundle="${ rb }" /></a>
			<button type="submit" class="btn btn-light" name="command"
				value="READGROUPBYLEVEL">
				<fmt:message key="next" bundle="${ rb }" />
			</button>
		</form>
		</c:if>
		 <c:if test="${not empty weekdays}">
			<form method="post" action="action">
			<c:forEach var="weekday" items="${weekdays}">

				<input type="checkbox" id="weekday" name="weekday"
					value="${weekday}">
				<label for="weekday"> <fmt:message key="${weekday}"
						bundle="${ rb }" /></label>
				<br>
			</c:forEach>
			<a class="btn btn-light" href='<c:out value="${enrollment}"/>'> <fmt:message
					key="back" bundle="${ rb }" /></a>
			<button type="submit" class="btn btn-light" name="command"
				value="READGROUPBYSCHEDULE">
				<fmt:message key="next" bundle="${ rb }" />
			</button>
		</form>
		</c:if>

			<input type="text" id="datepicker" name="command"
				value="READGROUPBYDATE" required> <a class="btn btn-light"
				href='<c:out value="${enrollment}"/>'> <fmt:message key="back"
					bundle="${ rb }" /></a> <input type="submit" class="btn btn-light"
				value="<fmt:message
								key="next" bundle="${ rb }" />">
		

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