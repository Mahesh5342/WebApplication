<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.product{
	position:absolute;
	align-items: center;
	padding-left:300px;
}
</style>
</head>
<body>
<div class="product">
 <h1>Update Product</h1>  
  <form action="UpdateProductServlet" method="get">  
   <table>  
    <tr><td>productId:</td><td><input type="number" min =1  max=9999 name="productId" required/></td></tr>  
    <tr><td>productName:</td><td><input type="text" name="productName" required/></td></tr>  
    <tr><td>productPrice:</td><td><input type="number" max=999999 name="productPrice" required/></td></tr>  
    <tr><td colspan="2"><input type="submit" value="Enter"/></td></tr>
    <tr><td colspan="2"><input type="Reset" value="Reset"/></td></tr> 
   </table>  
  </form>  
<br/>  
<a href="Login.html">Back</a>
</div>  
</body>
</html>