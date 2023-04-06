package com.bumbalbee.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbConnector {
	
	Connection getDBConnection() throws SQLException, ClassNotFoundException;

}
