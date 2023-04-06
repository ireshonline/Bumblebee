package com.bumbalbee.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bumbalbee.model.Brand;

public class BrandManager {

	public DbConnector getDbConnector() {
		DbConnectorFactory factory = new MySqlDbConnectorFactorImpl();
		return factory.getDbConnector();
	}
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbConnector connector = getDbConnector();
		return connector.getDBConnection();
	}
	
	public boolean addBrand(Brand brand) throws ClassNotFoundException, SQLException {

		Connection connection = getConnection();
		
		String query = "INSERT INTO brand(brandName)VALUES( ?)";
		
		PreparedStatement ps = connection.prepareStatement(query);	
		ps.setString(1, brand.getBrandName());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
		
	}
	public Brand getSpecificBrand(int brandId) throws ClassNotFoundException, SQLException {

		Connection connection = getConnection();
		
		String query = "SELECT * FROM brand WHERE brandId = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, brandId);
		
		ResultSet rs = ps.executeQuery();
		Brand brand = new Brand();
		
		while(rs.next()) {
			brand.setBrandId(rs.getInt("brandId"));
			brand.setBrandName(rs.getString("brandName"));
		}
		
		ps.close();
		connection.close();
		
		return brand;
		
	}
	public List<Brand> getAllBrands() throws SQLException, ClassNotFoundException{

		Connection connection = getConnection();
		
		String query = "SELECT * FROM brand";
		
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		List<Brand> brandList = new ArrayList<Brand>();
		
		while(rs.next()) {
			Brand brand = new Brand();
			
			brand.setBrandId(rs.getInt("brandId"));
			brand.setBrandName(rs.getString("brandName"));
			
			brandList.add(brand);
		}
		
		st.close();
		connection.close();
		
		return brandList;
		
	}
	public boolean updateBrand(Brand brand) throws ClassNotFoundException, SQLException {

		Connection connection = getConnection();
		
		String query = "UPDATE brand SET brandName = ? WHERE brandId = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, brand.getBrandName());
		ps.setInt(2, brand.getBrandId());
		int result = ps.executeUpdate();

		ps.close();
		connection.close();
		
		return result > 0;
		
	}
	
	public boolean deleteBrand(int brandId) throws ClassNotFoundException, SQLException {

		Connection connection = getConnection();
		
		String query = "DELETE FROM brand WHERE brandId = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, brandId);
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
		
	}
	
}
