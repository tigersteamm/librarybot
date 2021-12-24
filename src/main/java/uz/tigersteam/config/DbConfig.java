package uz.tigersteam.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

/**
 * @author Nodirbek Abdukarimov Fri. 9:56 AM. 12/24/2021
 */
public class DbConfig {
    private static Connection connection;

    public static Connection conn() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(PConfig.get("db.connection"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close() {
        try {
            if (Objects.nonNull(connection) && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
