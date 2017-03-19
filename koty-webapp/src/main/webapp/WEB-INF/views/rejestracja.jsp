<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rejestracja</title>
</head>
<body>

	<form:form modelAttribute="userDto" method="POST">
	<table>
	<tbody>
				<tr>
					<th>Login</th>
					<td><form:input type="text" path="username" /><c:if test="${pageContext.request.method=='POST'}"><form:errors path="username" /></c:if></td>
				</tr>
				<tr>
					<th>Haslo</th>
					<td><form:input type="text" path="password" /><c:if test="${pageContext.request.method=='POST'}"><form:errors path="password" /></c:if></td>
				</tr>
				<tr>
					<td><input type="submit" value="Rejestruj" /></td>
				</tr>
	</tbody>
	</table>

	</form:form>

</body>
</html>