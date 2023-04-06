package com.bumbalbee.service;

import java.sql.SQLException;
import java.util.List;

import com.bumbalbee.dao.ProductManager;
import com.bumbalbee.model.Product;

public class ProductService {

	private static ProductService productServiceObj;

	private ProductService() {
		// TODO Auto-generated constructor stub
	}
	
	public static synchronized ProductService getProductServiceInstance() {
		
		if(productServiceObj == null) {
			
			productServiceObj = new ProductService();
			
		}
		return productServiceObj;
		
	}
	
	
	private ProductManager getProductManager() {
		return new ProductManager();
	}
	
	public boolean registerProduct(Product product) throws ClassNotFoundException, SQLException  {
		return getProductManager().addProduct(product);
	}
	
	public Product getSpecificProduct(int productId) throws ClassNotFoundException, SQLException {
		return getProductManager().getSpeclifcProduct(productId);
	}
	
	public List<Product> getAllProducts() throws ClassNotFoundException, SQLException {
		return getProductManager().getAllProducts();
	}
	
	public boolean editProduct(Product product) throws ClassNotFoundException, SQLException {
		return getProductManager().updateProduct(product);
	}
	
	public boolean deleteTheProduct(int productId) throws ClassNotFoundException, SQLException {
		return getProductManager().deleteProduct(productId);
	}
}
