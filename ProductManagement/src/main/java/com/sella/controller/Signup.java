package com.sella.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.regex.Pattern;

import com.sella.bean.LoginBean;

import ProductManagementDao.ProductManagement;

public class Signup extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public Signup() 
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter out = response.getWriter();

		ProductManagement d = new ProductManagement();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		boolean b1 = Pattern.matches("[a-zA-Z]{3,10}", userName );
		boolean b2 = Pattern.matches("[a-zA-Z0-9@]{3,10}", password );
		try
		{ 
			if(b1==true&&b2==true)
			{
				if(password.equals(confirmPassword)) 
				{
					LoginBean login = new LoginBean();
					login.setUserName(userName);
					login.setPassword(password);

					int status;
					status = ProductManagement.registerUser(login);

					if(status>0)
					{
						//response.sendRedirect("RegisterSuccess.jsp");
						out.println("<div align='center'>");
						out.println("<html><body bgcolor='lightpink'><h3>user registered successfully</h3></body></html>");
						out.println("<a href=\"ProductManagerLogin.jsp\">OK\r\n"); 
					}
					else
					{
						//out.println("Invalid username");
						out.println("<div align='center'>");
						out.println("<html><body bgcolor='lightpink'><h3>user name already exist</h3></body></html>");
						out.println("<h1>please enter valid user name</h1>");
						out.println("<a href=\"Signup.jsp\">OK\r\n"); 
					}
				}
				else
				{
					out.println("<div align='center'>");
					out.println("<html><body bgcolor='lightpink'><h3>please enter valid confirm password</h3></body></html>");
					out.println("<a href=\"Signup.jsp\">OK\r\n");
				}
			}
			else
			{
				out.println("<div align='center'>");
				out.println("<html><body bgcolor='lightpink'><h3>please enter valid username or password</h3></body></html>");
				out.println("<a href=\"Signup.jsp\">OK\r\n"); 
			}
		}
		catch (SQLException e) 
		{
			response.sendRedirect("Signup.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
