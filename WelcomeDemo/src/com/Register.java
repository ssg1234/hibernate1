package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
    String query;
    String driverName;
    public void init(ServletConfig conf) throws ServletException{
    	query=conf.getInitParameter("qry");
    	ServletContext sc=conf.getServletContext();
    	driverName=sc.getInitParameter("driver");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw=response.getWriter();
		pw.println("Register");
		response.setContentType("text/html");
		String name=request.getParameter("user");
		String pwd=request.getParameter("pass");
		RequestDispatcher rd1=request.getRequestDispatcher("Login.html");
		RequestDispatcher rd2=request.getRequestDispatcher("register.html");
		try {
			Class.forName(driverName);
			System.out.println("Driver loaded successfully");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@172.25.163.114:1521/hyper2","system","Password123");
			System.out.println("Connection establised successfully");
			//Statement st = con.createStatement();
			PreparedStatement pstmt=con.prepareStatement(query);
			System.out.println("Statement created");
			pstmt.setString(1,name);
			pstmt.setString(2,pwd);
			int temp=pstmt.executeUpdate();
			if(temp>0) {
				pw.println("Registered successfully");
				rd1.include(request, response);
			}
			else {
				pw.println("Failed to register");
				rd2.include(request, response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
