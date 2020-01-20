package com.vrs.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vrs.bo.AdminBO;
import com.vrs.bo.VehicleBO;
import com.vrs.model.AdminTO;
import com.vrs.model.VehicleTO;
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminBO adminBO=new AdminBO(); 
	AdminTO adminBean=new AdminTO();
    
    public AdminController() {
        super();  
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher;
		String[] vehicles = request.getParameterValues("approve");
		HttpSession session = request.getSession(true);
		AdminBO adbo=new AdminBO();
		int count = adbo.approveVehicles(vehicles);
		if(count==vehicles.length)
		{
			session.setAttribute("successveh", 1);
			dispatcher = request.getRequestDispatcher("userregistrations.jsp");
			dispatcher.forward(request, response);;
		}
		
	}
}
