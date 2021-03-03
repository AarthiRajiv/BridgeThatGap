package com.btg.work.action;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.log4j.*;

public class LogoutServlet extends HttpServlet {
	private static Logger log = LogManager.getLogger(LogoutServlet.class);
	
	public void init(ServletConfig config) {		
		log.trace("Logout Servlet initialized");	
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {		
		log.trace("Logout Servlet GET()");
		
		HttpSession session = request.getSession(false);
        session.removeAttribute("user");
        session.invalidate();
        log.trace("Logout Servlet. Session Invalidated.");
        
		RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
		rs.forward(request, response);		
	}

    public void destroy() {
    	log.trace("Logout Servlet destroyed");
	}
}
