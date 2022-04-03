package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionCreator {
    private static final Properties properties = new Properties();
    static {
        try {
            properties.load(ConnectionCreator.class.getClassLoader().getResourceAsStream("database.properties"));
            String driverName = (String) properties.get("db.driver");
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
    private static final String DATABASE_URL = (String) properties.get("db.url");
    private ConnectionCreator() { }
    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, properties);
    }
}









