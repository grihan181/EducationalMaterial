package methods;

import main.Labyrinth;
import main.LabyrinthTable;
import main.Point;
import main.Operation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class BFS extends Operation {
    private static int startX;
    private static int startY;
    private static int endX;
    private static int endY;
    private static char[][] maze;
    private static int length;
    private static int width;

    private static Queue<Point> queue;
    private static Point[][] path;
    private static boolean[][] visited;

    public BFS(char[][] maze, int length, int width) throws SQLException {
        super("BFS");
        BFS.maze = maze;
        BFS.length = length;
        BFS.width = width;
        path = new Point[length][width];
        visited = new boolean[length][width];

        startX = 0;
        startY = 0;
        endX = length - 1;
        endY = width - 1;

        queue = new LinkedList<Point>();
        queue.add(new Point(startX,startY));
        createTable();
    }
    public BFS() throws SQLException {
        super("BFSLast");
    }

    public void createTable() throws SQLException {
        stat.execute("CREATE TABLE IF NOT EXISTS BFS(" +
                "ID BIGINT PRIMARY KEY AUTO_INCREMENT," +
                "X INT," +
                "Y INT," +
                "LABYRINTH_ID BIGINT," +
                "FOREIGN KEY (LABYRINTH_ID) REFERENCES Labyrinth(ID));");
    }

    public int bfs(int curX,int curY) throws SQLException {
        // Условие выполнено, что указывает на то, что конец достигнут
        if(curX == endX && curY == endY){
            createRoad(path,endX,endY);
            maze[endX][endY] = 'E';
            Labyrinth.printLabyrinth(maze, "BFS");
            return 1;
        }

        queue.poll();

        visited[curX][curY] = true;

        if(curX > 0 && !visited[curX - 1][curY] && maze[curX-1][curY] != '▓'){

            queue.add(new Point(curX-1,curY));

            path[curX-1][curY] = new Point(curX,curY);
        }

        if(curY > 0 && !visited[curX][curY - 1] && maze[curX][curY-1] != '▓'){
            queue.add(new Point(curX,curY-1));
            path[curX][curY-1] = new Point(curX,curY);
        }
        // означает снижение
        if(curX < length -1 && !visited[curX + 1][curY] && maze[curX+1][curY] != '▓'){
            queue.add(new Point(curX+1,curY));
            path[curX+1][curY] = new Point(curX,curY);
        }
        // означает идти вправо
        if(curY < width -1 && !visited[curX][curY + 1] && maze[curX][curY+1] != '▓'){
            queue.add(new Point(curX,curY+1));
            path[curX][curY+1] = new Point(curX,curY);
        }
        // Назначаем руководителя команды на точку
        Point point = queue.peek();
        if(point == null){
            return 0;
        }else{
            try {
                return bfs(point.getX(),point.getY());
            } catch (StackOverflowError e) {
                System.out.println("BFS не найден");
                return 0;
            }

        }
    }

    public void createRoad(Point[][] path, int x, int y) throws SQLException {
        long idLabyrinth = getLabyrinthID();
        if(x != startX || y != startY){
            createRoad(path,path[x][y].getX(),path[x][y].getY());
            maze[x][y] = '*';
            stat.execute("INSERT INTO BFS (X, Y, LABYRINTH_ID)  " +
                    "VALUES(" + x + ", " + y + ", " + idLabyrinth + ");");
        }
    }
    public void getLastBFS(long id, char[][] maze) throws SQLException {
        boolean flag = false;
        ResultSet rs = stat.executeQuery("SELECT * FROM BFS WHERE  LABYRINTH_ID = " + id + "");

        while (rs.next()) {
            maze[rs.getInt("X")][rs.getInt("Y")] = '*';
            flag = true;
        }
        if (flag) {
            Labyrinth.printLabyrinth(maze, "BFS");
        } else {
            System.out.println("+-----+\n" +
                    "| BFS |\n" +
                    "+-----+");
            System.out.println("BFS выход не найден");
        }
    }
}


