package com.bumblebee.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bumblebee.dao.ProductManger;
import com.bumblebee.model.Product;

public class ProductService {
	
	
	private static ProductService productService;

	private ProductService() {
 
	}
	
	public static synchronized ProductService getProductServiceInstance() {
		
		if(productService == null) {
			
			productService = new ProductService();
			
		}
		return productService;
		
	}
	
	private ProductManger getProductManger() {
		return new ProductManger();
	}

	public boolean registerProduct(Product product) throws ClassNotFoundException, SQLException {

		return getProductManger().addProduct(product);
	}

	public  Product getSpecificProduct(int productId) throws ClassNotFoundException, SQLException {

		return getProductManger().getSpecificProduct(productId);
	}


	public List<Product> getAlLProducts() throws ClassNotFoundException, SQLException{
		return getProductManger().getAllProducts();
	}

	public  boolean editProduct(Product product) throws ClassNotFoundException, SQLException {

		return getProductManger().updateProduct(product);
	}
	
	public boolean deleteProduct(int productCode) throws ClassNotFoundException, SQLException {
		return getProductManger().deleteProduct(productCode);
	}
	
	

}
