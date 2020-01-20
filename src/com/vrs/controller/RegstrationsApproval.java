package com.vrs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vrs.bo.AdminBO;
import com.vrs.constants.ErrorConstants;
import com.vrs.model.UserTO;

public class RegstrationsApproval extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public RegstrationsApproval() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		RequestDispatcher dispatcher=null;
		String[] userids = request.getParameterValues("check");
		HttpSession session = request.getSession(true);
		AdminBO adbo=new AdminBO();
		int count = adbo.approveRegistrations(userids);
		if(count==userids.length)
		{
			session.setAttribute("successapproce", 1);
			dispatcher = request.getRequestDispatcher("userregistrations.jsp");
			dispatcher.forward(request, response);;
		}
		
		
	}

}
