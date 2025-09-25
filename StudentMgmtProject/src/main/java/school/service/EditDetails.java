package school.service;


import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import school.entity.Students;

@WebServlet("/edit")
public class EditDetails extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));

        Students s = new Students(id, name, age);
        StudentService service = new StudentService();
        int result = service.update(s);

        if (result > 0) {
            res.sendRedirect("display"); 
        } else {
            res.getWriter().println("Update failed!");
        }
    }
}
