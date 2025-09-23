package Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertWithFinally {
	private static String url="jdbc:postgresql://localhost:5432/School?user=postgres&password=123";
	private static Connection con;
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded and registerd");
			try {
				con=DriverManager.getConnection(url);
				System.out.println("Connection established");
				Statement st=con.createStatement();
				String sql="INSERT into student values(345,'lucky',7)";
				st.execute(sql);
				System.out.println("Data inserted.");
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				con.close();
			}
			catch(SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
