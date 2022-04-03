package methods;

import main.Labyrinth;
import main.Operation;
import main.Point;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class DFS extends Operation {

    private char[][] maze;
    private Point[][] prev;

    private int width;
    private int length;

    private Point lastNode;

    public DFS(char[][] maze, int length, int width) throws SQLException {
        super("DFS");
        this.maze = maze;
        this.length = length;
        this.width = width;

        prev = new Point[length][width];
        createTable();
    }
    public DFS() throws SQLException {
        super("DFSLast");
    }

    public void createTable() throws SQLException {
        stat.execute("CREATE TABLE IF NOT EXISTS DFS(" +
                "ID BIGINT PRIMARY KEY AUTO_INCREMENT," +
                "X INT," +
                "Y INT," +
                "LABYRINTH_ID BIGINT," +
                "FOREIGN KEY (LABYRINTH_ID) REFERENCES Labyrinth(ID));");
    }
    private boolean inBoundsX(int number){
        return number >= 0 && number < width;
    }

    private boolean inBoundsY(int number){
        return number >= 0 && number < length;
    }

    public void solve(Point start){
        Stack<Point> stack = new Stack<>();
        HashSet<Point> visited = new HashSet<>();

        stack.push(start);

        while(!stack.isEmpty()) {
            Point tmp = stack.pop();
            visited.add(tmp);

            if (maze[tmp.getY()][tmp.getX()] == 'E') {
                lastNode = tmp;
                break;
            }

            for(Point point : this.getAdjacentEdges(tmp)) {
                if (!visited.contains(point)) {
                    stack.push(point);
                    prev[point.getY()][point.getX()] = tmp;
                }
            }
        }
    }

    public void fillPath() throws SQLException {
        long idLabyrinth = getLabyrinthID();
        if (lastNode == null) {
            System.out.println("No path in maze");
        } else {
            // assume, that start point and end point are different
            for (;;) {
                lastNode = prev[lastNode.getY()][lastNode.getX()];

                // There's no previous node for start point, so we can break
                if (lastNode == null) {
                    break;
                }

                if (maze[lastNode.getY()][lastNode.getX()] != 'S') {
                    maze[lastNode.getY()][lastNode.getX()] = '*';
                    stat.execute("INSERT INTO DFS (X, Y, LABYRINTH_ID)  " +
                            "VALUES(" + lastNode.getY() + ", " + lastNode.getX() + ", " + idLabyrinth + ");");
                }
            }
            Labyrinth.printLabyrinth(maze, "DFS");
        }
    }

    private List<Point> getAdjacentEdges(Point tmp) {
        List<Point> neighbours = new ArrayList<>();
        if(this.inBoundsX(tmp.getX()+1)){
            if(this.maze[tmp.getY()][tmp.getX()+1] != '▓'){
                neighbours.add(new Point(tmp.getX()+1, tmp.getY()));
            }
        }
        if(this.inBoundsX(tmp.getX()-1)){
            if(this.maze[tmp.getY()][tmp.getX()-1] != '▓'){
                neighbours.add(new Point(tmp.getX()-1, tmp.getY()));
            }
        }
        if(this.inBoundsY(tmp.getY()+1)){
            if(this.maze[tmp.getY()+1][tmp.getX()] != '▓'){
                neighbours.add(new Point(tmp.getX(), tmp.getY()+1));
            }
        }
        if(this.inBoundsY(tmp.getY()-1)){
            if(this.maze[tmp.getY()-1][tmp.getX()] != '▓'){
                neighbours.add(new Point(tmp.getX(), tmp.getY()-1));
            }
        }
        return neighbours;
    }

    public void getLastDFS(long id, char[][] maze) throws SQLException {
        ResultSet rs = stat.executeQuery("SELECT * FROM DFS WHERE  LABYRINTH_ID = " + id + "");
        while (rs.next()) {
            maze[rs.getInt("X")][rs.getInt("Y")] = '*';
        }

        Labyrinth.printLabyrinth(maze, "DFS");
    }
}