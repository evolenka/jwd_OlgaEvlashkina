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
					<u:teachermenu />
				</div>
				<div class="col-lg-10">
					<h1 class="subtitle">
						<fmt:message key="markPresence.chooseDanceClass" bundle="${ rb }" />
					</h1>
					<c:if test="${not empty plannedvisit}">
						<form method="post" action="action">
							<div class="table-responsive">
								<table>
									<tr>
										<th></th>
										<th class="rowgroup"><fmt:message key="date"
												bundle="${ rb }" /></th>
										<th class="rowgroup"><fmt:message key="group"
												bundle="${ rb }" /></th>
										<th class="rowgroup"><fmt:message key="time"
												bundle="${ rb }" /></th>
										<th id=group colspan="2" class="rowgroup"><fmt:message
												key="client" bundle="${ rb }" /></th>
										<th></th>
										<th></th>
									</tr>
									<tbody>
										<c:forEach var="visit" items="${plannedVisits}">
											<input type="radio" id="level" name="level" value="${level}"
												required>

											<tr>
												<td class="pt-3"><c:out
														value='${visit.danceClass.date}' /></td>
												<td class="pt-3"><c:out
														value="${visit.danceClass.schedule.group.title}" /></td>
												<td class="pt-3"><c:out
														value="${visit.danceClass.schedule.time}" /></td>
												<c:forEach var="client" items="${visit.danceClass.clients}">
													<td class="pt-3"><c:out value="${client.surname}" /></td>
													<td class="pt-3"><c:out value="${client.name}" /></td>
												</c:forEach>
												<td>
													<button type="button" class="btn colorBtn" name="status"
														value="ATTENDED">
														<fmt:message key="attended" bundle="${ rb }" />
													</button>
												</td>
												<td>
													<button type="button" class="btn colorBtn" name="status"
														value="ABSENT">
														<fmt:message key="absent" bundle="${ rb }" />
													</button>
												</td>

											</tr>
										</c:forEach>
									</tbody>
								</table>

								<button type="submit" class="btn colorBtn" name="command"
									value="MARKPRESENCE">
									<fmt:message key="markPresence" bundle="${ rb }" />
								</button>
							</div>
						</form>
					</c:if>
					<c:if test="${empty plannedvisit}">
						<fmt:message key="noUnmarkedClasses" bundle="${ rb }" />
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