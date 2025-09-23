package Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DriverLoad {
////	private static String url = "jdbc:postgresql://localhost:5432/School";
////	private static String user = "postgres";
////	private static String password = "123";
//
//	public static void main(String[] args) {
//		String url = "jdbc:postgresql://localhost:5432/School";
//		String user = "postgres";
//		String password = "123";
//		try 
//		{
//			Class.forName("org.postgresql.Driver");
//			System.out.println("Driver Loaded...");
//		try 
//		{
//			Connection connection = DriverManager.getConnection(url, user, password);
//			System.out.println("Connection established..");
//		} 
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//		catch (ClassNotFoundException e) {
//			
//			e.printStackTrace();
//		}
//	}
//}


public class DriverLoad
{
	private static String url="jdbc:postgresql://localhost:5432/School4";
	private static String user="postgres";
	private static String password="123";
	
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Loaded");
			try {
				Connection con=DriverManager.getConnection(url, user, password);
				System.out.println("Establishing Connection");
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
