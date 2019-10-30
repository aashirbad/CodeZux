package com.codezux.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codezux.Bean.UserRegistrationBean;
import com.codezux.Service.UserRegistrationService;

@WebServlet("/UserRegistrationAction")
public class UserRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserRegistrationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String Uname = request.getParameter("Uname");
		String Uemail = request.getParameter("Uemail");
		String Upass = request.getParameter("Upass");
		
		UserRegistrationBean userRegBean = new UserRegistrationBean();
		
		userRegBean.setUname(Uname);
		userRegBean.setUemail(Uemail);
		userRegBean.setUpass(Upass);
		
		UserRegistrationService userService = new UserRegistrationService();
		try {
			boolean redgState = userService.userRegistration(userRegBean);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* if redgState True make sure to redirected to login page */

}
