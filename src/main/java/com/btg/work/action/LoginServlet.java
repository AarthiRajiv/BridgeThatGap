package com.btg.work.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.btg.work.model.*;

public class LoginServlet extends HttpServlet {	 
	public void init(ServletConfig config) {
		System.out.println("Login Servlet initialized");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    try  {
	    	System.out.println("Login Servlet GET()");
	        EmployeeDAO employeeDAO = new EmployeeDAOImpl();	        
	        Employee e = employeeDAO.verifyLogin(request.getParameter("email"), request.getParameter("password"));			
			
	        (request.getSession()).setAttribute("employee", e);	
			RequestDispatcher rs = request.getRequestDispatcher("home.jsp");
			rs.forward(request, response);			
	       
	    } catch(SQLException e) {
	    	   throw new RuntimeException(e);
	    }

	}

    public void destroy() {
	        System.out.println("Login Servlet destroyed");
	}
}