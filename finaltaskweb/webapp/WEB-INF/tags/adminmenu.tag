<%@tag language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale.language}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="pagecontent" var="rb" />
<c:url value="enrollment1.jsp" var="enrollment1" />
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>


<form method="post" action="action">
		<ul class="navbar-nav" style = "margin-left:10px">
		
			<li class="nav-item">
				<button type="submit" class="btn clientMenuBtn btn-light"
					name="command" value="READALLCLIENT">
					<fmt:message key="clients" bundle="${ rb }" />
				</button>
			</li>
			<li class="nav-item">
				<button type="submit" class="btn clientMenuBtn btn-light"
					name="command" value="READALLTEACHER">
					<fmt:message key="teachers" bundle="${ rb }" />
				</button>
			</li>
			<li class="nav-item">
				<button type="submit" class="btn clientMenuBtn btn-light"
					name="command" value="READALLGROUP">
					<fmt:message key="groups" bundle="${ rb }" />
				</button>
			</li>
			<li class="nav-item" style="margin-bottom: 30px"><a
				class="btn clientMenuBtn btn-light"
				href='<c:out value="${myMemberships}"/>'><fmt:message
						key="clientMain.mymemberships" bundle="${ rb }" /><br> </a></li>
			<li class="nav-item"><a class="btn clientMenuBtn btn-light"
				href='<c:out value="${updateClient}"/>'><fmt:message
						key="clientMain.updateClient" bundle="${ rb }" /> </a></li>
			<li class="nav-item"><a class="btn clientMenuBtn btn-light"
				href='<c:out value="${changePass}"/>'><fmt:message
						key="clientMain.changePassword" bundle="${ rb }" /> </a></li>
			<li class="nav-item">
				<button type="submit" class="btn clientMenuBtn btn-light"
					name="command" value="LOGOUT">
					<fmt:message key="logout" bundle="${ rb }" />
				</button>
			</li>
		</ul>
	</form>
">
					<fmt:message key="clientMain.buymembership" bundle="${ rb }" />
				</button>
			</li>
			<li class="nav-item">
				<button type="submit" class="btn clientMenuBtn btn-light"
					name="command" value="PLANNEDVISITS">
					<fmt:message key="clientMain.plannedclasses" bundle="${ rb }" />
				</button>
			</li>
			<li class="nav-item"><a class="btn clientMenuBtn btn-light"
				href='<c:out value="${myVisits}"/>'><fmt:message
						key="clientMain.myvisits" bundle="${ rb }" /> </a></li>
			<li class="nav-item" style="margin-bottom: 30px"><a
				class="btn clientMenuBtn btn-light"
				href='<c:out value="${myMemberships}"/>'><fmt:message
						key="clientMain.mymemberships" bundle="${ rb }" /><br> </a></li>
			<li class="nav-item"><a class="btn clientMenuBtn btn-light"
				href='<c:out value="${updateClient}"/>'><fmt:message
						key="clientMain.updateClient" bundle="${ rb }" /> </a></li>
			<li class="nav-item"><a class="btn clientMenuBtn btn-light"
				href='<c:out value="${changePass}"/>'><fmt:message
						key="clientMain.changePassword" bundle="${ rb }" /> </a></li>
			<li class="nav-item">
				<button type="submit" class="btn clientMenuBtn btn-light"
					name="command" value="LOGOUT">
					<fmt:message key="logout" bundle="${ rb }" />
				</button>
			</li>
		</ul>
	</form>
