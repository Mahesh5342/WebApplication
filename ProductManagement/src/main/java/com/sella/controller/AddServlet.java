package com.sella.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;

import java.util.regex.Pattern;

import com.sella.bean.Product;

import ProductManagementDao.ProductManagement;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	static int status;

	public AddServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 response.setContentType("text/html");  
	     PrintWriter out=response.getWriter();  
	     try 
	     {  
	    	 int productId=Integer.parseInt(request.getParameter("productId"));
	    	 
	    	 String productName = request.getParameter("productName"); 
	 
	    	 boolean b1 = Pattern.matches("[a-zA-Z]{2,10}", productName );
	    	 
	    	 float productPrice=Float.parseFloat(request.getParameter("productPrice")); 
	    	 
	    	 if(b1==true) {
		    	 Product product=new Product(productId, productName, productPrice);  
		    	 product.setProductId(productId);  
		    	 product.setProductName(productName);  
		    	 product.setProductPrice(productPrice); 
				 status = ProductManagement.addProduct(product);
	    	 }
	    	 else
	    	 {
	    		 //response.sendRedirect("AddProduct.jsp");
	    		 out.println("<div align='center'>");
	 			 out.println("<html><body><h3>enter valid product name</h3></body></html>");
	 			 //out.println("<a href=\"AddProduct.jsp\">Add Product\r\n");
	    	 }
	    	 
	    	 if(status>0)
	    	 {  
	    		 //out.print("<p>Record saved successfully!</p>");  
	    		 //request.getRequestDispatcher("ViewProductsServlet").forward(request, response);
	    		 out.println("<div align='center'>");
	 			 out.println("<html><body><h3>product added successfully</h3></body></html>");
	 			 out.println("<a href=\"AddProduct.jsp\">OK\r\n"); 
	    	 }
	    	 else
	    	 {  
	    		 //out.println("Sorry! unable to save record");
	 			 out.println("<div align='center'>");
	 			 out.println("<h1>invalid id! already exist</h1>");  
	 			 out.println("<a href='AddProduct.jsp'><h>Add Product</h></a>"); 
	    		 //response.sendRedirect("AddProduct.html");
	    	 }  
	    	 out.close();  
	     	}
	     	catch(NumberFormatException e) 
	     	{
	     		response.sendRedirect("AddProduct.jsp");
	     	}
	        
	}

}
