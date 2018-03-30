package resource;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection con;
	public static Connection getDbConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@172.25.163.114:1521/hyper2","system","Password123");
		}catch(Exception e) {
			
		}
		return con;
	}

}
