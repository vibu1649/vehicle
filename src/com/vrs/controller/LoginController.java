package com.vrs.controller;
import com.vrs.constants.ErrorConstants;
import com.vrs.constants.SuccessConstants;
import com.vrs.exceptions.ApplicationException;
import com.vrs.exceptions.BusinessException;
import com.vrs.exceptions.DatabaseOperationException;
import com.vrs.util.PropertyUtil;
import com.vrs.bo.LoginBO;
import com.vrs.model.UserTO;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.vrs.model.UserTO;
import java.util.logging.Logger;
@SuppressWarnings("unused")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger LOG = Logger.getLogger("LoginController");
	
    public LoginController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserTO user = new UserTO();
		PrintWriter pw=response.getWriter();
		final String userid = request.getParameter("userid");
		final String passWord = request.getParameter("password");
		user.setUserid(userid);
		user.setPassword(passWord);
		HttpSession session = request.getSession(true);
		final LoginBO logic = new LoginBO();
		RequestDispatcher dispatcher = null;
		try {
			user = logic.validateUser(user);
			if(user.getRole()!=null)
			{
				session.setAttribute("Role", user.getRole());
				session.setAttribute("UserID", user.getUserid());
				session.setAttribute("err", 0);
				session.setAttribute("list", null);
				session.setAttribute("size", 0);
				request.setAttribute("var1", "xx");
			}
			if(user.getRole()!=null && user.getRole().trim().equalsIgnoreCase("customer")){
				
				dispatcher = request.getRequestDispatcher("customer.jsp");
			}
			else if(user.getRole()!=null && user.getRole().trim().equalsIgnoreCase("admin"))
			{
				dispatcher = request.getRequestDispatcher("home.jsp");
			}
			else if(user.getRole()!=null && user.getRole().trim().equalsIgnoreCase("branch admin"))
			{
				dispatcher = request.getRequestDispatcher("");
			}
			dispatcher.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			dispatcher = request.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			if(user.getResult()==0)
				request.setAttribute("message", PropertyUtil.getErrorMessage(ErrorConstants.INVALIDUSERNAME));
			if(user.getResult()==1)
				request.setAttribute("message", PropertyUtil.getErrorMessage(ErrorConstants.INVALIDPASSWORD));
			dispatcher.forward(request, response);
		}
		
	}
}


