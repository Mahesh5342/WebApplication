<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>User Login</title>
</head>
	<body bgcolor="lightblue">
	<form action="LoginServlet">
		<div align="center">
			<table>
				<br><h3>Product Store Management</h3>
				<h3>User Login</h3>
				<tr>
					<td>Username</td>
					<td><input type="text" name="username" maxlength="15" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" id="pwd" name="password" maxlength="15" /></td>
				</tr>
			</table>
			<br> <input type="submit" value="Submit"> 
			     <input type="reset" value="Reset"> <br>
			<br> <a href="Signup.jsp">new user click here to register</a>
		</div>
	</form>
</body>
</html>