package me.ramswaroop.backtracking;

/**
 * Created by IntelliJ IDEA.
 * <p/>
 * A knight's tour is a sequence of moves of a knight on a chessboard such that the knight visits every square only
 * once. If the knight ends on a square that is one knight's move from the beginning square (so that it could tour the
 * board again immediately, following the same path), the tour is closed, otherwise it is open.
 *
 * @author: ramswaroop
 * @date: 10/15/15
 * @time: 11:56 PM
 * @see: https://en.wikipedia.org/wiki/Knight%27s_tour
 */
public class KnightTour {

    public static boolean isValidMove(int i, int j, int[][] tour) {
        if (i >= 0 && j >= 0 && i < tour.length && j < tour[0].length && tour[i][j] == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidKnightTour(int i, int j, int[] xMoves, int[] yMoves, int step, int[][] tour) {

        if (step == tour.length * tour[0].length) return true;

        for (int k = 0; k < xMoves.length; k++) {
            i += xMoves[k];
            j += yMoves[k];

            if (isValidMove(i, j, tour)) {
                step++;
                tour[i][j] = step;
                if (isValidKnightTour(i, j, xMoves, yMoves, step, tour)) {
                    return true;
                } else {
                    tour[i][j] = 0;
                }
            }
        }

        return false;
    }

    public static void printKnightTour(int[] boardSize) {
        if (boardSize.length < 2) return;

        int[][] tour = new int[boardSize[0]][boardSize[1]];
        int[] xMoves = new int[]{1, 1, 2, 2, -1, -1, -2, -2};
        int[] yMoves = new int[]{-2, 2, -1, 1, -2, 2, -1, 1};

        tour[0][0] = 1;

        if (isValidKnightTour(0, 0, xMoves, yMoves, 1, tour)) {
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

    public static void main(String a[]) {
        printKnightTour(new int[]{8, 8});
    }
}
