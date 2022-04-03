package main;

import methods.*;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Labyrinth {
    private static final int PROCENT = 20;
    public static int WIDTH;
    public static int LENGTH;

    public static final int START_X = 0;
    public static final int START_Y = 0;

    public static void main(String[] args) throws SQLException {
        int answer = 1;
        while (answer != 0) {
            answer = menu();
        }

        Operation operation = new Operation("close");
        operation.close();
        driversDelete();
    }

    public static char[][] makeLabyrinth() {
        char[][] maze = new char[LENGTH][WIDTH];
        int countMaxWalls = WIDTH * LENGTH / 100 * PROCENT + 1;
        int countWalls = 0;

        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < WIDTH; j++) {
                maze[i][j] = ' ';
            }
        }

        while (countWalls < countMaxWalls) {
            int x = (int) Math.round(Math.random() * (LENGTH - 1));
            int y = (int) Math.round(Math.random() * (WIDTH - 1));
            if (maze[x][y] != '▓') {
                maze[x][y] = '▓';
                countWalls++;
            }
        }
        maze[0][0] = 'S';
        maze[LENGTH - 1][WIDTH - 1] = 'E';
        printLabyrinth(maze, "Лабиринт");
        return maze;
    }
    public static void printLabyrinth(char[][] multiples, String name) {
        if(name.length() == 3) {
            System.out.println("+-----+\n" +
                    "| "+ name + " |\n" +
                    "+-----+");
        } else {
            System.out.println("+----------+\n" +
                    "| " + name + " |\n" +
                    "+----------+");
        }
        for (int i = -1; i <= multiples.length; i++) {
            for (int j = -1; j <= multiples[3].length; j++) {

                if (i == -1 || i == multiples.length) {
                    System.out.print("-");
                } else if (j == -1 || j == multiples[i].length) {
                    System.out.print("|");
                } else {
                    System.out.print(multiples[i][j]);
                }
            }
            System.out.println();
        }

    }
    public static int menu() throws SQLException {
        Scanner sc = new Scanner(System.in);
        int answer;
        System.out.println("""
                1) Вывести один из прошлых лабиринтов
                2) Создать новый
                0) Выйти
                """);
        answer = sc.nextInt();

        switch (answer) {
            case 1->  {
                LabyrinthTable labyrinthTable = new LabyrinthTable();
                BFS bfs = new BFS();
                DFS dfs = new DFS();
                System.out.println("Все имеющиеся лабиринты: ");
                labyrinthTable.printAll();

                System.out.println("Введите ID нужного лабиринта: ");
                long id = sc.nextLong();
                char[][] maze = labyrinthTable.getLastLabyrinth(id);
                printLabyrinth(maze, "Лабиринт");
                bfs.getLastBFS(id, maze);
                dfs.getLastDFS(id, maze);
            }
            case 2->{
                LabyrinthTable labyrinthTable = new LabyrinthTable();
                labyrinthTable.createTable();
                labyrinthTable.executeAdding();

                System.out.println("Введите количество столбцов: ");
                LENGTH = sc.nextInt();
                System.out.println("Введите количество строк: ");
                WIDTH = sc.nextInt();

                char[][] maze = makeLabyrinth();

                labyrinthTable.executeWalls(maze);

                BFS bfs = new BFS(maze, LENGTH, WIDTH);
                bfs.bfs(START_X, START_Y);

                DFS dfs = new DFS(maze, LENGTH, WIDTH);
                dfs.solve(new Point(START_X, START_Y));
                dfs.fillPath();
            }
            case 0 -> { return 0; }
            default -> System.out.println("Такого варианта нет");
        }

        return 1;
    }



    public static void driversDelete() {
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}