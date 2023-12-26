package com.deek.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deek.model.Customer;

public class LoginCustomerController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Customer tempCustomer = new Customer();
		tempCustomer.setUsername(username);
		tempCustomer.setPassword(password);
		int status = tempCustomer.loginCustomer();
		if(status ==1) {
			HttpSession session = request.getSession(true);
			session.setAttribute("susername", username);
			String name = tempCustomer.getName();
			session.setAttribute("sname", name);
			response.sendRedirect("/Car-service-system/loginCustomerSuccess.jsp");
			
			
		}
		else if(status==-1) {
			response.sendRedirect("/Car-service-system/invalidCustomerUsername.jsp");
		}
		else {
			response.sendRedirect("/Car-service-system/invalidCustomerPassword.jsp");
			
		}
	}


}



