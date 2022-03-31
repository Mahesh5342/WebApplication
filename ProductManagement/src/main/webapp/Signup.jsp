<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightblue">
	<form action="Signup">
		<div align="center">
			<table>
				<h3>New User</h3>
				<h2>please enter your credentials to register</h2>
				<tr>
					<td>Username</td>
					<td><input type="text" name="username" minlength="4"
						maxlength="15" required /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" minlength="4"
						maxlength="15" required /></td>
				</tr>
				<tr>
					<td>confirmPassword</td>
					<td><input type="password" name="confirmPassword"
						maxlength="15" required /></td>
				</tr>
			</table>
			<br> <input type="submit" value="Submit"> <input
				type="reset" value="Reset"> <br> <br> <a
				href="ProductManagerLogin.jsp">already registered click here to
				login</a>
		</div>
	</form>
</body>
</html>