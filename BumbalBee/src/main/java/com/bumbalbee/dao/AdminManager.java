package com.bumbalbee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bumbalbee.model.Admin;

public class AdminManager {

	public DbConnector getDbConnector() {
		DbConnectorFactory factory = new MySqlDbConnectorFactorImpl();
		return factory.getDbConnector();
	}
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		
		DbConnector connector = getDbConnector();
		return connector.getDBConnection();
	}
	
public Admin validateAdmin(String email, String password) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		Admin admin = null;
		
		String query = "SELECT * FROM admin WHERE email = ? AND password = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, email);
		ps.setString(2, password);
	
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			admin = new Admin();
			admin.setEmail(rs.getString("email"));
		}
		
		ps.close();
		connection.close();
		
		return admin;
	}
}
