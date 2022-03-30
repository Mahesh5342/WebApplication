package com.sella.controller;

import java.io.IOException;
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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try { 
		int pd=Integer.parseInt(request.getParameter("productId"));  
	    //int id=Integer.parseInt(sid); 
		int status;
	    status=ProductManagement.deleteProduct(pd);
	    if(status>0) 
	    {
	    	request.getRequestDispatcher("ViewProductsServlet").forward(request, response);
	    }
	    else
	    {
	    	response.sendRedirect("DeleteProduct.jsp");
	    }
		}
		catch(NumberFormatException e) 
		{
			response.sendRedirect("DeleteProduct.jsp");
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
