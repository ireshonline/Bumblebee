package com.bumbalbee.model;

public class Inventory {

	private int inventoryId;
	private int productId;
	private int inStock;
	private int soldQty;
	
	public Inventory(int inventoryId, int productId, int inStock, int soldQty) {
		this.inventoryId = inventoryId;
		this.productId = productId;
		this.inStock = inStock;
		this.soldQty = soldQty;
	}
	
	public Inventory(int productId, int inStock, int soldQty) {
		this.productId = productId;
		this.inStock = inStock;
		this.soldQty = soldQty;
	}

	public Inventory() {
		// TODO Auto-generated constructor stub
	}

	public int getinventoryId() {
		return inventoryId;
	}

	public void setinventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	public int getSoldQty() {
		return soldQty;
	}

	public void setSoldQty(int soldQty) {
		this.soldQty = soldQty;
	}

	
}
