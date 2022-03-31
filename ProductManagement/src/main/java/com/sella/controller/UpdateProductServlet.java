package com.sella.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.regex.Pattern;

import com.sella.bean.Product;

import ProductManagementDao.ProductManagement;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateProductServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	static int status;

	public UpdateProductServlet() 
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  
		try 
		{
			int productId = Integer.parseInt(request.getParameter("productId"));
			String productName = request.getParameter("productName");  
			float productPrice = Float.parseFloat(request.getParameter("productPrice")); 

			boolean b1 = Pattern.matches("[a-z\sA-Z]{3,20}", productName );

			if(b1==true) 
			{	
				Product product = new Product(productId, productName, productPrice);  
				product.setProductId(productId);  
				product.setProductName(productName);  
				product.setProductPrice(productPrice); 
				status=ProductManagement.updateProduct(product);  

				if(status>0)
				{  
					//request.getRequestDispatcher("ViewProductsServlet").forward(request, response);
					out.println("<div align='center'>");
					out.println("<html><body><h3>product updated successfully</h3></body></html>");
					out.println("<a href=\"UpdateProduct.jsp\">OK\r\n");
				}
				else
				{  
					//out.println("Sorry! unable to update record");
					//response.sendRedirect("UpdateProduct.jsp");
					out.println("<div align='center'>");
					out.println("<html><body><h3>please enter existing product id</h3></body></html>");
					out.println("<a href=\"UpdateProduct.jsp\">OK\r\n");
				}
			}
			else
			{
				//response.sendRedirect("AddProduct.jsp");
				out.println("<div align='center'>");
				out.println("<html><body><h3>enter valid product name</h3></body></html>");
				out.println("<h3>product name should be minimum of 3 characters and maximum of 20 characters</h3>");
				out.println("<a href='UpdateProduct.jsp'><h>OK</h></a>"); 
				//out.println("<a href=\"AddProduct.jsp\">Add Product\r\n");
			}
		}
		catch(NumberFormatException e)
		{
			response.sendRedirect("UpdateProduct.jsp");
		}
		catch(SQLException e)
		{
			response.sendRedirect("UpdateProduct.jsp");
		}

		out.close();   
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
