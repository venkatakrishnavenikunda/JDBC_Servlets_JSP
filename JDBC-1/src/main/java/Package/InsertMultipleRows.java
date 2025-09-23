package Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.postgresql.Driver;

public class InsertMultipleRows {
	private static String url="jdbc:postgresql://localhost:5432/School?user=postgres&password=123";
	public static void main(String[] args) {
		Driver driver=new Driver();
		try {
			DriverManager.registerDriver(driver);
			System.out.println("Driver Loaded...");
			
			Connection con=DriverManager.getConnection(url);
			System.out.println("Connection established...");
			
 			String sql="INSERT into student values(?,?,?)";
			
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, 212);
			ps.setString(2, "xys");
			ps.setInt(3,23);
			ps.addBatch();
			
			ps.setInt(1, 213);
			ps.setString(2, "absdw");
			ps.setInt(3,13);
			ps.addBatch();
			
			ps.setInt(1, 214);
			ps.setString(2, "efgi");
			ps.setInt(3,3);
			ps.addBatch();
			
			ps.executeBatch();
			
			System.out.println("Rows added...");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
