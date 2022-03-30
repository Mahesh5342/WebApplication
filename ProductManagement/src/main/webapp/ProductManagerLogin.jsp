<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightmeroon">
<form action="LoginServlet">
 <div align="center">
   <table>
     <h3>Product Manager Login</h3>
     <tr>
       <td>Username</td>
       <td><input type="text" name="username" required/></td>
     </tr>
     <tr>
       <td>Password</td>
       <td><input type="password" name="password" required/></td>
     </tr>
   </table>
   <br> <input type="submit" value="Submit">
        <input type="reset" value="Reset">
</div>
</form>
</body>
</html>