package com.sella.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import ProductManagementDao.ProductManagement;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteProductServlet
 */
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			int pd=Integer.parseInt(request.getParameter("productId"));  
			//int id=Integer.parseInt(sid); 
			int status;
			status=ProductManagement.deleteProduct(pd);
			if(status>0) 
			{
				//request.getRequestDispatcher("ViewProductsServlet").forward(request, response);
				out.println("<div align='center'>");
				out.println("<html><body><h3>product deleted successfully</h3></body></html>");
				out.println("<a href=\"DeleteProduct.jsp\">OK\r\n");
			}
			else
			{
				//response.sendRedirect("DeleteProduct.jsp");
				out.println("<div align='center'>");
				out.println("<html><body><h3>product id does not exist</h3></body></html>");
				out.println("<h3>enter valid product id</h3>");
				out.println("<a href=\"DeleteProduct.jsp\">OK\r\n");
			}
		}
		catch(NumberFormatException e) 
		{
			response.sendRedirect("DeleteProduct.jsp");
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
