package school.service;


import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import school.entity.Students;
import school.service.StudentService;

@WebServlet("/display")
public class DisplayAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        StudentService service = new StudentService();
        List<Students> allStudents = service.getAll();

        req.setAttribute("students", allStudents);

        RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
        dispatcher.forward(req, res);
    }
}
