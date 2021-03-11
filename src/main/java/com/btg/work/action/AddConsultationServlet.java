package com.btg.work.action;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.log4j.*;
import com.btg.work.model.*;

public class AddConsultationServlet extends HttpServlet {	 
	private static Logger log = LogManager.getLogger(AddConsultationServlet.class);
	
	public void init(ServletConfig config) {
		log.trace("AddConsultation Servlet initialized");
	}
			
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		log.trace("AddConsultation Servlet POST()");		    
		try {       
			Consultation newConsultation = new Consultation();
			newConsultation.setClient(new Client(Integer.valueOf(request.getParameter("fClient"))));
			newConsultation.setIntervention(new Intervention(Integer.valueOf(request.getParameter("fIntervention"))));
			newConsultation.setEmployee(new Employee(Integer.valueOf(request.getParameter("fEmployee"))));			
			
			newConsultation.setGoal(request.getParameter("fGoal"));			
			newConsultation.setStartDate(Date.valueOf(request.getParameter("fStartDate")));
			newConsultation.setStatus(request.getParameter("fStatus"));		        
			
			ConsultationDAO consultationDAO = new ConsultationDAO();
			List<Consultation> list = consultationDAO.addConsultation(newConsultation);
			(request.getSession()).setAttribute("consultationList", list);
			        
			log.trace("New Consultation added ");
			RequestDispatcher rs = request.getRequestDispatcher("consultations.jsp");
			rs.forward(request, response);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
			
	public void destroy() {
		log.trace("AddConsultation Servlet destroyed");
	}
}