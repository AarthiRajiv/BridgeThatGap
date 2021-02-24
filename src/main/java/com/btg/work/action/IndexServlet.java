package com.btg.work.action;
import javax.servlet.*;
import javax.servlet.http.*;

import com.btg.work.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;

public class IndexServlet extends HttpServlet {	 
	public void init(ServletConfig config) {
		System.out.println("Index Servlet initialized");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    try  {
	    	System.out.println("Index Servlet GET()");
	        /*EmployeeDAO employeeDAO = new EmployeeDAO();
	        List<Employee> employeeList = employeeDAO.getAllEmployees();			
			
	        (request.getSession()).setAttribute("SessionAttributeTest", "It works?!!");	
			(request.getSession()).setAttribute("Employees", employeeList);	
			*/
			RequestDispatcher rs = request.getRequestDispatcher("home.jsp");
			rs.forward(request, response);			
	       
	    } catch(SQLException e) {
	    	   throw new RuntimeException(e);
	    }

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {		

	    }
	 
	    public void destroy() {
	        System.out.println("Index Servlet destroyed");
	    }
	}
