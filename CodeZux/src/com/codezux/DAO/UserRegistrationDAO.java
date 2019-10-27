package com.codezux.DAO;

import com.codezux.Bean.UserRegistrationBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRegistrationDAO {
	public boolean registrationUser(UserRegistrationBean user) throws SQLException {
		Connection conn = null;
		conn = DBConnection.getConnect();
		PreparedStatement stmt = conn.prepareStatement("insert into test values(user.getUname(),user.getUemail(),user.getUpass()");
		ResultSet res = stmt.executeQuery();
		if(res.next()) {
			return true; 
		}
		else { 
			return false; 
		}
		
	}
}