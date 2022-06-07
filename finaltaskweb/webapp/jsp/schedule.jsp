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
<c:url value="enrollment.jsp" var="enrollment" />

<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

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
		<h1 class = mt-3>
			<fmt:message key="schedule" bundle="${ rb }" />
		</h1>
		<div class="table-responsive">
			<table>
				<tr>
					<th rowspan="2"></th>
					<th id=group colspan="2" class="rowgroup">18:00</th>
					<th id=group colspan="2" class="rowgroup">19:00</th>
					<th id=group colspan="2" class="rowgroup">20:00</th>
				</tr>
				<tbody>
					<tr>
						<th rowspan="3"><fmt:message key="MONDAY" bundle="${ rb }" /></th>
						<c:forEach var="scheduleMonday" items="${scheduleMonday}">
							<td class="colgroup text-left"><span
								class="badge badge-secondary"><c:out
										value='${scheduleMonday.group.level}' /></span></td>
							<td class="colgroup pl-4 text-left"><c:out
									value="${scheduleMonday.group.title}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="scheduleMonday" items="${scheduleMonday}">
							<td class="colgroup pl-4 text-center"><c:out
									value="${scheduleMonday.group.teacher.danceStyle}" /></td>
							<td><c:out value="${scheduleMonday.duration}" /> <fmt:message
									key="min" bundle="${ rb }" /></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="scheduleMonday" items="${scheduleMonday}">
							<td class="rowgroup colgroup pl-4 pb-3 text-right font-italic"><c:out
									value="${scheduleMonday.group.teacher.surname}" /> <c:out
									value="${scheduleMonday.group.teacher.name}" /></td>
									<td/>
						</c:forEach>
					</tr>
					<tr>
						<th rowspan="3"><fmt:message key="TUESDAY" bundle="${ rb }" /></th>
						<c:forEach var="scheduleTuesday" items="${scheduleTuesday}">
							<td class="colgroup text-left"><span
								class="badge badge-secondary"><c:out
										value="${scheduleTuesday.group.level}" /></span></td>
							<td class="colgroup pl-4 text-left"><c:out
									value="${scheduleTuesday.group.title}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="scheduleTuesday" items="${scheduleTuesday}">
							<td class="colgroup pl-4 text-center"><c:out
									value="${scheduleTuesday.group.teacher.danceStyle}" /></td>
							<td><c:out value="${scheduleTuesday.duration}" /> <fmt:message
									key="min" bundle="${ rb }" /></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="scheduleTuesday" items="${scheduleTuesday}">
							<td class="rowgroup colgroup pl-4 pb-3 text-right font-italic"><c:out
									value="${scheduleTuesday.group.teacher.surname}" /> <c:out
									value="${scheduleTuesday.group.teacher.name}" /></td>
									<td/>
						</c:forEach>
					</tr>
					<tr>
						<th rowspan="3"><fmt:message key="WEDNESDAY" bundle="${ rb }" /></th>
						<c:forEach var="scheduleWednesday" items="${scheduleWednesday}">
							<td class="colgroup text-left"><span
								class="badge badge-secondary"><c:out
										value="${scheduleWednesday.group.level}" /></span></td>
							<td class="colgroup pl-4 text-left"><c:out
									value="${scheduleWednesday.group.title}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="scheduleWednesday" items="${scheduleWednesday}">
							<td class="colgroup pl-4 text-center"><c:out
									value="${scheduleWednesday.group.teacher.danceStyle}" /></td>
							<td><c:out value="${scheduleWednesday.duration}" /> <fmt:message
									key="min" bundle="${ rb }" /></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="scheduleWednesday" items="${scheduleWednesday}">
							<td class="rowgroup colgroup pl-4 pb-3 text-right font-italic"><c:out
									value="${scheduleWednesday.group.teacher.surname}" /> <c:out
									value="${scheduleWednesday.group.teacher.name}" /></td>
									<td/>
						</c:forEach>
					</tr>
					<tr>
						<th rowspan="3"><fmt:message key="THURSDAY" bundle="${ rb }" /></th>
						<c:forEach var="scheduleThursday" items="${scheduleThursday}">
							<td class="colgroup text-left"><span
								class="badge badge-secondary"><c:out
										value="${scheduleThursday.group.level}" /></span></td>
							<td class="colgroup pl-4 text-left"><c:out
									value="${scheduleThursday.group.title}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="scheduleThursday" items="${scheduleThursday}">
							<td class="colgroup pl-4 text-center"><c:out
									value="${scheduleThursday.group.teacher.danceStyle}" /></td>
							<td><c:out value="${scheduleThursday.duration}" /> <fmt:message
									key="min" bundle="${ rb }" /></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="scheduleThursday" items="${scheduleThursday}">
							<td class="rowgroup colgroup pl-4 pb-3 text-right font-italic"><c:out
									value="${scheduleThursday.group.teacher.surname}" /> <c:out
									value="${scheduleThursday.group.teacher.name}" /></td>
									<td/>
						</c:forEach>
					</tr>
					<tr>
						<th rowspan="3"><fmt:message key="FRIDAY" bundle="${ rb }" /></th>
						<c:forEach var="scheduleFriday" items="${scheduleFriday}">
							<td class="colgroup text-left"><span
								class="badge badge-secondary"><c:out
										value="${scheduleFriday.group.level}" /></span></td>
							<td class="colgroup pl-4 text-left"><c:out
									value="${scheduleFriday.group.title}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="scheduleFriday" items="${scheduleFriday}">
							<td class="colgroup pl-4 text-center"><c:out
									value="${scheduleFriday.group.teacher.danceStyle}" /></td>
							<td><c:out value="${scheduleFriday.duration}" /> <fmt:message
									key="min" bundle="${ rb }" /></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="scheduleFriday" items="${scheduleFriday}">
							<td class="colgroup pl-4 pb-3 text-right font-italic"><c:out
									value="${scheduleFriday.group.teacher.surname}" /> <c:out
									value="${scheduleFriday.group.teacher.name}" /></td>
									<td/>
						</c:forEach>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
		<footer class="card-footer">
		<div class="container-fluid text-center">
			<div class="row">
				<p>Copyright©2022 L`Antre Studio</p>
			</div>
		</div>
	</footer>
	</body>
</html>