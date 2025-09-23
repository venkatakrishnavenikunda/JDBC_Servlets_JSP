package Package;

import java.sql.Connection;
//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.postgresql.Driver;

public class DynamicUpdate {
	private static String url="jdbc:postgresql://localhost:5432/School";
	private static String user="postgres";
	private static String password="123";
	
	public static void main(String[] args) {
		try {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("Driver loaded and registered..");
			Connection con=DriverManager.getConnection(url,user,password);
		
			String sql="UPDATE student set name=? where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,"Seetha");
			ps.setInt(2, 107);
			
			
			ps.execute();

			System.out.println("Data inserted dynamically...");
		} 
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
