package com.vastika.uis.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil 
{
	public static final String DRIVER= "com.mysql.cj.jdbc.Driver";
	public static final String URL= "jdbc:mysql://localhost:3306/user_form_db?useSSL=false&serverTimezone=CST";
	public static final String USERNAME= "root";
	public static final String PASSWORD="root1234";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
	
	Class.forName(DRIVER);
	return DriverManager.getConnection(URL, USERNAME, PASSWORD);

	}
}
