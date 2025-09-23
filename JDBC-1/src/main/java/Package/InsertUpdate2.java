package Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertUpdate2 {
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
				//String sql="INSERT into principal values(101,'Krishna',21,45000,'Female',939845656,'Banglore')";
				String sql="UPDATE principal set age=22,salary=50000 where id=101";
				Statement stm=connection.createStatement();
				stm.execute(sql);
				System.out.println("Data saved");
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
