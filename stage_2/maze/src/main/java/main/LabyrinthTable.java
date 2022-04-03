package main;

import java.awt.geom.FlatteningPathIterator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LabyrinthTable extends Operation{

    public LabyrinthTable() throws SQLException {
        super("LabyrinthTable");
    }

    public void createTable() throws SQLException {
        stat.execute("CREATE TABLE IF NOT EXISTS Labyrinth(" +
                "ID BIGINT PRIMARY KEY AUTO_INCREMENT," +
                "NAME VARCHAR(255) NOT NULL);");
    }
    public void executeAdding() {
        Scanner sc = new Scanner(System.in);
        String name;
        System.out.println("Введите название лабиринта: ");
        name = sc.nextLine();
        try {
            stat.execute("INSERT INTO Labyrinth (NAME)  " +
                    "values('" + name + "');");
        } catch (Exception e) {
            System.out.println("Введены недопустимые параматры лабиринта! Вызвалась ошибка:\n" + e);
        }
        System.out.println("\nЛабиринт добавлен!\n");
    }
    public void executeWalls(char[][] maze) throws SQLException {
        stat.execute("CREATE TABLE IF NOT EXISTS LabyrinthWalls(" +
                "ID BIGINT PRIMARY KEY AUTO_INCREMENT," +
                "X INT," +
                "Y INT," +
                "X_MAX INT," +
                "Y_MAX INT," +
                "LABYRINTH_ID BIGINT," +
                "FOREIGN KEY (LABYRINTH_ID) REFERENCES Labyrinth(ID));");
        long idLabyrinth = getLabyrinthID();

        for (int x = 0; x < maze.length; x++) {
            for (int y = 0; y < maze[x].length; y++) {
                if (maze[x][y] == '▓') {
                    stat.execute("INSERT INTO LabyrinthWalls (X, Y, LABYRINTH_ID, X_MAX, Y_MAX)  " +
                            "VALUES(" + x + ", " + y + ", " + idLabyrinth + ", "+ maze.length + ", " + maze[x].length + ");");
                }
            }
        }
    }

    public char[][] getLastLabyrinth(long id) throws SQLException {
        ResultSet rs = stat.executeQuery("SELECT * FROM LabyrinthWalls WHERE  LABYRINTH_ID = " + id + "");
       int x = 0, y = 0;
        while (rs.next()) {
           x = rs.getInt("X_MAX");
           y = rs.getInt("Y_MAX");
       }
        char[][] maze = new char[x][y];
        rs.close();

        ResultSet rsWalls = stat.executeQuery("SELECT * FROM LabyrinthWalls WHERE  LABYRINTH_ID = " + id + "");
        while (rsWalls.next()) {
            maze[rsWalls.getInt("X")][rsWalls.getInt("Y")] = '▓';
        }
        for(int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if(i == 0 && j ==0) {
                    maze[i][j] = 'S';
                } else if(i == maze.length-1 && j == maze[0].length) {
                    maze[i][j] = 'E';
                } else if(maze[i][j] != '▓') {
                    maze[i][j] = ' ';
                }
            }
        }
        return maze;
    }

    public void printAll() throws SQLException {
        int countLab = 0;
        ResultSet rsCount = stat.executeQuery("SELECT * FROM Labyrinth");
        while (rsCount.next()){
            countLab++;
        }
        rsCount.close();

        String[][] table = new String[countLab + 1][];
        table[0] = new String[] {"ID", "NAME"};

        ResultSet rs = stat.executeQuery("SELECT * FROM Labyrinth");
        int i = 1;
        while (rs.next()) {
            table[i] = new String[] {
                    rs.getString("ID"),
                    rs.getString("name")};
            i++;
        }
        PrettyPrinter printer = new PrettyPrinter();
        printer.print(table);
    }
}

