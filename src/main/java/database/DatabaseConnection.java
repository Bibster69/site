package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private java.sql.Connection connection;


    public Connection getConnection() {
        return this.connection;
    }

    public void connect(String dbPath) throws SQLException {
        try {
            String url = "jdbc:sqlite:" + dbPath;
            this.connection = DriverManager.getConnection(url);
            System.out.println("Połączono z bazą.");
        } catch (SQLException e) {
            System.out.println("Problem z łączeniem z bazą " + e.getMessage());
        }
    }

    public void disconnect() throws SQLException {
        try {
            if(this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
                System.out.println("Zamknięto połączenie z bazą.");
            }
        } catch (SQLException e) {
            System.out.println("disconnect error " + e.getMessage());
        }
    }

}
