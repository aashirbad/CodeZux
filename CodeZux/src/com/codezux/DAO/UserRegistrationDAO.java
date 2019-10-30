package com.codezux.DAO;

import com.codezux.Bean.UserRegistrationBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRegistrationDAO {
	public boolean registrationUser(UserRegistrationBean user)  {
		
		Connection con = null;
		con =  DBConnection.getConnect();
		preparedStatement ps = con.prepareStatement("insert into)
		
		
		
		
		
		
		
		return false;
		
	}

}