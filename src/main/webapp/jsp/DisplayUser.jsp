<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Voter Information</title>
</head>
<body style="text-align: center; background-color: teal;">
<form action="UpdateUser" method="get">
<br><br><br>
<input type="text" name="id" value="${requestScope.user.id }" readonly="readonly"><br>
<input type="text" name="name" value="${requestScope.user.name }"><br>
<input type="text" name="address" value="${requestScope.user.address }"><br>
<input type="text" name="contact" value="${requestScope.user.contact }"><br>
<input type="text" name="age" value="${requestScope.user.age }"><br>
<input type="text" name="adhar" value="${requestScope.user.adharNo }"><br>
<input type="submit" value="Update"><br>
</form>
</body>
</html>