package com.sella.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.sella.bean.LoginBean;

import ProductManagementDao.ProductManagement;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public LoginServlet() 
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//response.sendRedirect("ProductManagerLogin.jsp");--previous
		try
		{
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
				//response.sendRedirect("Login.html");
				out.println("<div align='center'>");
				out.println("<html><body bgcolor='lightpink'><h3>user logined successfully</h3></body></html>");
				out.println("<a href=\"Login.html\">OK\r\n");
			}
			else
			{
				out.println("<div align='center'>");
				out.println("<html><body bgcolor='lightpink'><h3>invalid username or password</h3></body></html>");
				out.println("<a href=\"ProductManagerLogin.jsp\">Login Again\r\n");
				//response.sendRedirect("ProductManagerLogin.jsp");
			}
		}
		catch(SQLException e)
		{
			response.sendRedirect("Login.html");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
