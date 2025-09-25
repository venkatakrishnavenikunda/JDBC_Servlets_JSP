package school.service;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteDetails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        StudentService service = new StudentService();
        int result = service.delete(id);

        if (result > 0) {
            res.sendRedirect("display"); // reload student list
        } else {
            res.getWriter().println("Delete failed!");
        }
    }
}
