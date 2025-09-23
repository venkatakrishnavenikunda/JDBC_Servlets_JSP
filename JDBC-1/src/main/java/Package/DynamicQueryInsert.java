package Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.postgresql.Driver;

public class DynamicQueryInsert {
	private static String url="jdbc:postgresql://localhost:5432/School";
	private static String user="postgres";
	private static String password="123";
	
	public static void main(String[] args) {
		Driver driver=new Driver();
		try {
			//Class.forName("org.postgresql.Driver");
			DriverManager.registerDriver(driver);
			System.out.println("Driver loaded and registered..");
			Connection con=DriverManager.getConnection(url,user,password);
			String sql="INSERT into student values(?,?,?)";
			PreparedStatement prepareStatement=con.prepareStatement(sql);
			prepareStatement.setInt(1,100);
			prepareStatement.setString(2,"Ram");
			prepareStatement.setInt(3,25);
			
			prepareStatement.execute();

			System.out.println("Data inserted dynamically...");
		} 
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
