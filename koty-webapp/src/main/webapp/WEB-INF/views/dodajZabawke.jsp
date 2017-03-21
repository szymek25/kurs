    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="dodajZabawke.tytul" /></title>
</head>
<body>
	<form:form modelAttribute="zabawkaDto" method="POST">
	<table>
	<tbody>
				<tr>
					<th><spring:message code="dodajZabawke.zabawka" /></th>
					<td><form:input type="text" path="nazwa" /><c:if test="${pageContext.request.method=='POST'}"><form:errors path="nazwa" /></c:if></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="Dodaj"></td>
				</tr>
	</tbody>
	</table>

	</form:form>
</body>
</html>