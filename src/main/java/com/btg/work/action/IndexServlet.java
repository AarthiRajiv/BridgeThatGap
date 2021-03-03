package com.btg.work.action;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.log4j.*;

import com.btg.work.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;

public class IndexServlet extends HttpServlet {	
	private static Logger log = LogManager.getLogger(IndexServlet.class);
	
	public void init(ServletConfig config) {		
		log.trace("Index Servlet initialized");	
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {		
		log.trace("Index Servlet GET()");
		RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
		rs.forward(request, response);
	}

    public void destroy() {
    	log.trace("Index Servlet destroyed");
	}
}