package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Login;

import resource.DBConnection;

public class LoginDao {
	public boolean checkUser(Login ll) {
		try {
			//Connection con=DBConnection.getDbConnection();
			PreparedStatement pstmt=DBConnection.getDbConnection().prepareStatement("select * from slogin where uname like ? and pwd like ?");
			pstmt.setString(1, ll.getUser());
			pstmt.setString(2, ll.getPass());
			ResultSet rs=pstmt.executeQuery();
	        if(rs.next()) {
	        	return true;
	        }
		}catch(Exception e) {
			System.out.println(e);
			
	}
		return false;
 }
}


