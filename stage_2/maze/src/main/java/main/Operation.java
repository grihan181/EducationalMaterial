package main;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Operation implements Closeable {
    String operationName;
    static Connection connection;
    protected final Statement stat = connection.createStatement();

    static {
        try {
            connection = ConnectionCreator.createConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Operation(String operationName) throws SQLException {
        this.operationName = operationName;
    }

    public long getLabyrinthID() throws SQLException {
        long idLabyrinth = 0;
        ResultSet rs = stat.executeQuery("SELECT * FROM Labyrinth;");
        while (rs.next()) {
            idLabyrinth = rs.getLong("ID");
        }
        return idLabyrinth;
    }

    @Override
    public void close() {
        try {
            if(connection != null && !connection.isClosed()) {
                connection.close();
            }
            stat.close();
        } catch (SQLException e) {
            System.out.println("Ошибка закрытия SQL соединения!");
        }
    }
}
