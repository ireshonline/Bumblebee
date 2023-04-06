package com.bumbalbee.service;

import java.sql.SQLException;
import java.util.List;

import com.bumbalbee.dao.CategoryManager;
import com.bumbalbee.model.Category;

public class CategoryService {


	private static CategoryService categoryServiceObj;

	public CategoryService() {
	}
	
	public static synchronized CategoryService getCategoryServiceInstance() {
		
		if(categoryServiceObj == null) {
			categoryServiceObj = new CategoryService();
		}
		
		return categoryServiceObj;
	}
	
	private CategoryManager getCategoryManager() {
		return new CategoryManager();
	}
	
	public boolean registerCategory(Category category) throws ClassNotFoundException, SQLException {
		return getCategoryManager().addCategory(category);
	}
	
	public Category getSpecificCategory(int categoryId) throws ClassNotFoundException, SQLException {
		return getCategoryManager().getSpecificCategory(categoryId);
	}
	
	public List<Category> getAllCategories() throws ClassNotFoundException, SQLException{
		return getCategoryManager().getAllCategories();
	}
	
	public boolean editCategory(Category category) throws ClassNotFoundException, SQLException {
		return getCategoryManager().updateCategory(category);
	}
	
	public boolean deleteCategory(int categoryId) throws ClassNotFoundException, SQLException {
		return getCategoryManager().deleteCategory(categoryId);
	}
	
}
