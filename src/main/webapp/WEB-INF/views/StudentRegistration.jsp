<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration</title>
<style type="text/css">
.error{
		color:red;
	}
</style>
</head>
<body>
	<center>
		<h1>Welcome To Student Registration Page</h1>
		${msg}
		<table>
			<form:form action="saveStd" method="post" modelAttribute="student">
				<tr>
					<td>STUDENT NAME :</td>
					<td><form:input path="stdName" /></td>
					<td><form:errors path="stdName" cssClass="error"/></td>
				</tr>
				<tr>
					<td>STUDENT EMAIL :</td>
					<td><form:input path="stdEmail" /></td>
					<td><form:errors path="stdEmail" cssClass="error"/></td>
				</tr>
				<tr>
					<td>PHONE NUMBER :</td>
					<td><form:input path="stdPhNum" /></td>
					<td><form:errors path="stdPhNum" cssClass="error"/></td>
				</tr>
				<tr>
					<td>GENDER :</td>
					<td><form:radiobutton path="stdGen" value="Male" />Male <form:radiobutton
							path="stdGen" value="Female" />Female <form:radiobutton
							path="stdGen" value="Other" /> Other</td>
					<td><form:errors path="stdGen" cssClass="error"/></td>
				</tr>
				<tr>
					<td>BRANCH :</td>
					<td><form:select path="stdBranch">
							<form:option value="">-SELECT-</form:option>
							<form:option value="MCA">MCA</form:option>
							<form:option value="MBA">MBA</form:option>
							<form:option value="MSc">MSc</form:option>
							<form:option value="MCom">MCom</form:option>
						</form:select>
						</td>
						<td><form:errors path="stdBranch" cssClass="error"/></td>
				</tr>
				<tr>
					<td>COURSE :</td>
					<td><form:checkbox value="JAVA" path="stdCourse" /> JAVA <form:checkbox
							value=".NET" path="stdCourse" /> .NET <form:checkbox value="PHP"
							path="stdCourse" /> PHP</td>
							<td><form:errors path="stdCourse" cssClass="error"/></td>
				</tr>
				<tr>
					<td>ADDRESS :</td>
					<td><form:textarea path="stdAddr" /></td>
					<td><form:errors path=""/></td>
				</tr>
				<tr>
					<td><center>
							<input type="submit" value="Register" />
						</center></td>
				</tr>
			</form:form>
		</table>
	</center>
</body>
</html>