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

// GetEmployee to Update or Delete
public class GetEmployeeServlet extends HttpServlet { 
	private static Logger log = LogManager.getLogger(GetEmployeeServlet.class);
	public void init(ServletConfig config) {
		log.trace("GetEmployee Servlet initialized");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		log.trace("GetEmployee Servlet POST()");
	    Integer empId = Integer.valueOf(request.getParameter("employeeToEdit"));
	    List<Employee> list = (List<Employee>) (request.getSession()).getAttribute("employeeList");	    	
	    for(Employee e : list) {
	    	if(e.getEmpId() == empId) { //found match
	    		(request.getSession()).setAttribute("selectedEmployee", e);
	    		break;
	    	}
	    }    
	    log.trace("Getting the Employee to Update/Delete");
	    RequestDispatcher rs = request.getRequestDispatcher("editEmployee.jsp");
		rs.forward(request, response);
	}
	
    public void destroy() {
    	log.trace("GetEmployee Servlet destroyed");
	}
}