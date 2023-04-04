package com.bumblebee.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.bumblebee.model.Product;
import com.mysql.cj.protocol.Resultset;

public class ProductManger {
	
	
	
	public DbConnector getDbConnector() {
		
		DbConnectorFactory factory = new MySqlDbConnectorFactoryImpl();
		return factory.getDbConnector();	
	}
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		
		DbConnector connector = getDbConnector();
		return connector.getDbConnection();
		
	}
	
	public boolean addProduct(Product product) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		String query = "INSERT INTO product (name,catogryId,brandId,qty,price,descrption)VALUES(?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, product.getName());
		ps.setInt(2, product.getCategoryId());
		ps.setInt(3, product.getBrandId());
		ps.setInt(4, product.getQty());
		ps.setDouble(5, product.getPrice());
		ps.setString(6, product.getDescription());
		int result = ps.executeUpdate();
		ps.close();
		connection.close();
		
		return false;
		
	}
	
	public Product  getSpecificProduct (int id) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
	
		return new Product();
		
	}
	
	public List<Product> getAllProducts() throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
	String query = "SELECT * FROM product";
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		List<Product> productlist = new ArrayList<Product>();
		while (rs.next()) {
			Product product = new Product();
			product.setProductId(rs.getInt("productId"));
			product.setName(rs.getString("name"));
			product.setCategoryId(rs.getInt("categoryId"));
			product.setBrandId(rs.getInt("brandId"));
			product.setQty(rs.getInt("qty"));
			product.setPrice(rs.getDouble("price"));
			product.setDescription(rs.getString("descrption"));
			product.setCreate(rs.getString("create"));
			
			productlist.add(product);
		}
			st.close();
			connection.close();
			
		return productlist;
	}
	
	public boolean updateProduct(Product product) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();

		String query = "UPDATE product SET name = ?, categoryId = ?, brandId=?, qty = ? , price = ? , description = ? , create = ? WHERE productId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1,product.getName());
		ps.setInt(2,product.getCategoryId());
		ps.setInt(3,product.getBrandId());
		ps.setInt(4,product.getQty());
		ps.setDouble(5,product.getPrice());
		ps.setString(6,product.getDescription());
		ps.setString(7,product.getCreate());
		
		int result = ps.executeUpdate();
		ps.close();
		connection.close();
		
		return result > 0;
	}
	
	public boolean deleteProduct(int productId) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();

		String query = "DELETE FROM product WHERE productId = ? ";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, productId );
		
		int result = ps.executeUpdate();
		ps.close();
		connection.close();
		
		return result > 0;
	}
}
