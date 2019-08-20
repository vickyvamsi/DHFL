<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student data</title>
<style type="text/css">
th,td{
	text-align: center;
}

table{
	width:20px;
	border: 2px;
}
</style>
</head>
<body>
	<center>
			<a href="exportEXcel">Export all excel</a>
		<h1>
			<u>STUDENT DATA</u>
		</h1>
		<c:choose>
			<c:when test="${empty stds}">
				<h4>NO STUDENT DATA</h4>
			</c:when>
			<c:otherwise>
				<table border="1">
					<tr>
						<th>STUDENT ID</th><th>STUDENT NAME</th><th>STUDENT EMAIL</th>
						<th>PHONE NUM</th><th>GENDER</th><th>BRANCH</th>
						<th>COURCE</th><th>ADDRESS</th><th colspan="3">OPERATIONS</th>
					</tr>
					<c:forEach items="${stds}" var="std">
						<tr>
							<td><c:out value="${std.stdId}"/></td>
							<td><c:out value="${std.stdName}"/></td>
							<td><c:out value="${std.stdEmail}"/></td>
							<td><c:out value="${std.stdPhNum}"/></td>
							<td><c:out value="${std.stdGen}"/></td>
							<td><c:out value="${std.stdBranch}"/></td>
							<td><c:out value="${std.stdCourse}"/></td>
							<td><c:out value="${std.stdAddr}"/></td>
							<td><a href="editStd?stdId=${std.stdId}">EDIT</a></td>
							<td><a href="delete?stdId=${std.stdId}">DELETE</a></td>
							<td><a href="viewStd?stdId=${std.stdId}">SHOW</a></td>
							<td><a href="exportEXcel?stdId=${std.stdId}">Export Excel</a> </td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
	</center>
	
</body>
</html>