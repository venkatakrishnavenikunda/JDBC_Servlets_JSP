package Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EstablishConnection {
	private static String url="jdbc:postgresql://localhost:5432/School?user=postgres&password=123";
	
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded....");
			
			try {
				Connection con=DriverManager.getConnection(url);
				System.out.println("Coonection established...");
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
