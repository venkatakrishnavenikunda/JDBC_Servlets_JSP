package Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.postgresql.Driver;

public class DynamicQueryUpdate {
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
			//String sql="INSERT into principal values(?,?,?,?,?,?,?)";
			//String sql="UPDATE principal set Phno=? where id=?";
			String sql="DELETE from principal where id=?";
			//String sql = "UPDATE principal SET \"Phno\" = ? WHERE id = ?";

			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,106);
			//prepareStatement.setString(1,"USA");
			//prepareStatement.setInt(2,105);
		
			
			
			ps.execute();

			System.out.println("Data inserted dynamically...");
		} 
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
