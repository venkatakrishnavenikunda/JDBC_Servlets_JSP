package Package;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchException {

    private static final String URL = "jdbc:postgresql://localhost:5432/School";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123";

    public static void main(String[] args) {

        try {
            // Step 1: Load and register driver
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded and registered");

            // Step 2: Establish connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Create SQL statement
            String sql = "INSERT into student VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Step 4: Set values and add to batch
            preparedStatement.setInt(1, 208);
            preparedStatement.setString(2, "kiran");
            preparedStatement.setInt(3, 25);
            preparedStatement.addBatch();

            preparedStatement.setInt(1, 210);
            preparedStatement.setString(2, "mani");
            preparedStatement.setInt(3, 27);
            preparedStatement.addBatch();

            preparedStatement.setInt(1, 212);
            preparedStatement.setString(2, "sai");
            preparedStatement.setInt(3, 26);
            preparedStatement.addBatch();

            // Step 5: Execute batch
            preparedStatement.executeBatch();
            //System.out.println("Batch executed. Rows affected: " + results.length);

            // Step 6: Close connection
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
