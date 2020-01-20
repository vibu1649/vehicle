package com.vrs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vrs.bo.bookingBO;
import com.vrs.model.CustomerTO;
import com.vrs.model.VehicleTO;

public class bookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public bookController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VehicleTO vehicle = new VehicleTO();
		bookingBO bookbo=new bookingBO();
		RequestDispatcher dispatcher = null ;
		PrintWriter pw= response.getWriter();
		HttpSession s=request.getSession();
		String user = (String) s.getAttribute("UserID");
		String parameter = request.getParameter("book");
		StringTokenizer st=new StringTokenizer(parameter);
		vehicle.setBranch_Location(st.nextToken());
		vehicle.setVehicle_code(st.nextToken());
		bookbo.bookVehicle(vehicle,user);
		if(vehicle.getResult()==1){
			s.setAttribute("booksuccess", "booked");
		dispatcher = request.getRequestDispatcher("search.jsp");
		dispatcher.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
