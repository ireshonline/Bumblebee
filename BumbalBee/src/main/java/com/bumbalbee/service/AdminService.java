package com.bumbalbee.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bumbalbee.dao.AdminManager;
import com.bumbalbee.model.Admin;

public class AdminService {

	private static AdminService adminServiceObj;

	public AdminService() {
		// TODO Auto-generated constructor stub
	}
	
	public static synchronized AdminService getAdminServiceInstance() {
		
		if(adminServiceObj == null) {
			adminServiceObj = new AdminService();
		}
		
		return adminServiceObj;	
	}
	
	private AdminManager getAdminManager() {
		return new AdminManager();
	}
	
	public Admin validateAdmin(String email, String password) throws ClassNotFoundException, SQLException {
		return getAdminManager().validateAdmin(email, password);
	}
}
