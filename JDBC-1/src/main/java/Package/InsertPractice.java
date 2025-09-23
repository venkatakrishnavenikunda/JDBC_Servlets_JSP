package Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertPractice {
	private static String url="jdbc:postgresql://localhost:5432/School";
	private static String user="postgres";
	private static String password="123";
	
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			
			try {
				Connection con=DriverManager.getConnection(url,user,password);
				
				Statement stmt=con.createStatement();
				
				String sql="Insert into student values(346,'kitti',22)";
				
				stmt.execute(sql);
				stmt.execute(sql);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
