<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

			<form action="/koty-webapp/kot-${kot.imie}/upload" enctype="multipart/form-data" method="post">
    			<input type="file" name="plik" />
    			<input type="text" name="opis" />
    			<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
    			<input type=submit name="wyslij" value="Wyslij"/>
			</form>

</body>
</html>