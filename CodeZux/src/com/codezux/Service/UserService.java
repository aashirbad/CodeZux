package com.codezux.Service;

import java.sql.SQLException;

import com.codezux.Bean.UserRegistrationBean;
import com.codezux.DAO.UserRegistrationDAO;

public class UserService 
{
	UserRegistrationDAO userDao = new UserRegistrationDAO();
	
	public int userRegistration(UserRegistrationBean UserRegBeans) throws SQLException {
		int flag;
		flag =userDao.registrationUser( UserRegBeans );
		return flag;
//		if(flag != 0 )
//		{
//			userDao.update( UserRegBeans);
//		}
//		return flag;
		
		
	}
}
