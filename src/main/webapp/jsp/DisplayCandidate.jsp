<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Candidate Information</title>
</head>
<body style="background-color:buttonshadow; ;text-align: center;">
<form action="UpdateCandidate" method="get">
<input type="text" name="id" value="${requestScope.candidate.id }" readonly="readonly"><br>
<input type="text" name="name" value="${requestScope.candidate.name }"><br>
<input type="text" name="address" value="${requestScope.candidate.address }"><br>
<input type="text" name="contact" value="${requestScope.candidate.contact }"><br>
<input type="text" name="age" value="${requestScope.candidate.age }"><br>
<input type="text" name="adhar" value="${requestScope.candidate.adharNo }"><br>
<input type="submit" value="Update">
</form>
<a href="DisplayAllCandidate.jsp"><button>Back</button></a>
</body>
</html>