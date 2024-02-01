package HW12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBSHelper {

    private static final String GET_USERS_SQL = "SELECT * FROM users";
    private static final String INSERT_USER_SQL =
            "INSERT INTO users (name, email, age)" +
                    "VALUES (?, ?, ?)";

    public static Connection jdbcConnection() {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5434/testdb",
                    "full",
                    "dtrm65");

            if (connection != null) {
                System.out.println("Connected to database");
                return connection;
            } else {
                System.out.println("Connection to database failed");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
