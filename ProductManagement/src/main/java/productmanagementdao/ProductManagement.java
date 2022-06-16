package productmanagementdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sella.bean.LoginBean;
import com.sella.bean.Product;
import com.sella.dao.DatabaseConnection;

public class ProductManagement 
{
	static Connection connection;
	static Statement statement;
	static ResultSet resultSet;
	static PreparedStatement ps;

	public static int registerUser(LoginBean register) throws SQLException  
	{
		int result = 0;
		try 
		{
			connection = DatabaseConnection.getConnection();
			String sql = "insert into login values(?,?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, register.getUserName());
			ps.setString(2, register.getPassword());
			result = ps.executeUpdate();
		}
		catch(SQLIntegrityConstraintViolationException e)
		{
			result = 0;
		}
		catch (SQLException e) 
		{
			result = 0;
		}
		finally
		{
			connection.close();
		}
		return result;
	}
	public boolean validate(LoginBean login) throws SQLException 
	{
		boolean result = false;
		try 
		{
			connection = DatabaseConnection.getConnection();
			String sql = "select username,password from login where username=? and password=?";
			ps=connection.prepareStatement(sql);
			ps.setString(1, login.getUserName());
			ps.setString(2, login.getPassword());
			resultSet = ps.executeQuery();
			result = resultSet.next();
		} 
		catch (SQLException e) 
		{
			result = false;
		}
		finally 
		{
			connection.close();
		}
		return result;
	}
	public static List<Product> getAllProducts() throws SQLException 
	{
		List<Product> productList=new ArrayList<Product>();
		try
		{
			connection = DatabaseConnection.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("Select PRODID,PRODNAME,PRODPRICE from product");
			while(resultSet.next()) 
			{
				Product product = new Product(resultSet.getInt("PRODID"), resultSet.getString("PRODNAME"), resultSet.getFloat("PRODPRICE"));
				productList.add(product);
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			connection.close();
		}
		return productList;
	}
	//add product method
	public static int addProduct(Product product) throws SQLException 
	{
		int status = 0;
		try
		{
			connection = DatabaseConnection.getConnection();
			ps = connection.prepareStatement("insert into Product values(?,?,?)");
			ps.setInt(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setFloat(3, product.getProductPrice());
			status = ps.executeUpdate();
		}
		catch(SQLIntegrityConstraintViolationException e) 
		{
			status = 0;
		}
		catch(SQLException e)  //unhandled exception type exception
		{
			status = 0;
		}
		finally 
		{
			connection.close();
		}
		return status;
	}
	//update product details method
	public static int updateProduct(Product p) throws SQLException  
	{
		int status = 0;
		try
		{
			connection = DatabaseConnection.getConnection();
			ps = connection.prepareStatement("update product set prodName=?,prodPrice=? where prodId=?");
			ps.setInt(3, p.getProductId());
			ps.setString(1, p.getProductName());
			ps.setFloat(2, p.getProductPrice());
			status = ps.executeUpdate();
		}
		catch(SQLSyntaxErrorException e) 
		{
			status = 0;
		}
		catch(SQLException e)     //unhandled exception type exception
		{
			status = 0;
		}
		finally 
		{
			connection.close();
		}
		return status;
	}
	//delete product method
	public static int deleteProduct(Integer productId) throws SQLException
	{
		int status=0;
		try
		{
			connection = DatabaseConnection.getConnection();
			ps = connection.prepareStatement("delete from product where PRODID=?");
			ps.setInt(1, productId);
			status = ps.executeUpdate();
		}
		catch(SQLException e)     //unhandled exception type exception
		{
			status = 0;
		}
		finally 
		{
			connection.close();
		}
		return status;
	}
	//get product by productId method
	public static Product getProductById(int productId) throws SQLException 
	{
		Product product=null;
		try 
		{
			connection = DatabaseConnection.getConnection();
			ps = connection.prepareStatement("select prodId,prodName,prodPrice from product where prodId=?");
			ps.setInt(1, productId);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next())
			{
				product = new Product(resultSet.getInt("prodId"), resultSet.getString("prodName"), resultSet.getFloat("prodPrice"));
			}
		}
		catch(SQLException e)   //unhandled exception type exception
		{
			product = null;
		}
		finally 
		{
			connection.close();
		}
		return product;
	}
}
