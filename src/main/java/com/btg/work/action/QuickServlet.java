package com.btg.work.action;

import javax.servlet.*;
import javax.servlet.http.*;

import com.btg.work.model.Client;
import com.btg.work.model.ClientDAOImpl;
import com.btg.work.model.Consultation;
import com.btg.work.model.ConsultationDAOImpl;
import com.btg.work.model.Employee;
import com.btg.work.model.EmployeeDAOImpl;
import com.btg.work.model.Intervention;
import com.btg.work.model.InterventionDAOImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;

public class QuickServlet extends HttpServlet {
 
    /**
     * this life-cycle method is invoked when this servlet is first accessed
     * by the client
     */
    public void init(ServletConfig config) {
        System.out.println("Quick Servlet initialized");
    }
 
    /**
     * handles HTTP GET request
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
    	/*
        PrintWriter writer = response.getWriter();
        writer.println("<html>Hello, I am a Java servlet!</html>");
        writer.flush(); */
    	response.sendRedirect("jsp/home.jsp");
    }
 
    /**
     * handles HTTP POST request
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String paramWidth = request.getParameter("width");
        int width = Integer.parseInt(paramWidth);
 
        String paramHeight = request.getParameter("height");
        int height = Integer.parseInt(paramHeight);
 
        long area = width * height;
 
        PrintWriter writer = response.getWriter();
        writer.println("<html>Area of the rectangle is: " + area + "</html>");
        
        try  {
			//
        	EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        	List<Employee> employeeList = employeeDAO.getAllEmployees();
			writer.println("<html><br/><br/> Just before Employees for loop </html>");
			for(Employee e : employeeList) {				
				writer.println("<br /><html>Employee Name: " + e.getName() + "</html>");
			}
			//
			ClientDAOImpl clientDAO = new ClientDAOImpl();
			List<Client> clientList = clientDAO.getAllClients();
			writer.println("<html><br/><br/> Just before Clients for loop </html>");
			for(Client c : clientList) {								
				writer.println("<br /><html>Client Name: " + c.getClientName() + "</html>");
			}
			//	
			InterventionDAOImpl interventionDAO = new InterventionDAOImpl();
			List<Intervention> interventionList = interventionDAO.getAllInterventions();
			writer.println("<html><br/><br/> Just before Intervs for loop </html>");
			for(Intervention i : interventionList) {								
				writer.println("<br /><html>Intervention Option: " + i.getOption() + "</html>");
			}		
			
			//	
			ConsultationDAOImpl consultationDAO = new ConsultationDAOImpl();
			List<Consultation> consultationList = consultationDAO.getAllConsultations();
			writer.println("<html><br/><br/> Just before Consults for loop </html>");
			for(Consultation c : consultationList) {								
				writer.println("<br /><html>Consultation ID : " + c.getConsultationId() + "</html>");
			}			
			//			
			writer.flush();
        } catch(SQLException e) {
        	throw new RuntimeException(e);
        }
    }
 
    /**
     * this life-cycle method is invoked when the application or the server
     * is shutting down
     */
    public void destroy() {
        System.out.println("Servlet is being destroyed");
    }
}
