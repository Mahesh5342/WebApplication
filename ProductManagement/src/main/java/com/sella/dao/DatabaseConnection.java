package com.sella.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection 
{
	public static Connection getConnection() throws SQLException 
	{
		Connection connection = null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/selladb";
			String userName="root";
			String password="1234";
			connection=DriverManager.getConnection(dburl,userName,password);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
