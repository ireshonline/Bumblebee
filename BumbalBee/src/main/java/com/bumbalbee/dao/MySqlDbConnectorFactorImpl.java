package com.bumbalbee.dao;

public class MySqlDbConnectorFactorImpl implements DbConnectorFactory{
	
	

	@Override
	public DbConnector getDbConnector() {
		// TODO Auto-generated method stub
		return new MySqlConnectorImpl();
	}

}
