package java_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private Connection connection;

    public Connection createConnection() {
        String url = "jdbc:postgresql://localhost/imdb?user=postgres&password=admin";
        try {
            connection = DriverManager.getConnection(url);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public Connection getConnection() {
        if (connection == null) {
            return createConnection();
        } else {
            return getConnection();
        }

    }

}
