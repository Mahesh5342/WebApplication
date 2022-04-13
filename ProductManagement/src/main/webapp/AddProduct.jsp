<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Product</title>
<style>
.product {
	position: absolute;
	align-items: center;
	padding-left: 300px;
}
</style>
</head>
<body bgcolor="lightblue">
	<div class="product" align="center">
		<h1>Add New Product</h1>
		<form action="AddServlet" method="post">
			<table>
				<tr>
					<td>productId:</td>
					<td><input type="number" min=1 max=9999 name="productId"/></td>
				</tr>
				<tr>
					<td>productName:</td>
					<td><input type="text" name="productName" maxlength="20"/></td>
				</tr>
				<tr>
					<td>productPrice:</td>
					<td><input type="number" min=20000 max=200000 name="productPrice" step="0.01" /></td>
				</tr>
				</table>
				<br> <input type="submit" value="Enter" />
					<input type="Reset" value="Reset" /> <br>
				<br> <a href="Login.html">Back</a>
		</form>
	</div>
</body>
</html>