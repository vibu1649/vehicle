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

import com.vrs.bo.BookedBO;
import com.vrs.bo.LoginBO;
import com.vrs.exceptions.BusinessException;
import com.vrs.model.BookedTO;

public class MyvehicleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MyvehicleController() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		HttpSession session = request.getSession(true);
		BookedBO booked = new BookedBO();
		RequestDispatcher dispatcher = null;
		try {
			List<BookedTO> list = booked.bookings((String)session.getAttribute("UserID"));
			session.setAttribute("myvehicle", list);
			request.getRequestDispatcher("myVehicles.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("err", 1);
			request.getRequestDispatcher("myVehicles.jsp").forward(request, response);
		} 
		
		
		
		
	}

}
