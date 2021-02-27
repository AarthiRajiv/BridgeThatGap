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
	        EmployeeDAO employeeDAO = new EmployeeDAO();	        
	        Employee e = employeeDAO.verifyLogin(request.getParameter("email"), request.getParameter("password"));			
			String nextPage="login.jsp";
			
	        if (e != null) { // login successful
	        	//save logged in Employee in session
	        	(request.getSession()).setAttribute("employee", e); 
				
	        	// if admin, fetch all employees and save in session
	        	if(e.getRole() == "admin")
	        		(request.getSession()).setAttribute("employeeList", employeeDAO.getAllEmployees());
	        	
	        	// get all consultations and save in session
	        	ConsultationDAO consultationDAO = new ConsultationDAO();	        	
	        	(request.getSession()).setAttribute("consultationList", consultationDAO.getAllConsultations());
	        	
	        	
	        	// page upon successful login	
				nextPage =  "home.jsp";
			} else  { 		// login failed
				request.setAttribute("error", "Invalid Login! Try again!");
			}
	        
			RequestDispatcher rs = request.getRequestDispatcher(nextPage);
			rs.forward(request, response);			
	       
	    } catch(SQLException e) {
	    	   throw new RuntimeException(e);
	    }

	}

    public void destroy() {
	        System.out.println("Login Servlet destroyed");
	}
}