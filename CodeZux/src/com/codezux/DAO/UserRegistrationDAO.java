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
		try {
			PreparedStatement ps = con.prepareStatement("insert into test.userProfile values "+ user.get);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		return false;
		
	}

}