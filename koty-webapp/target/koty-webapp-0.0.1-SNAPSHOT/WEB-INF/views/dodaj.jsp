<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dodawanie kota</title>
</head>
<body>
	<form:form modelAttribute="kotDto" method="POST">
		<table border="1">
			<tbody>
				<tr>
					<th>Imie kota</th>
					<td><form:input type="text" path="imie" /><c:if test="${pageContext.request.method=='POST'}"><form:errors path="imie" /></c:if></td>
				</tr>
				<tr>
					<th>Data urodzenia</th>
					<td><form:input type="text" path="dataUrodzenia" /><c:if test="${pageContext.request.method=='POST'}"><form:errors path="dataUrodzenia" /></c:if></td>
				</tr>
				<tr>
					<th>Waga</th>
					<td><form:input type="text" path="waga" /><c:if test="${pageContext.request.method=='POST'}"><form:errors path="waga" /></c:if></td>
				</tr>
				<tr>
					<th>Imie Opiekuna</th>
					<td><form:input type="text" path="imieOpiekuna" /><c:if test="${pageContext.request.method=='POST'}"><form:errors path="imieOpiekuna" /></c:if></td>
				</tr>
				<tr>
					<td><input type="submit" value="Dodaj" /></td>
				</tr>
			</tbody>
			</table>
	</form:form>
<a href="lista">Powrot do listy kotow</a>
</body>
</html>