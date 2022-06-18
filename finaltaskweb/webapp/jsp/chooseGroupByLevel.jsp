<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="ctg" uri="/WEB-INF/tld/custom.tld"%>
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
<body>
	<div class="wrapper">
		<u:mainmenu />
		<div class="content conteiner-fluid">
			<div class=row>
				<div class="col-lg-2">
					<u:clientmenu />
				</div>
				<div class="col-lg-10">
					<h1 class="subtitle">
						<fmt:message key="chooseGroup.chooseByLevel" bundle="${ rb }" />
					</h1>
					<form method="post" action="action">
						<c:forEach var="level" items="${levels}">
							<input type="radio" id="level" name="level" value="${level}"
								required>
							<label for="level"> <c:out value="${level}" /></label>
							<br>
						</c:forEach>
						<button type="submit" class="btn colorBtn" name="command"
							value="READGROUPBYLEVEL">
							<fmt:message key="choose" bundle="${ rb }" />
						</button>
					</form>
					<c:if test="${not empty groups}">
						<div class="table-responsive">
							<table>
								<tr>
									<th id=group class="rowgroup"><fmt:message key="group"
											bundle="${ rb }" /></th>
									<th id=group class="rowgroup"><fmt:message key="style"
											bundle="${ rb }" /></th>
									<th id=group class="rowgroup"><fmt:message key="level"
											bundle="${ rb }" /></th>
									<th id=group class="rowgroup"><fmt:message key="teacher"
											bundle="${ rb }" /></th>
									<th id=group class="rowgroup"><fmt:message key="schedule.title"
											bundle="${ rb }" /></th>
									<th id=group class="rowgroup"><fmt:message key="time"
											bundle="${ rb }" /></th>
									<th id=group class="rowgroup"><fmt:message key="duration"
											bundle="${ rb }" /></th>
								</tr>
								<tbody>
									<c:forEach var="group" items="${groups}">
										<tr>
											<td class="pt-3"><c:out value='${group.title}' /></td>
											<td class="pt-3"><c:out
													value="${group.teacher.danceStyle}" /></td>
											<td class="pt-3"><c:out value="${group.level}" /></td>
											<td class="pt-3"><c:out value="${group.teacher.surname}" />
												<c:out value="${group.teacher.name}" /></td>
											<td class="pt-3"><c:forEach var="schedule"
													items="${group.schedule}">
													<c:out value="${schedule.weekDay}" />
													<br>
												</c:forEach></td>
											<c:set var="schedule" value="${group.schedule[0]}" />
											<td class="pt-3"><c:out value="${schedule.time}" /></td>
											<c:set var="schedule" value="${group.schedule[0]}" />
											<td class="pt-3"><c:out value="${schedule.duration}" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</c:if>
					<p>
						<c:out value="${errorNoSession}" />
					</p>
				</div>
			</div>
		</div>
		<u:footer />
	</div>
</body>
</html>