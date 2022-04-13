<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Product</title>
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
		<h1>Search Product</h1>
		<form action="SearchProductServlet" method="get">
			<table>
				<tr>
					<td>productId:</td>
					<td><input type="number" name="productId" /></td>
				</tr>
			</table>
			<br> <input type="submit" value="Enter" /> 
			     <input type="Reset" value="Reset" /><br> 
			<br> <a href="Login.html">Back</a>
		</form>
	</div>
</body>
</html>