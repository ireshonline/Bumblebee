package com.bumbalbee.service;

import java.util.ArrayList;
import java.util.List;

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
	
	public Admin getSpecificAdmin(int adminId) {
		return new Admin();
	}
	
	public List<Admin> getAllAdmins(){
		return new ArrayList<Admin>();
	}
	
}
