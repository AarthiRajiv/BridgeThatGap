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

public class DeleteEmployeeServlet extends HttpServlet {	 
	public void init(ServletConfig config) {
		System.out.println("DeleteEmployee Servlet initialized");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    System.out.println("DeleteEmployee Servlet POST()");
	    
	    try {
	    
		    EmployeeDAO employeeDAO = new EmployeeDAO();	        
	                
	        Employee e = (Employee) (request.getSession()).getAttribute("selectedEmployee");
	        List<Employee> list = employeeDAO.deleteEmployee(e);
	        (request.getSession()).setAttribute("employeeList", list);
	        
			RequestDispatcher rs = request.getRequestDispatcher("employees.jsp");
			rs.forward(request, response);
	    } catch(SQLException e) {
	    	throw new RuntimeException(e);
	    }
	}
	
    public void destroy() {
	        System.out.println("GetEmployee Servlet destroyed");
	}
}