package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class Demo
 */
public class Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demo() {
        super();
        // TODO Auto-generated constructor stub
    }
    String user;
    ServletContext sc;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//super.init(config);
	 sc = config.getServletContext();
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
	    user=request.getParameter("user");
		pw.println("Username in Demo Servlet="+user);
		//request.setAttribute("obj",user);
		HttpSession hs=request.getSession();
        //hs.setAttribute("obj", user);
		sc.setAttribute("obj", user);
        hs.invalidate();
		//RequestDispatcher rd1=request.getRequestDispatcher("Home.jsp");
		//rd1.forward(request, response);
		//rd1.include(request,response);
		response.sendRedirect("Home.jsp");
		
	}

}
