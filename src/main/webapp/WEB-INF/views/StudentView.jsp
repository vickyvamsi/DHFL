<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>

	<h1>Welcome :<c:out value="${std.stdName}"/> </h1><br>
	<table>
		<tr>
			<th colspan="2">Student Details</th>
		</tr>
		<tr>
			<td>STUDENT ID </td><td>: <c:out value="${std.stdId}"/></td>
		</tr>
		<tr>
			<td>STUDENT NAME </td><td>: <c:out value="${std.stdName}"/></td>
		</tr>
		<tr>
			<td>EMAIL </td><td>: <c:out value="${std.stdEmail}"/></td>
		</tr>
		<tr>
			<td>PHONE NUMBER </td><td>: <c:out value="${std.stdPhNum}"/></td>
		</tr>
		<tr>
			<td>GENDER </td><td>: <c:out value="${std.stdGen}"/></td>
		</tr>
		<tr>
			<td>BRANCH </td><td>: <c:out value="${std.stdBranch}"/></td>
		</tr>
		<tr>
			<td>COURSE </td><td>: <c:out value="${std.stdCourse}"/></td>
		</tr>
		<tr>
			<td>ADDRESS </td><td>: <c:out value="${std.stdAddr}"/></td>
		</tr>
	</table>
	
</center>
</body>
</html>