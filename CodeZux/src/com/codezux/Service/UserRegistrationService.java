package com.codezux.Service;

import java.sql.SQLException;

import com.codezux.Bean.UserRegistrationBean;
import com.codezux.DAO.UserRegistrationDAO;

public class UserRegistrationService 
{
	
	public boolean userRegistration(UserRegistrationBean UserRegBeans) throws SQLException {
	
		UserRegistrationDAO userDao = new UserRegistrationDAO();
		return userDao.registrationUser( UserRegBeans );
		
		
	}
}
