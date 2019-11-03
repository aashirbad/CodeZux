package com.codezux.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codezux.Bean.UserRegistrationBean;
import com.codezux.Service.UserService;

@WebServlet("/UserRegistrationAction")
public class UserRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uName = request.getParameter("Uname");
		String uEmail = request.getParameter("Uemail");
		String uPass = request.getParameter("Upass");

		UserRegistrationBean userRegBean = new UserRegistrationBean();

		userRegBean.setUname(uName);
		userRegBean.setUemail(uEmail);
		userRegBean.setUpass(uPass);

		UserService userService = new UserService();

		/*
		 * Register into database
		 */
		try {
			int flag = userService.userRegistration(userRegBean);
			System.out.print(flag + " successfully ");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* if redgState True make sure to redirected to login page */

}
