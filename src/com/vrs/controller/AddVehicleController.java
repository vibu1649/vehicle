package com.vrs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vrs.bo.addVehicleBO;
import com.vrs.constants.ErrorConstants;
import com.vrs.model.CustomerTO;
import com.vrs.model.VehicleTO;
import com.vrs.util.PropertyUtil;

/**
 * Servlet implementation class AddVehicleController
 */
public class AddVehicleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AddVehicleController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		VehicleTO vehicle = new VehicleTO();
		addVehicleBO vehiclebo=new addVehicleBO();
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher dispatcher = null ;
		HttpSession s=request.getSession();
		vehicle.setManufacturer_Name(request.getParameter("Manufacturer"));
		vehicle.setEx_Showroom_Price(request.getParameter("Price"));
		vehicle.setColor(request.getParameter("Color"));
		vehicle.setSeating_Capacity(request.getParameter("Seating Capacity"));
		vehicle.setBranch_Location(request.getParameter("Branch"));
		vehicle.setVehicle_code(request.getParameter("Vehicle Code"));
		vehicle.setNo_of_vehicles_available(request.getParameter("Number of Vehicles"));
		vehicle.setStock_Lasting_Date(request.getParameter("Stock_Lasting_Date"));
		try {
			System.out.println("hello");
			vehiclebo.addvehicle(vehicle);
			s.setAttribute("vehicleentrytrue", 1);
			dispatcher = request.getRequestDispatcher("addvehicle.jsp");
			dispatcher.forward(request, response);
			System.out.println("hello");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
