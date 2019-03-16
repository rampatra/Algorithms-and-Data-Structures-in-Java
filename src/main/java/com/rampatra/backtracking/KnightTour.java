package com.rampatra.backtracking;

/**
 * Created by IntelliJ IDEA.
 * <p/>
 * A knight's tour is a sequence of moves of a knight on a chessboard such that the knight visits every square only
 * once. If the knight ends on a square that is one knight's move from the beginning square (so that it could tour the
 * board again immediately, following the same path), the tour is closed, otherwise it is open.
 *
 * @author rampatra
 * @since 10/15/15
 * @time: 11:56 PM
 * @see: https://en.wikipedia.org/wiki/Knight%27s_tour
 * @see: RatInAMaze for a simpler version of this problem
 */
public class KnightTour {

    /**
     * Determines if a move is a valid move in the given chess board.
     *
     * @param i    is the row of the new move
     * @param j    is the column of the new move
     * @param tour
     * @return
     */
    public static boolean isValidMove(int i, int j, int[][] tour) {
        if (i >= 0 && i < tour.length && j >= 0 && j < tour[0].length && tour[i][j] == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Finds a valid knight's tour for a given chess board size if any
     * with the use of backtracking.
     *
     * @param i
     * @param j
     * @param xMoves
     * @param yMoves
     * @param step
     * @param tour
     * @return
     */
    public static boolean isValidKnightTour(int i, int j, int[] xMoves, int[] yMoves, int step, int[][] tour) {

        if (step > tour.length * tour[0].length) return true;

        int nextI, nextJ;

        for (int k = 0; k < xMoves.length; k++) {
            // next move is calculated from all possible moves
            nextI = i + xMoves[k];
            nextJ = j + yMoves[k];

            // if the next move is valid then we proceed otherwise we 
            // try next set of moves
            if (isValidMove(nextI, nextJ, tour)) {
                tour[nextI][nextJ] = step;
                if (isValidKnightTour(nextI, nextJ, xMoves, yMoves, step + 1, tour)) {
                    return true;
                } else {
                    tour[nextI][nextJ] = 0; // backtrack
                }
            }
        }

        return false;
    }


    /**
     * Prints the knight's tour if any.
     *
     * @param i         is the start row
     * @param j         is the start column
     * @param boardSize is the size of the chess board
     */
    public static void printKnightTour(int i, int j, int[] boardSize) {
        if (boardSize.length < 2) return;

        // a 2D array for the knight's tour
        int[][] tour = new int[boardSize[0]][boardSize[1]];
        // all possible relative moves that a knight can make
        int[] xMoves = new int[]{1, 1, 2, 2, -1, -1, -2, -2};
        int[] yMoves = new int[]{-2, 2, -1, 1, -2, 2, -1, 1};

        tour[0][0] = 1;

        if (isValidKnightTour(i, j, xMoves, yMoves, 2, tour)) {
            print2DMatrix(tour);
        } else {
            System.out.println("Knight's tour doesn't exist for board size [" + boardSize[0] + "x" + boardSize[1] + "]");
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
        printKnightTour(0, 0, new int[]{8, 8});
    }
}
