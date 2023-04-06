package com.bumbalbee.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bumbalbee.model.Product;
import com.bumbalbee.service.ProductService;

/**
 * Servlet implementation class ProductController
 */
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private ProductService service;

	public ProductController() {
		service = ProductService.getProductServiceInstance();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());


		String type = request.getParameter("type");

		if(type != null && type.equals("specific")) {
			searchSpecificProduct(request, response);
		}
		else {
			searchAllProducts(request, response);
		}


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

		String type = request.getParameter("type");

		if(type != null && type.equals("add")) {
			addProduct(request, response);
		}
		else if(type != null && type.equals("update")) {
			updateProduct(request, response);
		} 
		else if(type != null && type.equals("delete")) {
			deleteProduct(request, response);
		}
	}

	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";

		String productName = request.getParameter("productName");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		int brandId = Integer.parseInt(request.getParameter("brandId"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		double price = Double.parseDouble(request.getParameter("price"));
		String productInfo = request.getParameter("productInfo");

		Product product = new Product(productName, categoryId, brandId, qty, price, productInfo);
		try {
			boolean result = service.registerProduct(product);
			if(result) {
				message = "Product " + productName + " successfully added!";
			}
			else {
				message = "Product " + productName + " NOT added!!";
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}

		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("addproduct.jsp");
		rd.forward(request, response);

	}

	private void searchSpecificProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";

		Product product = new Product();
		int productId = Integer.parseInt(request.getParameter("productId"));

		try {
			product = service.getSpecificProduct(productId);
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}

		request.setAttribute("message", message);
		request.setAttribute("product", product);

		RequestDispatcher rd = request.getRequestDispatcher("updateproduct.jsp");
		rd.forward(request, response);

	}

	private void searchAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";

		List<Product> productList;

		try {
			productList = service.getAllProducts();
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
			productList = new ArrayList<Product>();
		}

		request.setAttribute("message", message);
		request.setAttribute("productList", productList);

		RequestDispatcher rd = request.getRequestDispatcher("allproducts.jsp");
		rd.forward(request, response);

	}

	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";

		int productId = Integer.parseInt(request.getParameter("productId"));
		String name = request.getParameter("name");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		int brandId = Integer.parseInt(request.getParameter("brandId"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		double price = Double.parseDouble(request.getParameter("price"));
		String productInfo = request.getParameter("productInfo");

		Product product = new Product(productId, name, categoryId, brandId, qty, price, productInfo);

		try {
			boolean result = service.editProduct(product);
			if(result) {
				message = "Product " + productId + " updated";
			}
			else {
				message = "Product " + productId + " updation faild!!";
			}

		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}

		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("updateproduct.jsp");
		rd.forward(request, response);

	}

	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String message = "";

		int productId = Integer.parseInt(request.getParameter("productId"));

		try {
			boolean result = service.deleteTheProduct(productId);

			if(result) {
				message = "Product successfully deleted";
			}
			else {
				message = "Something went wrong. Please try in a moment!!";
			}

		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}

		HttpSession session = request.getSession();
		session.setAttribute("message", message);

		response.sendRedirect("product_controller");

	}
}
