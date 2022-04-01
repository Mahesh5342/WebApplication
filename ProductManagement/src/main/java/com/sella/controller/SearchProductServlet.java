package com.sella.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.sella.bean.Product;

import ProductManagementDao.ProductManagement;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SearchProductServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public SearchProductServlet() 
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  
		try
		{
			int pd=Integer.parseInt(request.getParameter("productId"));  
			Product product = (Product) ProductManagement.getProductById(pd);
			if(product==null) 
			{
				out.println("<div align='center'>");
				out.println("<html><body bgcolor='lightpink'><h3>product id does not exist</h3></body></html>");
				out.println("<h3>please enter existing product id</h3>");
				out.println("<a href=\"SearchProduct.jsp\">OK\r\n");
				out.println("</div>");
			}
			else
			{	  
				out.println("<div align='center'>");
				out.print("<table border='1' width='50%'"); 
				out.println("<body bgcolor='lightpink'><h3>Products List</h3>");
				out.print("<tr><th>productId</th><th>productName</th><th>productPrice</th></tr>");  
				out.print("<tr><td>"+product.getProductId()+"</td><td>"+product.getProductName()+"</td><td>"+product.getProductPrice()+"</td></tr>");  
				out.print("</table>"); 
				out.println("<br/>");
				out.println("<a href='SearchProduct.jsp'><h>OK</h></a>");
				out.println("<br/>");
				out.close();
			}
		}
		catch(NumberFormatException e)
		{
			//response.sendRedirect("SearchProduct.jsp");
			out.println("<div align='center'>");
			out.println("<html><body bgcolor='lightpink'><h3>please enter existing product id</h3></body></html>");
			out.println("<a href=\"SearchProduct.jsp\">OK\r\n");
		}
		catch(SQLException e)
		{
			//response.sendRedirect("SearchProduct.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
