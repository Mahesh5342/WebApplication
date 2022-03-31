<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightpaleblue">
	<div align="center">
		<h1>Delete Product</h1>
		<form action="DeleteProductServlet" method="get">
			<table>
				<tr>
					<td>productId:</td>
					<td><input type="number" name="productId" required /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Enter" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="Reset" value="Reset" /></td>
				</tr>
			</table>
		</form>
		<br /> <a href="Login.html">Back</a>
	</div>
</body>
</html>