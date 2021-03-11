package com.btg.work.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.btg.work.model.*;

public class AddEmployeeServlet extends HttpServlet {	 
	private static Logger log = LogManager.getLogger(AddEmployeeServlet.class);
	
	public void init(ServletConfig config) {
		log.trace("AddEmployee Servlet initialized");
	}
			
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		log.trace("AddEmployee Servlet POST()");		    
		try {       
			Employee newEmployee = new Employee();
			newEmployee.setName(request.getParameter("fName"));
			newEmployee.setRole(request.getParameter("fRole"));
			newEmployee.setSpecialization(request.getParameter("fSpecialization"));
			newEmployee.setEmail(request.getParameter("fEmail"));		        
			        
			EmployeeDAO employeeDAO = new EmployeeDAO();
			List<Employee> list = employeeDAO.addEmployee(newEmployee);
			(request.getSession()).setAttribute("employeeList", list);
			        
			log.trace("New Employee added ");
			RequestDispatcher rs = request.getRequestDispatcher("employees.jsp");
			rs.forward(request, response);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
			
	public void destroy() {
		log.trace("AddEmployee Servlet destroyed");
	}
}