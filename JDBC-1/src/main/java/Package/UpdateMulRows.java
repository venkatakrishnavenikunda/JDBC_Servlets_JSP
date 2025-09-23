package Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateMulRows {
	private static String url="jdbc:postgresql://localhost:5432/School?user=postgres&password=123";
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded..");
			
			try {
				Connection con=DriverManager.getConnection(url);
				System.out.println("Connection established..");
				
				String sql="UPDATE student set age=? where id=?";
				
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, 43);
				ps.setInt(2, 100);
				ps.addBatch();
				
				ps.setInt(1, 42);
				ps.setInt(2, 101);
				ps.addBatch();
				
				ps.executeBatch();
				
				System.out.println("Table updated..");
				
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
