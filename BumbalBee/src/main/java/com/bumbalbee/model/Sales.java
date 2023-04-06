package com.bumbalbee.model;

public class Sales {

	private int salesId;
	private int productId;
	private int customerId;
	private int soldAmount;
	
	public Sales(int salesId, int productId, int customerId, int soldAmount) {
		this.salesId = salesId;
		this.productId = productId;
		this.customerId = customerId;
		this.soldAmount = soldAmount;
	}
	
	public Sales(int productId, int customerId, int soldAmount) {
		this.productId = productId;
		this.customerId = customerId;
		this.soldAmount = soldAmount;
	}

	public Sales() {
		// TODO Auto-generated constructor stub
	}

	public int getSalesId() {
		return salesId;
	}

	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getSoldAmount() {
		return soldAmount;
	}

	public void setSoldAmount(int soldAmount) {
		this.soldAmount = soldAmount;
	}
}
