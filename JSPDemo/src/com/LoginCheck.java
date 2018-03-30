package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sevice.LoginService;

/**
 * Servlet implementation class LoginCheck
 */
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
	    Login ll=new Login();
	    ll.setUser(request.getParameter("user"));
	    ll.setPass(request.getParameter("pass"));
	    RequestDispatcher rd1=request.getRequestDispatcher("Login.jsp");
	    LoginService ls=new LoginService();
	    
	    if(ls.checkUser(ll).equals("success")) {
	    	pw.println("Successfully login!....");
	    	//rd1.include(request, response);
	    	response.sendRedirect("Home.jsp");
	    }else {
	    	pw.println("Failure to login");
	    	rd1.include(request,response);
	    }
	    
	}

}
