package com.bumbalbee.service;

import java.util.ArrayList;
import java.util.List;

import com.bumbalbee.model.Sales;

public class SalesService {

	private static SalesService salesServiceObj;

	public SalesService() {
		// TODO Auto-generated constructor stub
	}
	
	public static synchronized SalesService getSalesServiceInstance() {
		if(salesServiceObj == null) {
			salesServiceObj = new SalesService();
		}
		return salesServiceObj;
	}
	
	public boolean registerSales(Sales sales) {
		return false;
	}
	
	public Sales getSpecificSales(int salesId) {
		return new Sales();
	}
	
	public List<Sales> getAllPeyments(){
		return new ArrayList<Sales>();
	}
	
	public boolean editSales(Sales sales) {
		return false;
	}
	
	public boolean deleteSales(int salesId) {
		return false;
	}
}
