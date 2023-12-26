package com.deek.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deek.model.Car;

public class AddCarDetails extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cartype = request.getParameter("cartype");
		String carmodel = request.getParameter("carmodel");
		String carregno = request.getParameter("carregno");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("susername");
		Car tempCar = new Car();
		tempCar.setCartype(cartype);
		tempCar.setCarmodel(carmodel);
		tempCar.setCarregno(carregno);
		tempCar.setUsername(username);
		int status = tempCar.addCarDetails();
		if(status==0 || status==-1 ) {
			response.sendRedirect("/Car-service-system/addCarDetailsFailure.jsp");
			
			
		}
		else {
			response.sendRedirect("/Car-service-system/addCarDetailsSuccess.jsp");
		}
		
		
		
	}


}
