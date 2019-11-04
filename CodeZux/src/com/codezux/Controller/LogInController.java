package com.codezux.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codezux.Bean.UserProfilePojo;
import com.codezux.Service.UserService;

@WebServlet("/LogInAction")
public class LogInController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		String upass = request.getParameter("upassword");
	
		// call to the service method
		UserService user = new UserService();
		boolean flag = user.userAuthenticate(uid,upass);
		UserProfilePojo userProf = new UserProfilePojo();
		if(flag == true)
		{
		
			/*
			 * java.lang.NullPointerException
	at com.codezux.DAO.UserDao.getUserProfileDetailsById(UserDao.java:122)
	at com.codezux.Service.UserService.getUserProfileDetailById(UserService.java:35)

			 */
		//	userProf = user.getUserProfileDetailById(uid);
			
			
			//request.getSession().setAttribute("user", userProf);
			
			request.getSession().setAttribute("uid", uid);
			request.getRequestDispatcher("profile.jsp").forward(request, response);
			
		}
		else
		{
			request.setAttribute("error", "Username or password incorrect");
			request.getRequestDispatcher("login.jsp").forward(request, response);			
			
		}
	}

}
