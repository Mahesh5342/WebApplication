package com.sella.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.sella.bean.LoginBean;

import ProductManagementDao.ProductManagement;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//response.sendRedirect("ProductManagerLogin.jsp");--previous

		response.setContentType("text/html");
		String username=request.getParameter("username");
		String password=request.getParameter("password");

		PrintWriter out = response.getWriter();
		ProductManagement dao = new ProductManagement();
		LoginBean loginBean = new LoginBean();
		loginBean.setUserName(username);
		loginBean.setPassword(password);
		if(dao.validate(loginBean))
		{
			response.sendRedirect("Login.html");
		}
		else
		{
			out.println("<html><body><h3>invalid username or password</h3></body></html>");
			response.sendRedirect("ProductManagerLogin.jsp");
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
