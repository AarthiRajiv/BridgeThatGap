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

public class DeleteEmployeeServlet extends HttpServlet {	 
	private static Logger log = LogManager.getLogger(DeleteEmployeeServlet.class);
	
	public void init(ServletConfig config) {
		log.trace("DeleteEmployee Servlet initialized");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		log.trace("DeleteEmployee Servlet POST()");
	    
	    try {
	    
		    EmployeeDAO employeeDAO = new EmployeeDAO();	        
	                
	        Employee e = (Employee) (request.getSession()).getAttribute("selectedEmployee");
	        List<Employee> list = employeeDAO.deleteEmployee(e);
	        (request.getSession()).setAttribute("employeeList", list);
	        
	        log.trace("Deleted Employee" );
			RequestDispatcher rs = request.getRequestDispatcher("employees.jsp");
			rs.forward(request, response);
	    } catch(SQLException e) {
	    	throw new RuntimeException(e);
	    }
	}
	
    public void destroy() {
    	log.trace("Delete Employee Servlet destroyed");
	}
}