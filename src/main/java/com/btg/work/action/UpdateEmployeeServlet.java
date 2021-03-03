package com.btg.work.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import com.btg.work.model.*;

public class UpdateEmployeeServlet extends HttpServlet {	 
	public void init(ServletConfig config) {
		System.out.println("UpdateEmployee Servlet initialized");
	}
		
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    System.out.println("UpdateEmployee Servlet POST()");		    
	    try {       
	        Employee oldEmployee = (Employee) (request.getSession()).getAttribute("selectedEmployee");		        
	        Employee newEmployee = new Employee(oldEmployee.getEmpId());
	        newEmployee.setName(request.getParameter("fName"));
	        newEmployee.setRole(request.getParameter("fRole"));
	        newEmployee.setSpecialization(request.getParameter("fSpecialization"));
	        newEmployee.setEmail(request.getParameter("fEmail"));		        
	        
	        EmployeeDAO employeeDAO = new EmployeeDAO();
	        List<Employee> list = employeeDAO.updateEmployee(newEmployee);
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