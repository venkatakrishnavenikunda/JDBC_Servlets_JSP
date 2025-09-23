package Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteMulRows {
	private static String url="jdbc:postgresql://localhost:5432/School?user=postgres&password=123";
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			try {
				Connection con=DriverManager.getConnection(url);
				String sql="DELETE from student where id=?";
				
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, 107);
				ps.addBatch();
				
				ps.setInt(1, 212);
				ps.addBatch();
				
				ps.setInt(1, 214);
				ps.addBatch();
				ps.executeBatch();
				
				System.out.println("Rows Deleted...");
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
