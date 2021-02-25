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
		System.out.println("Index Servlet GET()");
		RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
		rs.forward(request, response);
	}

    public void destroy() {
	        System.out.println("Index Servlet destroyed");
	}
}