package ProductManagementDao;

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

	public boolean validate(LoginBean loginBean) 
	{
		boolean result = false;
		try 
		{
			connection = DatabaseConnection.getConnection();
			String sql="select username,password from login where username=? and password=?";
			ps=connection.prepareStatement(sql);
			ps.setString(1, loginBean.getUserName());
			ps.setString(2, loginBean.getPassword());
			resultSet=ps.executeQuery();
			result=resultSet.next();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public static List<Product> getAllProducts() 
	{
		List<Product> productList=new ArrayList<Product>();
		try
		{
			connection=DatabaseConnection.getConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery("Select PRODID,PRODNAME,PRODPRICE from product");
			while(resultSet.next()) {
				Product product=new Product(resultSet.getInt("PRODID"), resultSet.getString("PRODNAME"), resultSet.getInt("PRODPRICE"));
				productList.add(product);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return productList;
	}

	//add product method
	public static int addProduct(Product product) 
	{
		int status=0;
		try
		{
			connection=DatabaseConnection.getConnection();
			ps=connection.prepareStatement("insert into Product values(?,?,?)");
			ps.setInt(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setFloat(3, product.getProductPrice());
			status=ps.executeUpdate();
		}
		catch(SQLIntegrityConstraintViolationException e) 
		{
			e.printStackTrace();
		}
		catch(Exception e)  //unhandled exception type exception
		{
			e.printStackTrace();
		}
		finally 
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return status;

	}
	//update product details method
	public static int updateProduct(Product p)  
	{
		int status=0;
		try
		{
			connection=DatabaseConnection.getConnection();
			ps=connection.prepareStatement("update product set prodName=?,prodPrice=? where prodId=?");
			ps.setInt(3, p.getProductId());
			ps.setString(1, p.getProductName());
			ps.setFloat(2, p.getProductPrice());
			status =ps.executeUpdate();
		}
		catch(SQLSyntaxErrorException e) 
		{
			System.out.println("enter valid product id");
		}
		catch(Exception e)     //unhandled exception type exception
		{
			e.printStackTrace();
		}
		finally 
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return status;
	}
	//delete product method
	public static int deleteProduct(Integer productId)
	{
		int status=0;
		try
		{
			connection=DatabaseConnection.getConnection();
			ps=connection.prepareStatement("delete from product where PRODID=?");
			ps.setInt(1, productId);
			status=ps.executeUpdate();
		}
		catch(Exception e)     //unhandled exception type exception
		{
			e.printStackTrace();
		}
		finally 
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return status;
	}
	//get product by productId method
	public static Product getProductById(int productId) 
	{
		Product product=null;
		try {
			connection=DatabaseConnection.getConnection();
			ps= connection.prepareStatement("select prodId,prodName,prodPrice from product where prodId=?");
			ps.setInt(1, productId);
			ResultSet resultSet=ps.executeQuery();
			if(resultSet.next())
			{
				product=new Product(resultSet.getInt("prodId"), resultSet.getString("prodName"), resultSet.getFloat("prodPrice"));
			}
		}
		catch(Exception e)   //unhandled exception type exception
		{
			e.printStackTrace();
		}
		finally 
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return product;
	}


}
