package mgmtSchoolDriver;

import java.util.List;
import java.util.Scanner;

import mgmtSchool.School;
import mgmtSchoolService.SchoolService;

public class SchoolDriver {
	public static void main(String[] args) {
		SchoolService scService=new SchoolService();
		System.out.println("Welcome to Techno School..");
		boolean flag=true;
		while(flag) 
		{
			System.out.println("Press 1 to insert School details");
			System.out.println("Press 2 to Update School details");
			System.out.println("Press 3 to View School details");
			System.out.println("Press 4 to Delete School details");
			System.out.println("Press 5 to exit the application..");
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter your choice...");
			
			int choice=sc.nextInt();
			
			switch(choice) 
			{
			case 1:
				//save school data
				System.out.println("Enter School id:");
				int id=sc.nextInt();
				System.out.println("Enter School name:");
				String name=sc.next();
				System.out.println("Enter School address:");
				String address=sc.next();
				
				School school=new School(id,name,address);
				school.setId(id);
				school.setName(name);
				school.setAddress(address);
				
				int res=scService.save(school);
				if(res!=0)
					System.out.println("Data inserted...");
				else
					System.out.println("Data not inserted...");
				break;
			case 2:
				//Update school data
				System.out.println("Enter the name to update:");
				String upname=sc.next();
				System.out.println("Enter id to update:");
				int upid=sc.nextInt();
				int res1=scService.update(upname, upid);
				if(res1!=0)
					System.out.println("Data updated..");
				else
					System.out.println("Data not updated..");
				break;
			case 3:
				//Fetch school data
				List<School> l=scService.fetch();
				if(l!=null) 
				{
					for(School school2:l) 
					{
						System.out.println(school2);
					}
				}
				else
					System.out.println("No data found..");
				break;
			case 4:
				//Delete school data
				System.out.println("Enter the id to delete");
				int did=sc.nextInt();
				int res2=scService.delete(did);
				if(res2!=0)
					System.out.println("Data got deleted..");
				else
					System.out.println("Data not deleted...");
				break;
			case 5:
				//Exit the application
				scService.exit();
				flag=false;
				break;
			default:
				System.out.println("Invalid Input...");
				break;
			
			}
		}
		
	}
}
