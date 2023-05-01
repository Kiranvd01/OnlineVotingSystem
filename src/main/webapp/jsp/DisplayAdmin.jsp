<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Admin Data</title>
</head>
<body style="background-color: gray; text-align: center;">
<form action="UpdateAdmin" method="get">
<input type="text" name="id" value="${requestScope.admin.id }" readonly="readonly"><br>
<input type="text" name="name" value="${requestScope.admin.name }"><br>
<input type="text" name="address" value="${requestScope.admin.address }"><br>
<input type="text" name="contact" value="${requestScope.admin.contact }"><br>
<input type="text" name="age" value="${requestScope.admin.age }"><br>
<input type="text" name="adhar" value="${requestScope.admin.adhar }"><br>
<input type="submit" value="Update">
</form>
</body>
</html>