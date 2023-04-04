package com.bumblebee.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bumblebee.model.Product;
import com.bumblebee.service.ProductService;
import com.google.protobuf.Message;
import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	private ProductService service;
	public ProductServlet() {
		service = ProductService.getProductServiceInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");

		if(type.equals("Specific")) {
			searchSpecificProduct(request, response);
		}else {
			searchAllProduct(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");

		if(type != null && type.equals("Add")) {
			
				try {
					addProduct(request, response);
				} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}else if(type != null && type.equals("update")){
			searchAllProduct(request, response);
		}else if (type != null && type.equals("delete")) {
			deleteProduct(request, response);
		}
	}
	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {

		String message = "";

		String productName = request.getParameter("name");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		int brandId = Integer.parseInt(request.getParameter("brandId"));
		double price = Double.parseDouble(request.getParameter("price"));
		String description = request.getParameter("description");
		String create = request.getParameter("create");

		Product product = new Product(productName, categoryId, brandId, qty, price, description, create);
		try {
			boolean reuslt = service.registerProduct(product);
			if(reuslt) {
				message = "The Product has been successfully Added Product Name:" + productName; 
			}else {
				message = "The Product has been unsuccessfully Added Product Name:" + productName;
			}
		} catch (Exception e) {
			message = e.getMessage();
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("register-product.jsp");
		rd.forward(request, response);
	}

	private void searchSpecificProduct(HttpServletRequest request, HttpServletResponse response) {

	}
	private void searchAllProduct(HttpServletRequest request, HttpServletResponse response) {

	}
	private void updateProduct(HttpServletRequest request, HttpServletResponse response) {


	}
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {

	}
}
