package Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertWithTryResource {
	private static String url="jdbc:postgresql://localhost:5432/School?user=postgres&password=123";
	public static void main(String[] args) {
		try(Connection con=DriverManager.getConnection(url))
		{
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Loaded and registerd.");
			String sql="INSERT into student values(344,'Vihan',2)";
			Statement st=con.createStatement();
			st.execute(sql);
			System.out.println("Data Inserted.");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
