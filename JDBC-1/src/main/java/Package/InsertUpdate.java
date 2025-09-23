package Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertUpdate {
	private static String url="jdbc:postgresql://localhost:5432/School";
	private static String user="postgres";
	private static String password="123";
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("org.postgresql.Driver");
			try 
			{
				Connection connection=DriverManager.getConnection(url,user,password);
				//String sql="INSERT into student values(101,'Krishna',23)";
				//String sql="INSERT into student values(103, 'Chandu',21)";
				String sql="DELETE from student where id=212";
				Statement stm=connection.createStatement();
				stm.execute(sql);
				System.out.println("Data Updated");
				connection.close();
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
