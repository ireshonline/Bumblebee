package com.bumbalbee.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bumbalbee.model.Admin;
import com.bumbalbee.service.AdminService;

/**
 * Servlet implementation class AdminController
 */
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminService service;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	private void validateAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			Admin admin = service.validateAdmin(email, password);
			
			if(admin != null) {
				String path = "add-product.jsp";
			    RequestDispatcher rd = request.getRequestDispatcher(path);
			    rd.forward(request, response);
			}
			else {
				message = "Username or Password invalid!!";
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("auth-admin.jsp");
		rd.forward(request, response);
	}


}
