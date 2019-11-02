package com.codezux.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
		if(flag == true)
		{
			response.getWriter().print("Hey You are now in our world...");
		}
		else
		{
			response.getWriter().print("Sorry ...U may entered Wrong credentials ...\n try again ...");
			response.sendRedirect("login.jsp");
			
		}
	}

}
