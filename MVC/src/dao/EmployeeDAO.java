package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import bean.EmployeeBean;
import controller.Employee;
import dbconnection.DBConnection;


public class EmployeeDAO {
	
   public List<EmployeeBean> getAllEmployees() {
	   List<EmployeeBean> listOfEmp=new ArrayList<>();
	   
	  try {
		  Connection con=DBConnection.getDbConnection();
		  
		  PreparedStatement pst=con.prepareStatement("select * from semp");
		  ResultSet rs=pst.executeQuery();
		  while(rs.next()) {
			  EmployeeBean emp=new EmployeeBean();
			  emp.setId(rs.getInt(1));
			  emp.setName(rs.getString(2));
			  emp.setSalary(rs.getFloat(3));
			  emp.setDesg(rs.getString(4));
			  listOfEmp.add(emp);
		  }
		  
	  } catch(Exception e) {
		  System.out.println(e);
	  }
	  return listOfEmp;
   }
   
   public int insertEmployee(EmployeeBean emp) {
	   try {
		   Connection con=DBConnection.getDbConnection();
		   PreparedStatement pstmt=con.prepareStatement("insert into semp values(?,?,?,?)");
		   pstmt.setInt(1,emp.getId());
		   pstmt.setString(2, emp.getName());
		   pstmt.setFloat(3, emp.getSalary());
		   pstmt.setString(4, emp.getDesg());
		   int temp=pstmt.executeUpdate();
		   if(temp>0) 
			   //System.out.println("Record inserted successfully");
			   return 1;
	   }catch(Exception e) {
		   System.out.println(e);
	   }
	  return 0;
	  
   }
}
