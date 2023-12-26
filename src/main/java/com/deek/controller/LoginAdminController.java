package com.deek.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deek.model.Admin;
import com.deek.model.Customer;

public class LoginAdminController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Admin tempAdmin = new Admin();
		tempAdmin.setUsername(username);
		tempAdmin.setPassword(password);
		int status = tempAdmin.loginAdmin();
		if(status ==1) {
			response.sendRedirect("/Car-service-system/loginAdminSuccess.jsp");
				
		}
		else if(status==-1) {
			response.sendRedirect("/Car-service-system/invalidAdminUsername.jsp");
		}
		else {
			response.sendRedirect("/Car-service-system/invalidAdminPassword.jsp");
			
		}
	}


}
