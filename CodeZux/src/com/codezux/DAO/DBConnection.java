package com.codezux.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	
	public static Connection getConnect() 
	{
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","cool") ;
			return con;
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return con;
		
	}
	public static void main(String[] args) {
	
	// Checking For Establishing Connecting
		if(getConnect() != null)
		{
			 System.out.println("Connected ..!!");
		}

	}

}