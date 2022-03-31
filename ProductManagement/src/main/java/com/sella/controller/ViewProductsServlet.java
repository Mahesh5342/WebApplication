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

/**
 * Servlet implementation class ViewProductsServlet
 */
public class ViewProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewProductsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		try 
		{
			List<Product> list;

			list = ProductManagement.getAllProducts();

			out.println("<div align='center'>");
			out.println("<body bgcolor='lightgrey'>");
			out.println("<h1>Products List</h1>");  
			out.print("<table border='1' width='50%' bgcolor='lightgreen'");  
			out.print("<tr><th>productId</th><th>productName</th><th>productPrice</th></tr>");  
			for(Product p:list)
			{  
				out.print("<tr><td>"+p.getProductId()+"</td><td>"+p.getProductName()+"</td><td>"+p.getProductPrice()+"</td></tr>");  
			}  
			out.print("</table>"); 
			out.println("<br/>");
			out.println("<a href='Login.html'><h>Back</h></a>");
			out.println("</div>");

		} 
		catch (NumberFormatException e) 
		{
			//e.printStackTrace();
			response.sendRedirect("ViewProductServlet");
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
