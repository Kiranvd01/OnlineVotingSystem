<%@page import="com.votingsystem.model.candidate.Candidate"%>
<%@page import="java.util.List"%>
<%@page import="com.votingsystem.dao.candidate.CandidateDaoGetObject"%>
<%@page import="com.votingsystem.dao.candidate.CandidateDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head> 
<title>All Candidate List</title>
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
<body style="background-color: maroon;">
<%!CandidateDao dao; %>
<%dao=CandidateDaoGetObject.getInstance();
List<Candidate> list= dao.getAllCandidate();
application.setAttribute("list", list);
%>
<h1>************* ALL CADIDATE INFO *************</h1>
	<div class="container">
		<table class="table">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>ADRESS</th>
				<th>CONTACT</th>
				<th>AGE</th>
				<th>ADHAR</th>
				<th>DELETE</th>
				<th>UPDATE</th>
			</tr>

			<c:forEach var="stud" items="${applicationScope.list }">
				<tr>
					<td><c:out value="${stud.id}"></c:out></td>
					<td><c:out value="${stud.name}"></c:out></td>
					<td><c:out value="${stud.address}"></c:out></td>
					<td><c:out value="${stud.contact}"></c:out></td>
					<td><c:out value="${stud.age}"></c:out></td>
					<td><c:out value="${stud.adharNo}"></c:out></td> 
					<td><a href="${pageContext.request.contextPath}/DeleteCandidate?id=${stud.id}">DELETE</a></td>
					<td><a href="${pageContext.request.contextPath}/DisplayCandidate?id=${stud.id}">UPDATE</a></td>
				</tr>
			</c:forEach>
			<tr><td><a href="../RegisterCandidate.html">NewUser</a></td><td><a href="../index.html">Back</a></td></tr>
		</table>

	</div>
</body>
</html>