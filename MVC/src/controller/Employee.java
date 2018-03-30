package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmployeeBean;
import service.EmployeeService;

/**
 * Servlet implementation class Employee
 */
public class Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }
    ServletContext sc;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//super.init(config);
		sc = config.getServletContext();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	   EmployeeService es=new EmployeeService();
	  List<EmployeeBean> li= es.getEmployees();
	  sc.setAttribute("obj",li);
	  response.sendRedirect("display.jsp");
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		EmployeeService es=new EmployeeService();
		 RequestDispatcher rd1=request.getRequestDispatcher("display.jsp");
		EmployeeBean eb=new EmployeeBean();
		eb.setId(Integer.parseInt(request.getParameter("id")));
		eb.setName(request.getParameter("name"));
		eb.setSalary(Float.parseFloat(request.getParameter("salary")));
		eb.setDesg(request.getParameter("desg"));
		if(es.insertRecord(eb)>0) {
			pw.println("inserted");
	      rd1.include(request, response);
		}
		else {
			pw.println("not inserted");
		}
	}
	

	

}
