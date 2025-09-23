package Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetch {
	private static String url="jdbc:postgresql://localhost:5432/School";
	private static String user="postgres";
	private static String password="123";
	public static void main(String[] args) {
		try 
		{
			
			Class.forName("org.postgresql.Driver");//1. Load and Register driver
			System.out.println("Driver loaded and registered");
			System.out.println("====================================");
			Connection connection=DriverManager.getConnection(url,user,password); //2.Establishing Connection
			String sql="SELECT * from principal"; //Writing Sql query
			//String sql="SELECT * from principal where age>=22";
			Statement stmt=connection.createStatement();//3. Statement creation 
			
			ResultSet res=stmt.executeQuery(sql);// 4. Execute query
			while(res.next()) 
			{ 
				System.out.println("ID IS:" + res.getInt(1));
				System.out.println("NAME IS:" + res.getString(2));
				System.out.println("AGE IS:" + res.getInt(3));
				System.out.println("SALARY  IS:" + res.getInt(4));
				System.out.println("GENDER IS:" + res.getString(5));
				System.out.println("PHNO IS:" + res.getInt(6));
				System.out.println("ADDRESS IS:" + res.getString(7));
				System.out.println("====================================");
			}
			connection.close();//5. Close connection
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
         e.printStackTrace();
   } 
	}
}


//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class Fetch {
//    private static String url = "jdbc:postgresql://localhost:5432/School";
//    private static String user = "postgres";
//    private static String password = "123";
//
//    public static void main(String[] args) {
//        try {
//            Class.forName("org.postgresql.Driver");
//            System.out.println("Driver loaded");
//
//            Connection connection = DriverManager.getConnection(url, user, password);
//            System.out.println("Connection established");
//
//            String sql = "SELECT * FROM student where age=7";
//            Statement stmt = connection.createStatement();
//            ResultSet res = stmt.executeQuery(sql);
//
//            while (res.next()) 
//            {
//                System.out.println("STUDENT ID IS: " + res.getInt(1));
//                System.out.println("STUDENT NAME IS: " + res.getString(2));
//                System.out.println("STUDENT AGE IS: " + res.getInt(3));
//                System.out.println("-----------");
//            }
//
//            connection.close();
//        } 
//        catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } 
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
