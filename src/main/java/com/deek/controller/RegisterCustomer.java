package com.deek.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deek.model.Customer;


public class RegisterCustomer extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmpassword");
		String email = request.getParameter("email");
		if(!password.equals(confirmPassword)) {
			response.sendRedirect("/Car-service-system/passwordMismatch.html");
			
		}
		else {
			Customer tempCustomer = new Customer();
			tempCustomer.setName(name);
			tempCustomer.setUsername(username);
			tempCustomer.setPassword(password);
			tempCustomer.setEmail(email);
			int status = tempCustomer.getDetails();
			if(status==-1) {
				response.sendRedirect("/Car-service-system/duplicateUsername.html");
			}
			else if(status==1) {
				response.sendRedirect("/Car-service-system/registerSuccess.jsp");
			}
			else {
				response.sendRedirect("/Car-service-system/registerFailure.jsp");
			}
		}
	}
}
