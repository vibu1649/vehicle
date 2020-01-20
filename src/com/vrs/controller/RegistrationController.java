package com.vrs.controller;

import java.io.IOException;
//import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.vrs.bo.LoginBO;
import com.vrs.bo.RegisterBO;
import com.vrs.constants.ErrorConstants;
import com.vrs.model.UserTO;
import com.vrs.util.PropertyUtil;


public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrationController() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserTO user = new UserTO();
		RequestDispatcher dispatcher = null ;
		//PrintWriter pw=response.getWriter();
		final String userid = request.getParameter("USERID");
		final String password = request.getParameter("PASSWORD");
		final String password2 = request.getParameter("PASSWORD2");
		final String role = request.getParameter("ROLE");
		System.out.println(role);
		HttpSession s=request.getSession();
		if(role==null){
			s.setAttribute("error1", 1);
			response.sendRedirect("index.jsp");
		}
		else if(!(password.equals(password2))){
			s.setAttribute("error", 2);
			response.sendRedirect("index.jsp");
		}else
		{
			SimpleDateFormat sdf= new SimpleDateFormat();
			Date d=new Date();
			user.setUserid(userid);
			user.setPassword(password);
			user.setRole(role);
			user.setStatus("F");
			user.setDate(sdf.format(d));
			System.out.println("in else");
			final RegisterBO register = new RegisterBO();
			try
			{
				System.out.println("in try 1");
				register.addUser(user);
				System.out.println("in try 2");
				s.setAttribute("success", 3);
				dispatcher = request.getRequestDispatcher("index.jsp");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				dispatcher = request.getRequestDispatcher(ErrorConstants.ERRORPAGE);
				if(user.getResult()==1)
					request.setAttribute("message", PropertyUtil.getErrorMessage(ErrorConstants.INVALIDUSERNAME));
				if(user.getResult()==2)
					request.setAttribute("message", PropertyUtil.getErrorMessage(ErrorConstants.INVALIDPASSWORD));
			}
			dispatcher.forward(request, response);
		}
		
		
		
	}

}
