package com.codezux.Service;

import java.sql.SQLException;

import com.codezux.Bean.UserRegistrationBean;
import com.codezux.DAO.UserRegistrationDAO;

public class UserService 
{
	UserRegistrationDAO userDao = new UserRegistrationDAO();
	
	public boolean userRegistration(UserRegistrationBean UserRegBeans) throws SQLException {
	
		return userDao.registrationUser( UserRegBeans );
		
		
	}
}
