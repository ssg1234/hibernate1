package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionDemo
 */
public class SessionDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionDemo() {
        super();
        // TODO Auto-generated constructor stub
    }
    int count=0;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    PrintWriter pw=response.getWriter();
	    pw.println("<fontsize=4>");
	    HttpSession hs=request.getSession();
	    pw.println("Count value is "+count);
	    pw.println("<br>Session Id is "+hs.getId());
	    if(hs.isNew()) {
	    	pw.println("<br> New Client");
	    } else {
	    	pw.println("<br>Old Client");
	    }
	    pw.println("<br> Session creation time "+new Date(hs.getCreationTime()));
	    pw.println("<br> Session last accessed time "+new Date(hs.getLastAccessedTime()));
	    pw.println("<br> Default time "+new Date(hs.getMaxInactiveInterval()));
	    hs.setMaxInactiveInterval(600);
	    pw.println("<br> Change time "+hs.getMaxInactiveInterval());
	    
	    count++;
	    if(count%5==0) {
	    	hs.invalidate();
	    }
	    pw.println("</font>");
	
	}

}
