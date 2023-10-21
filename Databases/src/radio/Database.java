package radio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private Connection connection;
    public Connection getConnection() {

        if (connection == null) {
            return createConnection();
        }
        return connection;

    }

    private Connection createConnection() {

        String url = "jdbc:postgresql://localhost/playlist?user=postgres&password=admin";

        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

}
