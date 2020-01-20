package com.vrs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vrs.bo.SearchBO;
import com.vrs.model.VehicleTO;

public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SearchController() {
        super();
      
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VehicleTO vehicle =new VehicleTO();
		RequestDispatcher dispatcher = null ;
		PrintWriter pw=response.getWriter();
		HttpSession s=request.getSession();
		SearchBO search= new SearchBO();
		String FirstSelect = request.getParameter("selecttype");
		ArrayList<String> ArrayVehicle = search.Search(FirstSelect);
		int size = ArrayVehicle.size();
		if(size>0)
		{
			s.setAttribute("err",1);
			s.setAttribute("list", ArrayVehicle);
			s.setAttribute("size", size);
			s.setAttribute("FirstSelect",FirstSelect);
			request.getRequestDispatcher("search.jsp").forward(request, response);
		}
		else
		{
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//VehicleTO vehicle =new VehicleTO();
		RequestDispatcher dispatcher = null;
		//PrintWriter pw=response.getWriter();
		HttpSession s=request.getSession();
		SearchBO search= new SearchBO();
		String SecondSelect = request.getParameter("selecttype2");
		List<VehicleTO> vehicles = search.searchItems((String)s.getAttribute("FirstSelect"),SecondSelect );
		System.out.println("after caling");
		if(vehicles.size()>0){
			System.out.println("before setting");
			s.setAttribute("vehiclesPojo", vehicles);
			System.out.println("after setting");
			dispatcher = request.getRequestDispatcher("search.jsp");
					dispatcher.forward(request, response);
		}
		else if(vehicles.size()==0)
		{
			
		}
		else
		{
			
		}
	}
}
