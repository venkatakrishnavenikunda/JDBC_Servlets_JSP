package school.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import school.entity.Students;

public class StudentService {
    private static String url="jdbc:postgresql://localhost:5432/studentmgmt";
    private static String user="postgres";
    private static String pswd="123";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

   
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pswd);
    }

    public int save(Students students) {
        int res = 0;
        String sql = "INSERT INTO student (id, name, age) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, students.getId());
            pstm.setString(2, students.getName());
            pstm.setInt(3, students.getAge());

            res = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<Students> getAll() {
        List<Students> list = new ArrayList<>();
        String sql = "SELECT id, name, age FROM student";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Students s = new Students();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAge(rs.getInt("age"));
                list.add(s);
               // System.out.println("Fetched: " + s.getId() + " " + s.getName() + " " + s.getAge());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

       // System.out.println("Total students fetched = " + list.size());
        return list;
    }
    public int update(Students s) {
        int res = 0;
        String sql = "UPDATE student SET name=?, age=? WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setInt(3, s.getId());
            res = ps.executeUpdate();
            System.out.println("Update executed, rows affected = " + res);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    
    
    public int delete(int id) {
        int res = 0;
        String sql = "DELETE FROM student WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            res = ps.executeUpdate();
            System.out.println("Delete executed, rows affected = " + res);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    
}

