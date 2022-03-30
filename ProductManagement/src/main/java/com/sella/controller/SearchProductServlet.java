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
 * Servlet implementation class SearchProductServlet
 */
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");  
	    PrintWriter out=response.getWriter();  
	    out.println("<h1>Products List</h1>");
	    try
	    {
	      int pd=Integer.parseInt(request.getParameter("productId"));  
		  Product product = (Product) ProductManagement.getProductById(pd); 
	      out.print("<table border='1' width='50%'");  
	      out.print("<tr><th>productId</th><th>productName</th><th>productPrice</th></tr>");  
	      out.print("<tr><td>"+product.getProductId()+"</td><td>"+product.getProductName()+"</td><td>"+product.getProductPrice()+"</td></tr>");  
	      out.print("</table>"); 
	      out.println("<br/>");
	      out.println("<a href='AddProduct.jsp'><h>Add New Product</h></a>");
	      out.println("<br/>");
	      out.println("<a href='Login.html'><h>Home</h></a>");      
	      out.close();
	    }
	    catch(NullPointerException e)
	    {
	    	response.sendRedirect("SearchProduct.jsp");
	    }
	    catch(NumberFormatException e)
	    {
	    	response.sendRedirect("SearchProduct.jsp");
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
