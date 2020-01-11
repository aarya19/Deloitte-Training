<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>

</head>

<body style="background-color: gray;">
	<h1>User Login</h1>
	<form:form action="submitUser.obj" method="post" modelAttribute="user">
		<table border="1">
			<tr>
				<td>User Name</td>
				<td><form:input path="name" /> <form:errors path="name" /></td>
			</tr>
 <tr>
            <td>Email</td>
            <td><form:input path="email" /> 
            <form:errors path="email" /></td>
         </tr>
         
		<tr>
         <td>Mobile</td>
         <td><form:input path="mobile" /> 
         <form:errors path="mobile" /></td>
         </tr>
			<tr>
				<td>Password</td>
				<td>
				<input type="password" path="pwd" /> <form:errors
						path="pwd" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login" /> <input type="reset"
					value="Cancel"></td>
				<td><a href="display.obj">Go Home</a><br>
				<br></td>
			</tr>
		</table>
	</form:form>
</body>
</html>