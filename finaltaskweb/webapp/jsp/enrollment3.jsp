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
<c:url value="img/favicon.ico" var="icon" />
<link rel="icon" href="<c:out value="${ icon }"/>">
<c:url value="registration.jsp" var="regLink" />
<c:url value="login.jsp" var="login" />
<c:url value="index.jsp" var="main" />
<c:url value="enrollment.jsp" var="enrollment" />
<c:url value="enrollment3.jsp" var="enrollment3" />
<c:url value="login.jsp" var="login" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Dance studio</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>

</head>
<body>
<script type= "text/javascript">
$(document).ready(function(){
	
	   $('#datepicker').datepicker();
});	  
	</script>
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
			<fmt:message key="thirdStep" bundle="${ rb }" />
		</h2>
		<p>Подтвердите запись на <c:out value="${date}"/> в группу <c:out value="${group.title}"/> 
		</p>
	
<form method="post" action="action">
		<table class="table mx-auto">
		<tr>
		
				<th><fmt:message key="date" bundle="${ rb }" /></th>
				<th id=group class="rowgroup"><fmt:message
								key="group" bundle="${ rb }" /></th>
						<th id=group class="rowgroup"><fmt:message
								key="style" bundle="${ rb }" /></th>
						<th id=group class="rowgroup"><fmt:message
								key="level" bundle="${ rb }"/></th>
						<th id=group class="rowgroup"><fmt:message
								key="teacher" bundle="${ rb }" /></th>
						<th id=group class="rowgroup"><fmt:message
								key="time" bundle="${ rb }" /></th>
					
				<th id=group class="rowgroup"><fmt:message key="membershipstartdate" bundle="${ rb }" /></th>
				<th id=group class="rowgroup"><fmt:message key="membershipenddate" bundle="${ rb }" /></th>
			</tr>
			
				<tr>
				<td class="pt-3"><c:out value="${date}" /></td>
				<td class="pt-3"><c:out value="${group.title}" /></td>
				<td class="pt-3"><c:out value="${group.teacher.danceStyle}" /></td>
								<td class="pt-3"><c:out value="${group.level}"/></td>
								<td class="pt-3"><c:out value="${group.teacher.surname}" /> <c:out value="${group.teacher.name}" /></td>
								<td class="pt-3"><c:out value="${group.schedule[0].time}" /></td>
								<td class="pt-3"><c:out value="${membership.startDate}" /></td>
								<td class="pt-3"><c:out value="${membership.endDate}" /></td>
						
				</tr>

	</table>
	<button type="submit" class="btn btn-light" name="command"
				value="CREATEVISIT">
				<fmt:message key="confirm" bundle="${ rb }" />
			</button>
	</form>
	<p><c:out value="${noSession}"/></p>
	<p><c:out value="${successVisitMessage}"/><c:out value="${errorVisitMessage}" /></p>
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