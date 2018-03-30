package com;
import java.sql.*;
import java.util.Scanner;
public class DemoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded successfully");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@172.25.163.114:1521/hyper2","system","Password123");
			con.setAutoCommit(false);
			System.out.println("Connection establised successfully");
			//Statement st = con.createStatement();
			PreparedStatement pstmt=con.prepareStatement("insert into semployee values(?,?,?)");
			System.out.println("Statement created");
			/* 
			ResultSet rs=st.executeQuery("select * from semployee");
			while(rs.next()) { 
			System.out.println("ID is "+rs.getInt(1));
			System.out.println("Name is "+rs.getString("name"));
			System.out.println("Salary is "+rs.getFloat(3));
			}*/
			//DML OPERATION
			/*Scanner sc = new Scanner(System.in);
			System.out.println("Enter id of an employee");
			int id1= sc.nextInt();
			pstmt.setInt(1, id1);
			System.out.println("Enter name of an employee");
			String name1 = sc.next();
			pstmt.setString(2, name1);
			System.out.println("Enter salary of an employee");
			float sal =sc.nextFloat();
			pstmt.setFloat(3, sal);*/
			pstmt.setInt(1, 9);
			pstmt.setString(2, "gg");
			pstmt.setFloat(3, 19000);
			
			//int temp=st.executeUpdate("insert into semployee values("+id1+",'"+name1+"',"+sal+")");
			//int temp=st.executeUpdate("delete from semployee where id=4");
			int temp=pstmt.executeUpdate();
			
			
			if(temp>0) {
				System.out.println("Record inserted successfully");
			}
			else {
				System.out.println("Record not inserted");
			}
			con.commit();
			//rs.close();
			pstmt.close();
			con.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
