<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><spring:message code="lista.tytulstrony" /></title>
	</head>
	<body>
	<a href="/koty-webapp/lista?language=en">Angielski</a>
	<a href="/koty-webapp/lista?language=pl">Polski</a>
		<p><a href="<c:url value="dodaj" />"><spring:message code="lista.dodaj" /></a><br /></p>
		<table border="1">
			<thead>
				<tr>
					<th>#</th>
					<th><spring:message code="lista.tytul" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${koty}" var="kot" varStatus="status">
				<tr>
					<td>${status.index}</td>
					<td><a href="<c:url value="kot-${kot.imie}" />">${kot.imie}</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<br />
		<hr />
	</body>
</html>