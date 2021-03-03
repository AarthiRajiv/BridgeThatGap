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

public class GetEmployeeServlet extends HttpServlet {	 
	public void init(ServletConfig config) {
		System.out.println("GetEmployee Servlet initialized");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    System.out.println("GetEmployee Servlet POST()");
	    Integer empId = Integer.valueOf(request.getParameter("employeeToEdit"));
	    List<Employee> list = (List<Employee>) (request.getSession()).getAttribute("employeeList");	    	
	    for(Employee e : list) {
	    	if(e.getEmpId() == empId) { //found match
	    		(request.getSession()).setAttribute("selectedEmployee", e);
	    		break;
	    	}
	    }    

	    RequestDispatcher rs = request.getRequestDispatcher("editEmployee.jsp");
		rs.forward(request, response);
	}
	
    public void destroy() {
	        System.out.println("GetEmployee Servlet destroyed");
	}
}