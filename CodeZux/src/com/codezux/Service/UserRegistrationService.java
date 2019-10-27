package com.codezux.Service;

import java.sql.SQLException;

import com.codezux.Bean.UserRegistrationBean;
import com.codezux.DAO.UserRegistrationDAO;

public class UserRegistrationService {
	public boolean userRegistration(UserRegistrationBean U) throws SQLException {
		UserRegistrationDAO user = new UserRegistrationDAO();
		return user.registrationUser(U);
	}
}
