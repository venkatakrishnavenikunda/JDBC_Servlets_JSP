package Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetch2 {
	private static String url="jdbc:postgresql://localhost:5432/School?user=postgres&password=123";
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Loaded and registered");
			
			try {
				Connection con=DriverManager.getConnection(url);
				
				String sq1="select * from student";
				
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery(sq1);
				
				while(res.next()) 
				{
					System.out.println("Id:"+res.getInt(1));
					System.out.println("Name:"+res.getString(2));
					System.out.println("Age:"+res.getInt(3));
					System.out.println("--------------");
				}
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
