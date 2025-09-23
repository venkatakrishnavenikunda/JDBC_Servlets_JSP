package Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DynamicFetch {
	private static String url="jdbc:postgresql://localhost:5432/School";
	private static String user="postgres";
	private static String password="123";
	
	public static void main(String[] args) {
			try {
				Class.forName("org.postgresql.Driver");
				System.out.println("Driver loaded and registered");
				
				try {
					Connection con=DriverManager.getConnection(url, user, password);
					String sql="SELECT * from student where  name=?";
					
					PreparedStatement prepareStatement=con.prepareStatement(sql);
					prepareStatement.setString(1,"Krishna");
					ResultSet res=prepareStatement.executeQuery();
					
					while(res.next()) 
					{
						System.out.println("---------------------");
						System.out.println("ID:"+res.getInt(1));
						System.out.println("Name:"+res.getString(2));
						System.out.println("Age:"+res.getInt(3));
						System.out.println("---------------------");
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