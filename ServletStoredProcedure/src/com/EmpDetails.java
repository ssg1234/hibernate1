package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpDetails
 */
@WebServlet("/EmpDetails")
public class EmpDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	PrintWriter pw=response.getWriter();
	int empid=Integer.parseInt(request.getParameter("empid"));
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@172.25.163.114:1521/hyper2","system","Password123");
		/*CallableStatement cstmt=con.prepareCall("{call sempproc(?,?,?)}");
		cstmt.setInt(1,empid);
		cstmt.registerOutParameter(2, Types.VARCHAR);
		cstmt.registerOutParameter(3, Types.NUMERIC);
	    cstmt.executeUpdate();
	    
	    String name=cstmt.getString(2);
	    pw.println("Name is"+name);
	    int salary=cstmt.getInt(3);
	    pw.println("Salary is"+salary);*/
		CallableStatement cstmt=con.prepareCall("{?=call empfun(?)}");
		cstmt.setInt(2, empid);
		cstmt.registerOutParameter(1, Types.VARCHAR);
		cstmt.executeUpdate();
		String msg=cstmt.getString(1);
		pw.println(msg);
	}catch(Exception e) {
		System.out.println(e);
	}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
