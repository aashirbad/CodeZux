package com.codezux.Service;

import java.sql.SQLException;

import com.codezux.Bean.UserRegistrationBean;
import com.codezux.DAO.UserDao;

public class UserService 
{
	UserDao userDao = new UserDao();
	
	
	// User Registratioin
	public int userRegistration(UserRegistrationBean UserRegBeans) throws SQLException {
		int flag;
		flag =userDao.registrationUser( UserRegBeans );
		return flag;

		
		
	}
	// User Authentication
	public boolean userAuthenticate(int uid, String upass) {
		
		return userDao.authenticateUser(uid,upass);
			
		
	}
}
