import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

class Maze {

    private static final int PROCENT = 20;
    private static final int WIDTH = 10;
    private static final int LENGTH = 10;
    private static final int START_X = 0;
    private static final int START_Y = 0;
    private static final int END_X = LENGTH - 1;
    private static final int END_Y = WIDTH - 1;

    private char[][] maze;
    private Node[][] prev;

    private int sizeX;
    private int sizeY;

    private Node lastNode;

    Maze(char[][] maze, int sizeY, int sizeX) {
        this.maze = maze;
        this.sizeY = sizeY;
        this.sizeX = sizeX;

        prev = new Node[sizeY][sizeX];
    }

    private boolean inBoundsX(int number){
        return number >= 0 && number < sizeX;
    }

    private boolean inBoundsY(int number){
        return number >= 0 && number < sizeY;
    }

    public void solve(Node start){
        Stack<Node> stack = new Stack<>();
        HashSet<Node> visited = new HashSet<>();

        stack.push(start);

        while(!stack.isEmpty()) {
            Node tmp = stack.pop();
            visited.add(tmp);

            if (maze[tmp.getY()][tmp.getX()] == 'E') {
                lastNode = tmp;
                break;
            }

            for(Node node : this.getAdjacentEdges(tmp)) {
                if (!visited.contains(node)) {
                    stack.push(node);
                    prev[node.getY()][node.getX()] = tmp;
                }
            }
        }
    }

    public void fillPath() {
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
                }
            }
        }
    }

    private List<Node> getAdjacentEdges(Node tmp) {
        List<Node> neighbours = new ArrayList<Node>();
        if(this.inBoundsX(tmp.getX()+1)){
            if(this.maze[tmp.getY()][tmp.getX()+1] != '▓'){
                neighbours.add(new Node(tmp.getX()+1, tmp.getY()));
            }
        }
        if(this.inBoundsX(tmp.getX()-1)){
            if(this.maze[tmp.getY()][tmp.getX()-1] != '▓'){
                neighbours.add(new Node(tmp.getX()-1, tmp.getY()));
            }
        }
        if(this.inBoundsY(tmp.getY()+1)){
            if(this.maze[tmp.getY()+1][tmp.getX()] != '▓'){
                neighbours.add(new Node(tmp.getX(), tmp.getY()+1));
            }
        }
        if(this.inBoundsY(tmp.getY()-1)){
            if(this.maze[tmp.getY()-1][tmp.getX()] != '▓'){
                neighbours.add(new Node(tmp.getX(), tmp.getY()-1));
            }
        }
        return neighbours;
    }


    public static void main(String[] args){
        char [][] maze = makeLabyrinth();

        // Create maze with certain dimensions
        Maze m = new Maze(maze, 10, 10);

        m.solve(new Node(0,0));

        m.fillPath();

     printLabyrint(maze);
    }
    public static char[][] makeLabyrinth() {
        char[][] labyrinth = new char[LENGTH][WIDTH];
        int countMaxWalls = WIDTH * LENGTH / 100 * PROCENT;
        int countWalls = 0;

        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < WIDTH; j++) {
                labyrinth[i][j] = ' ';
            }
        }

        while (countWalls <= countMaxWalls) {
            labyrinth[(int) Math.round(Math.random() * (LENGTH - 1))][(int) Math.round(Math.random() * (WIDTH - 1))] = '▓';
            countWalls++;
        }
        labyrinth[0][0] = 'S';
        labyrinth[LENGTH - 1][WIDTH - 1] = 'E';
        printLabyrint(labyrinth);
        return labyrinth;
    }

    public static void printLabyrint(char[][] multiples) {
        System.out.println("+----------+\n" +
                "| Лабиринт |\n" +
                "+----------+");
        for (int i = -1; i <= LENGTH; i++) {
            for (int j = -1; j <= WIDTH; j++) {

                if (i == -1 || i == LENGTH) {
                    System.out.print("-");
                } else if (j == -1 || j == WIDTH) {
                    System.out.print("|");
                } else {
                    System.out.print(multiples[i][j]);
                }
            }
            System.out.println();
        }

    }

}
class Node {
    private int x;
    private int y;


    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }


    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

    @Override
    public int hashCode() {
        return this.getX() + this.getY() + 31;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Node tmp = (Node) obj;
        return tmp.getX() == this.getX() && this.getY() == tmp.getY();
    }

    @Override
    public String toString() {
        return "x: " + this.getX() + " y: " + this.getY();
    }
}