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

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.btg.work.model.*;

public class LoginServlet extends HttpServlet {	 
	private static Logger log = LogManager.getLogger(LoginServlet.class);
	
	public void init(ServletConfig config) {
		log.trace("Login Servlet initialized");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    try  {
	    	log.trace("Login Servlet POST()");
	        EmployeeDAO employeeDAO = new EmployeeDAO();	        
	        Employee e = employeeDAO.verifyLogin(request.getParameter("email"), request.getParameter("password"));			
			String nextPage="home.jsp";
			
	        if (e != null) { // login successful
	        	//save logged in user (Employee) in session
	        	(request.getSession()).setAttribute("user", e); 
				
	        	// if admin, fetch all employees and save in session
	        	if((e.getRole()).equals("admin")) {
	        		List<Employee> empList = employeeDAO.getAllEmployees();	        		
		        	(request.getSession()).setAttribute("employeeList", empList);
	        	}

	        	//get all clients and save in session
	        	ClientDAO clientDAO = new ClientDAO();
	        	List<Client> clientList = clientDAO.getAllClients();
	        	if(clientList.size() > 0)
	        		(request.getSession()).setAttribute("clientList", clientList);

	        	//get all interventions and save in session       	
	        	InterventionDAO interventionDAO = new InterventionDAO(); 
	        	(request.getSession()).setAttribute("interventionList", interventionDAO.getAllInterventions());        	
	        	
	        	// get all consultations and save in session
	        	ConsultationDAO consultationDAO = new ConsultationDAO();
	        	List<Consultation> consultationList = consultationDAO.getAllConsultations();
	        	if(consultationList.size() > 0)
	        		(request.getSession()).setAttribute("consultationList", consultationDAO.getAllConsultations());	      	
	        	
	        	log.trace("Successful Login by user with Email: "+e.getEmail());
	        	
			} else  { 		// login failed
				request.setAttribute("error", "Invalid Login! Try again!");
				nextPage="login.jsp";
			}
	        
			RequestDispatcher rs = request.getRequestDispatcher(nextPage);
			rs.forward(request, response);			
	       
	    } catch(SQLException e) {
	    	log.trace("SQL Exception in Login Servlet");
	    	throw new RuntimeException(e);
	    }
	}
	
    public void destroy() {
	        log.trace("Login Servlet destroyed");
	}
}