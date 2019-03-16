package com.rampatra.backtracking;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 10/18/15
 * @time: 10:39 AM
 */
public class RatInAMaze {

    /**
     * @param i
     * @param j
     * @param maze
     * @return
     */
    public static boolean isValidMove(int i, int j, int[][] maze) {
        if (i >= 0 && i < maze.length && j >= 0 && j < maze[0].length && maze[i][j] == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param i
     * @param j
     * @param xMoves
     * @param yMoves
     * @param maze
     * @param path
     * @return
     */
    public static boolean isValidPath(int i, int j, int[] xMoves, int[] yMoves, int[][] maze, int[][] path) {

        if (i == maze.length - 1 && j == maze[0].length - 1) return true;

        int nextI, nextJ;

        for (int k = 0; k < xMoves.length; k++) {
            nextI = i + xMoves[k];
            nextJ = j + yMoves[k];
            if (isValidMove(nextI, nextJ, maze)) {
                path[nextI][nextJ] = 1;
                if (isValidPath(nextI, nextJ, xMoves, yMoves, maze, path)) {
                    return true;
                } else {
                    path[nextI][nextJ] = 0;
                }
            }
        }
        return false;
    }

    /**
     * @param i    is the start row
     * @param j    is the start column
     * @param maze is the maze in which a path has to be found (1 denotes rat can traverse and 0 denotes it cannot)
     */
    public static void printMazePath(int i, int j, int[][] maze) {

        int[] xMoves = {0, 1};
        int[] yMoves = {1, 0};

        int[][] path = new int[maze.length][maze[0].length];

        System.out.println("Maze");
        System.out.println("---------------");
        print2DMatrix(maze);
        System.out.println("---------------");

        if (isValidPath(i, j, xMoves, yMoves, maze, path)) {
            print2DMatrix(path);
        } else {
            System.out.println("No escape path found!");
        }
    }

    public static void print2DMatrix(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print("[" + array[i][j] + "]");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printMazePath(0, 0, new int[][]{{1, 1, 1, 1}, {0, 0, 1, 1}});
    }
}
