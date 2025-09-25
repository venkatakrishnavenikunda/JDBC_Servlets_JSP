package school.studentController;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import school.entity.Students;
import school.service.StudentService;

@WebServlet("/register")
public class RegisterStudent extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Inside RegisterStudent Servlet");
		int id=Integer.parseInt(req.getParameter("id"));
		int age= Integer.parseInt(req.getParameter("age"));
		String name= req.getParameter("name");
		
		System.out.println(id+ " "+name+" "+ age);
		
		Students students =new Students();
		students.setId(id);
		students.setName(name);
		students.setAge(age);
		
		StudentService service = new StudentService();
		
		int save=service.save(students);
		if(save!=0) 
		{
			System.out.println("Data saved successfully!!!");
			RequestDispatcher dispatcher= req.getRequestDispatcher("register.jsp");
			dispatcher.forward(req, res);
		}
	}
}

