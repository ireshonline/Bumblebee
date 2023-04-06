package com.bumbalbee.service;

import java.sql.SQLException;
import java.util.List;

import com.bumbalbee.dao.InventoryManager;
import com.bumbalbee.model.Inventory;

public class InventoryService {
	
	private static InventoryService inventoryServiceObj;

	 public InventoryService() {
	
	}
	
	public static synchronized InventoryService getInventoryServiceInstance() {
		
		if(inventoryServiceObj == null) {
			inventoryServiceObj = new InventoryService();
		}
		
		return inventoryServiceObj;
	}
	
	private InventoryManager getInventoryManager() {
		return new InventoryManager();
	}
	
	public boolean registerinventory(Inventory inventory) throws ClassNotFoundException, SQLException {
		return getInventoryManager().addqty(inventory);
	}
	
	public Inventory getSpecificinventory(int inventoryId) throws ClassNotFoundException, SQLException {
		return getInventoryManager().getSpecificInventory(inventoryId);
	}
	
	public List<Inventory> getAllinventorys() throws ClassNotFoundException, SQLException{
		return getInventoryManager().getAllInventory();
	}
	
	public boolean editinventory(Inventory inventory) throws ClassNotFoundException, SQLException {
		return getInventoryManager().updateInventory(inventory);
	}
	
	public boolean deleteInventory(int inventoryId) throws ClassNotFoundException, SQLException {
		return getInventoryManager().deleteInventory(inventoryId);
	}

}
