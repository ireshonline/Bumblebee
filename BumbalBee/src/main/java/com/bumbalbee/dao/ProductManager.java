package com.bumbalbee.dao;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bumbalbee.model.Product;

public class ProductManager {

	public DbConnector getDbConnector() {
		DbConnectorFactory factory = new MySqlDbConnectorFactorImpl();
		return factory.getDbConnector();
	}
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbConnector connector = getDbConnector();
		return connector.getDBConnection();
	}
	public boolean addProduct(Product product) throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();
		
		String query = "INSERT INTO product(name, categoryId, brandId, qty, "
				+ "price, productInfo)VALUES( ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, product.getName());
		ps.setInt(2, product.getCategoryId());
		ps.setInt(3, product.getBrandId());
		ps.setInt(4, product.getQty());
		ps.setDouble(5, product.getPrice());
		ps.setString(6, product.getProductInfo());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}
	
	public Product getSpeclifcProduct(int productId) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
String query = "SELECT * FROM product WHERE productId = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, productId);
		
		ResultSet rs = ps.executeQuery();
		Product product = new Product();
		
		while(rs.next()) {
			product.setProductId(rs.getInt("productId"));
			product.setName("name");
			product.setCategoryId(rs.getInt("categoryId"));
			product.setBrandId(rs.getInt("brandId"));
			product.setQty(rs.getInt("qty"));
			product.setPrice(rs.getDouble("price"));
			product.setProductInfo(rs.getString("productInfo"));
		}
		
		ps.close();
		connection.close();
		
		return product;
		
	}
	
	public List<Product> getAllProducts() throws ClassNotFoundException, SQLException{
		
		Connection connection = getConnection();
		String query = "SELECT * FROM product";
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		List<Product> productList = new ArrayList<Product>();
		
		while(rs.next()) {
			Product product = new Product();
			
			product.setProductId(rs.getInt("productId"));
			product.setName(rs.getString("name"));
			product.setCategoryId(rs.getInt("categoryId"));
			product.setBrandId(rs.getInt("brandId"));
			product.setQty(rs.getInt("qty"));
			product.setPrice(rs.getDouble("price"));
			product.setProductInfo(rs.getString("productInfo"));
			
			productList.add(product);
		}
		
		st.close();
		connection.close();
		
		return productList;
		
	}
	
public boolean updateProduct(Product product) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		
		String query = "UPDATE product SET name = ?, categoryId = ?, brandId = ?, qty = ?, price = ?, productInfo = ? WHERE productId = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, product.getName());
		ps.setInt(2, product.getCategoryId());
		ps.setInt(3, product.getBrandId());
		ps.setInt(4, product.getQty());
		ps.setDouble(5, product.getPrice());
		ps.setString(6, product.getProductInfo());
		ps.setInt(7, product.getProductId());
		int result = ps.executeUpdate();

		ps.close();
		connection.close();
		
		return result > 0;
	}
	
	public boolean deleteProduct(int productId) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		
		String query = "DELETE FROM product WHERE productId = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, productId);
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}
}
