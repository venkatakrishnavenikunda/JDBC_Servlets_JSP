package Package;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteMethods {
	private static String url="jdbc:postgresql://localhost:5432/School?user=postgres&password=123";
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded and registerd..");
			
			try {
				Connection con= DriverManager.getConnection(url);
				System.out.println("Connection establishes");
				
				String sql="INSERT into employee values(22,'Chandu',45000,'Designer')";
				//String sql="INSERT into student values()";
				Statement st=con.createStatement();
				
				st.execute(sql);
				System.out.println("Values inserted..");
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
