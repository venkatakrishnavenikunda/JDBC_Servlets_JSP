package mgmtSchoolService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mgmtSchool.School;

public class SchoolService {
	private static Scanner sc=new Scanner(System.in);
	private static String url="jdbc:postgresql://localhost:5432/SchoolMgmt";
	private static String user="postgres";
	private static String password="123";
	private static Connection con;
	
	public SchoolService() 
	{
		System.out.println("Object created...");
	}
	
	static 
	{
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded and registerd..");
			try {
				con=DriverManager.getConnection(url,user,password);
				System.out.println("Connection established..");
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//Inserting 
	public int save(School school) 
	{
		int res=0;
		String sql="INSERT into school values(?,?,?)";
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1,school.getId());
			ps.setString(2, school.getName());
			ps.setString(3, school.getAddresss());
			
			res=ps.executeUpdate();
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	//Exit
	public void exit() 
	{
		try {
			con.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Update
	public int update(String name, int id) 
	{
		int res=0;
		String sql="UPDATE school set name=? where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, id);
			
			res=ps.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	//Delete
	public int delete(int id) 
	{
		int res=0;
		String sql="DELETE from school where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,id);
			res=ps.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	//Fetch
	public List<School> fetch() 
	{
		List<School> l=new ArrayList<School>();
		String sql="SELECT * from school";
		try {
			Statement st=con.createStatement();
			ResultSet res=st.executeQuery(sql);
			while(res.next()) 
			{
				int id=res.getInt(1);
				String name=res.getString(2);
				String address=res.getString(3);
				
//				School school = new School(id,name, address);
//				l.add(school);
				l.add(new School(id,name, address));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
}
