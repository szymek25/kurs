<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Szczegoly kota</title>
</head>
<body>

<a href="lista">Powrot do listy kotow</a>
<table border="1">
			<tbody>
				<tr>
					<th>Imię</th>
					<td>${kot.imie}</td>
				</tr>
				<tr>
					<th>Data urodzenia</th>
					<td>${kot.dataUrodzenia}</td>
				</tr>
				<tr>
					<th>Waga</th>
					<td>${kot.waga}</td>
				</tr>
				<tr>
					<th>Imię opiekuna</th>
					<td>${kot.imieOpiekuna}</td>
				</tr>
			</tbody>
		</table>
		<table>
		<h2>Zabawki</h2>
			<c:forEach items="${kot.zabawki}" var="zabawka" varStatus="status">					
				<tr>
					<td>${zabawka.nazwa}</td> <td><a href="kot-${kot.imie}/usun/${zabawka.nazwa}">Usun</a></td>
				</tr>
			</c:forEach>
		</table>
		
			<form action="/koty-webapp/upload" enctype="multipart/form-data" method="post">
    			<input type="file" name="plik" />
    			<input type="text" name="opis" />
    			<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
    			<input type=submit name="wyslij" value="Wyslij"/>
			</form>
<a href="kot-${kot.imie}/dodajZabawke">Dodaj zabawke</a>
</body>
</html>