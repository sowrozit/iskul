<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="Post" action="registration" commandName="registrationForm">
	<table>
		<%--<form:hidden path="id"/>--%>
		<tr>
			<td>Name:</td>
			<td><form:input path="userName" /></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td>Phone Number:</td>
			<td><form:input path="phoneNumber" /></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><form:input path="password" /></td>
		</tr>
		<tr>
			<td>User Type</td>
			<td>
				<form:select path="userType">
					<option value="student">Student</option>
				</form:select>
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit" /></td>
		</tr>
	</table>
</form:form>
</body>
</html>