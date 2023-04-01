package com.bumblebee.dao;

import java.sql.*;

public class MySqlConnectorImpl implements DbConnector  {

	public Connection getDbConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		 String jdbcURL = "jdbc:mysql://localhost:3306/bumbalbee?useSSL=false";
		 String jdbcUsername= "root";
		 String jdbcPassword = "22108";
		 String jdbcDriver = "com.mysql.jdbc.Driver";
		 Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			return connection;
		
			
	}
	
	
	
	


	
}
