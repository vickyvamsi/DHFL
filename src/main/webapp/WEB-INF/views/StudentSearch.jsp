<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<center>
					<h4 style="color:red;">${msg}</h4>
			<h1>Serach Student Data</h1><hr>
			<table>
				<form:form action="search" method="post">
					<tr>
						<td>Enter Email</td><td>: <input type="text" name="email"/></td> 
					</tr>
					<tr>
						<td>Enter Phone Number</td><td>: <input type="text" name="phNum"/></td>
					</tr>
					<tr>
						<td colspan="2"><center><input type="submit" value="Search"></center></td>
					</tr>
				</form:form>
			</table>
		</center>
</body>
</html>