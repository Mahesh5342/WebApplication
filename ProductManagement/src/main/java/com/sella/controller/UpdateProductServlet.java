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
        	int productId=Integer.parseInt(request.getParameter("productId"));
   	 		
        	String productName=request.getParameter("productName");  
	    	
        	boolean b1 = Pattern.matches("[a-zA-Z]{3,10}", productName );
        	
        	float productPrice=Float.parseFloat(request.getParameter("productPrice")); 
        	if(b1==true) {	
   	 			Product product=new Product(productId, productName, productPrice);  
   	 			product.setProductId(productId);  
   	 			product.setProductName(productName);  
   	 			product.setProductPrice(productPrice); 
   	 			status=ProductManagement.updateProduct(product);  
        	}
   	 		if(status>0)
   	 		{  
   	 			request.getRequestDispatcher("ViewProductsServlet").forward(request, response);  
   	 		}
   	 		else
   	 		{  
   	 			//out.println("Sorry! unable to update record");
   	 			response.sendRedirect("UpdateProduct.jsp");
   	 		}  
        }
        catch(NumberFormatException e)
        {
        	response.sendRedirect("UpdateProduct.jsp");
        }
       
        out.close();   
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
