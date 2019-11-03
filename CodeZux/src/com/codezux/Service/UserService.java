package com.codezux.Service;

import java.sql.SQLException;

import com.codezux.Bean.UserProfilePojo;
import com.codezux.Bean.UserRegistrationBean;
import com.codezux.DAO.UserDao;

public class UserService 
{
	UserDao userDao = new UserDao();
	
	
	// User Registration
	public int userRegistration(UserRegistrationBean UserRegBeans) throws SQLException {
		int flag;
		flag =userDao.registrationUser( UserRegBeans );
		return flag;

		
		
	}
	// User Authentication
	public boolean userAuthenticate(int uid, String upass) {
		
		return userDao.authenticateUser(uid,upass);
			
		
	}
	
	/*
	 * java.lang.NullPointerException
	at com.codezux.DAO.UserDao.getUserProfileDetailsById(UserDao.java:122)
	at com.codezux.Service.UserService.getUserProfileDetailById(UserService.java:35)

	 * 
	 
	// gives the user's profile object
	public UserProfilePojo getUserProfileDetailById(int uid) {
	
		return userDao.getUserProfileDetailsById(uid);
	}
	
	*/
}
