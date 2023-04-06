package com.bumbalbee.service;

import java.sql.SQLException;
import java.util.List;

import com.bumbalbee.dao.CustomerManager;
import com.bumbalbee.model.Customer;

public class CustomerService {

	private static CustomerService customerServiceObj;

	public CustomerService() {
		// TODO Auto-generated constructor stub
	}
	
	public static synchronized CustomerService getCustomerServiceInstance() {
		
		if(customerServiceObj == null) {
			customerServiceObj = new CustomerService();
		}
		
		return customerServiceObj;	
	}
	
	private CustomerManager getCustomerManager() {
		return new CustomerManager();
	}
	
	public boolean registerCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		return getCustomerManager().addCustomer(customer);
	}
	
	public Customer getSpecificCustomer(int customerId) throws ClassNotFoundException, SQLException {
		return getCustomerManager().getSpecificCustomer(customerId);
	}
	
	public List<Customer> getAllCustomers() throws ClassNotFoundException, SQLException{
		return getCustomerManager().getAllCustomers();
	}
	
	public boolean editCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		return getCustomerManager().updateCustomer(customer);
	}
	
	public boolean deleteCustomer(int customerId) throws ClassNotFoundException, SQLException {
		return getCustomerManager().deleteCustomer(customerId);
	}
	
}
