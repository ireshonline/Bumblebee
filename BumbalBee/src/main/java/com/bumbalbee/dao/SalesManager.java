package com.bumbalbee.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bumbalbee.model.Sales;

public class SalesManager {

	public DbConnector getDbConnector() {
		DbConnectorFactory factory = new MySqlDbConnectorFactorImpl();
		return factory.getDbConnector();
	}
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbConnector connector = getDbConnector();
		return connector.getDBConnection();
	}
	
	
	public boolean addSales(Sales sales) {
		return false;
	}
	
	public Sales getSpecificSales(int salesId) {
		return new Sales();
	}
	
	public List<Sales> getAllSaless(){
		return new ArrayList<Sales>();
	}
	
	public boolean updateSales(Sales sales) {
		return false;
	}
	
	public boolean deleteSales(int salesId) {
		return false;
	}
}
