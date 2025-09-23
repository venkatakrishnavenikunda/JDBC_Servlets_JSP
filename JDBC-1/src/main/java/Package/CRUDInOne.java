package Package;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDInOne {
 private static String url="jdbc:postgresql://localhost:5432/School?user=postgres&password=123";
 private static Connection con;
 public static  void insert() throws SQLException
 {
	 String sql="INSERT into employee values(?,?,?,?)";
	 PreparedStatement ps=con.prepareStatement(sql);
	 ps.setInt(1, 104);
	 ps.setString(2, "Krishna");
	 ps.setInt(3, 45000);
	 ps.setString(4,"Developer");
	 ps.execute();
	 System.out.println("Inserted done!!!!");
 }
 public static void delete() throws SQLException
 {
	 String sql="DELETE from employee where id=?";
	 PreparedStatement ps= con.prepareStatement(sql);
	 ps.setInt(1, 22);
	 ps.execute();
	 System.out.println("delete done");
	 
 }
 public static void update() throws SQLException
 {
	 String sql="UPDATE employee set des=? where  id=?";
	 PreparedStatement ps=con.prepareStatement(sql);
	 ps.setString(1,"Engineer" );
	 ps.setInt(2, 21);
	 ps.execute();
	 System.out.println("update done");
 }
 public static void fetch() throws SQLException
 {
	 String sql="SELECT * from employee";
	 PreparedStatement ps=con.prepareStatement(sql);
	 ResultSet res=ps.executeQuery();
	 while(res.next())
	 {
		 System.out.println("Employe id:"+res.getInt(1));
		 System.out.println("Employe name:"+res.getString(2));
		 System.out.println("Employe sal:"+res.getInt(3));
		 System.out.println("Employe Designation:"+res.getString(4));
		 System.out.println("==============================");
	 }
 }
	 public static void main(String[] args) {
 
	try {
		Class.forName("org.postgresql.Driver");
		try {
			 con=DriverManager.getConnection(url);
			//insert();
			 //update();
			 //delete();
			 fetch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
}
