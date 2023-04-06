package com.bumbalbee.dao;

import java.sql.Connection;
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
	
	public Admin getSpecificAdmin(int adminId) {
		return new Admin();
	}
	
	public List<Admin> getAllAdmin(){
		return new ArrayList<Admin>();
	}
}
