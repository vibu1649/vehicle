package com.vrs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vrs.bo.CustomerProfileBO;
import com.vrs.constants.ErrorConstants;

import com.vrs.model.CustomerTO;
import com.vrs.util.PropertyUtil;


public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CustomerProfileBO customerbo =new CustomerProfileBO();
	
    public ProfileController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CustomerTO customer = new CustomerTO();
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher dispatcher = null ;
		HttpSession s=request.getSession();
		customer.setLogin_id((String) s.getAttribute("UserID"));
		customer.setCustomer_Name(request.getParameter("username"));
		customer.setDob(request.getParameter("dob"));
		customer.setAddress(request.getParameter("address"));
		customer.setPhone(request.getParameter("phno"));
		customer.setEmail(request.getParameter("email"));
		customer.setOccupation(request.getParameter("ocupation"));
		try {
			System.out.println("hello");
			customerbo.addProfile(customer);
			s.setAttribute("profileentrytrue", 1);
			dispatcher = request.getRequestDispatcher("profile.jsp");
			dispatcher.forward(request, response);
			System.out.println("hello");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			dispatcher = request.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			if(customer.getResult()==1)
				request.setAttribute("message", PropertyUtil.getErrorMessage(ErrorConstants.INVALIDUSERNAME));
			if(customer.getResult()==2)
				request.setAttribute("message", PropertyUtil.getErrorMessage(ErrorConstants.INVALID_EMAIL));
			if(customer.getResult()==3)
				request.setAttribute("message", PropertyUtil.getErrorMessage(ErrorConstants.INVALID_PHONE));
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
}
}