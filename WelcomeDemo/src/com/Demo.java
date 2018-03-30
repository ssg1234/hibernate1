package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		RequestDispatcher rd1=request.getRequestDispatcher("Home");
		RequestDispatcher rd2=request.getRequestDispatcher("Login.html");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded successfully");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@172.25.163.114:1521/hyper2","system","Password123");
			System.out.println("Connection establised successfully");
			//Statement st = con.createStatement();
			PreparedStatement pstmt=con.prepareStatement("select * from slogin where uname like ? and pwd like ?");
			System.out.println("Statement created");
			pstmt.setString(1,name);
			pstmt.setString(2,pwd);
			int temp=pstmt.executeUpdate();
			if(temp>0) {
				pw.println("successfully login");
				rd1.include(request, response);
			}
			else {
				pw.println("Failed to login");
				rd1.include(request, response);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
	
	
