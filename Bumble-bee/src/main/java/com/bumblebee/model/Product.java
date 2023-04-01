package com.bumblebee.model;

import java.util.Date;

public class Product {

	
	private int productId;
	private String name;
	private int categoryId;
	private int brandId;
	private int qty;
	private double price;
	private String description;
	private Date create;
	
	public Product(int productId, String name, int categoryId, int brandId, int qty, double price, String description,
			Date create) {
		
		this.productId = productId;
		this.name = name;
		this.categoryId = categoryId;
		this.brandId = brandId;
		this.qty = qty;
		this.price = price;
		this.description = description;
		this.create = create;
	}
	
	
	public Product() {

	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public int getBrandId() {
		return brandId;
	}


	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getCreate() {
		return create;
	}


	public void setCreate(Date create) {
		this.create = create;
	}
	
	
	
	
	
	
	
	
	
	
	
}
