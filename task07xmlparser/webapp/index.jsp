<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Visits</title>
<c:url value="favicon.ico" var="icon" />
<link rel="icon" href="<c:out value="${ icon }"/>">
<c:url value="css/style.css" var="stylesheet" />
<link rel="stylesheet" href="<c:out value="${ stylesheet }"/>">

</head>
<body>
	<c:url value="img/banner.jpg" var="img" />
	<img src="<c:out value="${ img }" />" alt="dance">
	<h1>Data parsing</h1>
	<p>${message}</p>
	<form method="post" action="start" enctype="multipart/form-data">
		<label for="fileName">Choose xml file:</label> <input type="file"
			value="Choose" name="fileName"> <br> <label
			for="xsdFile">Choose xsd schema:</label> <input type="file"
			name="xsdFile" value="Choose"> <br> <label for="parser">
			Choose a parser: </label> <select id="parser" name="parser">
			<option value="dom">DOM</option>
			<option value="sax">SAX</option>
			<option value="stax">STAX</option>
		</select> <br> <input type="submit" value="Submit">
	</form>
</body>
</html>
