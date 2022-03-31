<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body bgcolor="orange">
	<form action="LoginServlet">
		<div align="center">
			<table>
				<h3>User Login</h3>
				<tr>
					<td>Username</td>
					<td><input type="text" name="username" maxlength="15" required /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" maxlength="15" required /></td>
				</tr>
			</table>
			<br> <input type="submit" value="Submit"> <input
				type="reset" value="Reset"> <br>
			<br> <a href="Signup.jsp">new user click here to register</a>
		</div>
	</form>
</body>
</html>