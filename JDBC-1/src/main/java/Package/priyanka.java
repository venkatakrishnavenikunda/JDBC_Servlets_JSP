package Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class priyanka {
	private  static String url="jdbc:postgresql://localhost:5432/School";
	private  static String user="postgres";
	private static  String password="123";
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			try {
				Connection con=DriverManager.getConnection(url,user,password);
				String sql="Insert into student values(199,'priya',12)";
				Statement stmt=con.createStatement();
				stmt.execute(sql);
				System.out.println("Data saved");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
