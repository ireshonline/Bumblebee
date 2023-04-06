package com.bumbalbee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnectorImpl implements DbConnector{
	

	@Override
	public Connection getDBConnection() throws SQLException,ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1:3306/bumbalbee";
		String userName = "root";
		String password = "22108";
		
		Connection connection = DriverManager.getConnection(url,userName,password);
		
		return connection;
	}

}
