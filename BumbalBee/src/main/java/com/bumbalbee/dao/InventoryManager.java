package com.bumbalbee.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bumbalbee.model.Inventory;

public class InventoryManager {


	public DbConnector getDbConnector() {
		DbConnectorFactory factory = new MySqlDbConnectorFactorImpl();
		return factory.getDbConnector();
	}
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbConnector connector = getDbConnector();
		return connector.getDBConnection();
	}
	
	
	public boolean addqty(Inventory inventory) throws ClassNotFoundException, SQLException {

		Connection connection = getConnection();
		
		String query = "INSERT INTO inventory(productId, ininventory, soldQty)VALUES( ?, ?, ?)";
		
		PreparedStatement ps = connection.prepareStatement(query);	
		ps.setInt(1, inventory.getProductId());
		ps.setInt(2, inventory.getInStock());
		ps.setInt(3, inventory.getSoldQty());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}
	
	public Inventory getSpecificInventory(int inventoryId) throws ClassNotFoundException, SQLException {

		Connection connection = getConnection();
		
		String query = "SELECT * FROM inventory WHERE inventoryId = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, inventoryId);
		
		ResultSet rs = ps.executeQuery();
		Inventory inventory = new Inventory();
		
		while(rs.next()) {
			inventory.setinventoryId(rs.getInt("inventoryId"));
			inventory.setProductId(rs.getInt("productId"));
			inventory.setInStock(rs.getInt("inStock"));
			inventory.setSoldQty(rs.getInt("soldQty"));
		}
		
		ps.close();
		connection.close();
		
		return inventory;
	}
	
	public List<Inventory> getAllInventory() throws ClassNotFoundException, SQLException{

		Connection connection = getConnection();
		
		String query = "SELECT * FROM inventory";
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		List<Inventory> inventoryList = new ArrayList<Inventory>();
		
		while(rs.next()) {
			Inventory inventory = new Inventory();
			
			inventory.setinventoryId(rs.getInt("inventoryId"));
			inventory.setProductId(rs.getInt("productId"));
			inventory.setInStock(rs.getInt("instock"));
			inventory.setSoldQty(rs.getInt("soldQty"));
			
			inventoryList.add(inventory);
		}
		
		st.close();
		connection.close();
		
		return inventoryList;
	}
	
	public boolean updateInventory(Inventory inventory) throws ClassNotFoundException, SQLException {

		Connection connection = getConnection();
		
		String query = "UPDATE inventory SET productId = ?, ininventory = ?, soldQty = ? WHERE inventoryId = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, inventory.getProductId());
		ps.setInt(2, inventory.getInStock());
		ps.setInt(3, inventory.getSoldQty());
		
		int result = ps.executeUpdate();

		ps.close();
		connection.close();
		
		return result > 0;
	}
	
	public boolean deleteInventory(int inventoryId) throws ClassNotFoundException, SQLException {

		Connection connection = getConnection();
		
		String query = "DELETE FROM inventory WHERE inventoryId = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, inventoryId);
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}
}
