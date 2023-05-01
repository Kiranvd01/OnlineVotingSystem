<%@page import="com.votingsystem.model.result.Result"%>
<%@page import="java.util.List"%>
<%@page import="com.votingsystem.dao.result.ResultDaoGetObject"%>
<%@page import="com.votingsystem.dao.result.ResultDao"%>
<%@page import="com.votingsystem.dao.candidate.CandidateDaoGetObject"%>
<%@page import="com.votingsystem.dao.candidate.CandidateDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Result</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="../css/table.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body style="background-color:activecaption;">
<%!ResultDao dao; %>
<%dao=ResultDaoGetObject.getInstance();
List<Result> list= dao.getAllResult();
application.setAttribute("list", list);
%>
<h1>@@@@@@@@@@ RESULT @@@@@@@@@@</h1>
	<div class="container">
		<table class="table">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>VOTE</th>
			</tr>
			<c:forEach var="stud" items="${applicationScope.list }">
				<tr>
					<td><c:out value="${stud.id}"></c:out></td>
					<td><c:out value="${stud.name}"></c:out></td> 
					<td><c:out value="${stud.vote }"></c:out></td>
				</tr>
			</c:forEach>
			<tr><td><a href="../index.html">Back</a></td></tr>
		</table>
	</div>
</body>
</html>