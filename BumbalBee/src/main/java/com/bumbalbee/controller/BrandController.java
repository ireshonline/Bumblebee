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

import com.bumbalbee.service.BrandService;
import com.bumbalbee.model.Brand;


public class BrandController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BrandService service;

	public BrandController() {
		service = BrandService.getBrandServiceInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());


		String type = request.getParameter("type");

		if(type != null && type.equals("specific")) {
			searchSpecificBrand(request, response);
		}
		else {
			searchAllBrands(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String type = request.getParameter("type");

		if(type != null && type.equals("add")) {
			addBrand(request, response);
		}
		else if(type.equals("update")) {
			updateBrand(request, response);
		} 
		else if(type != null && type.equals("delete")) {
			deleteBrand(request, response);
		}

	}


	private void addBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";

		String brandName = request.getParameter("brandName");

		Brand brand = new Brand(brandName);
		try {
			boolean result = service.registerBrand(brand);
			if(result) {
				message = "Brand " + brandName + " successfully added!";
			}
			else {
				message = "Brand " + brandName + " NOT added!!";
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}

		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("add_brand.jsp");
		rd.forward(request, response);

	}

	private void searchSpecificBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";

		Brand brand = new Brand();
		int brandId = Integer.parseInt(request.getParameter("brandId"));

		try {
			brand = service.getSpecificBrand(brandId);
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}

		request.setAttribute("message", message);
		request.setAttribute("brand", brand);

		RequestDispatcher rd = request.getRequestDispatcher("update_brand.jsp");
		rd.forward(request, response);
	}

	private void searchAllBrands(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";

		List<Brand> brandList;

		try {
			brandList = service.getAllBrands();
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
			brandList = new ArrayList<Brand>();
		}

		request.setAttribute("message", message);
		request.setAttribute("brandList", brandList);

		RequestDispatcher rd = request.getRequestDispatcher("all_brands.jsp");
		rd.forward(request, response);

	}

	private void updateBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";

		int brandId = Integer.parseInt(request.getParameter("brandId"));
		String brandName = request.getParameter("brandName");

		Brand brand = new Brand(brandId, brandName);

		try {
			boolean result = service.editBrand(brand);
			if(result) {
				message = "Brand " + brandId + " updated";
			}
			else {
				message = "Brand " + brandId + " updation faild!!";
			}

		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}

		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("update_brand.jsp");
		rd.forward(request, response);

	}

	private void deleteBrand(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String message = "";

		int brandId = Integer.parseInt(request.getParameter("brandId"));

		try {
			boolean result = service.deleteBrand(brandId);

			if(result) {
				message = "Brand successfully deleted";
			}
			else {
				message = "Something went wrong. Please try in a moment!!";
			}

		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}

		HttpSession session = request.getSession();
		session.setAttribute("message", message);

		response.sendRedirect("brandcontroller");
	}

}
