<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lime">
	<div align="center">
		<h1>Delete Product</h1>
		<form action="DeleteProductServlet" method="get">
			<table>
				<tr>
					<td>productId:</td>
					<td><input type="number" name="productId" /></td>
				</tr>
			</table>	
			<br> <input type="submit" value="Enter" />
				 <input type="Reset" value="Reset" /><br>
			<br><a href="ViewProductsServlet">View Products</a><br> 
			<br /> <a href="Login.html">Back</a>
		</form>
	</div>
</body>
</html>