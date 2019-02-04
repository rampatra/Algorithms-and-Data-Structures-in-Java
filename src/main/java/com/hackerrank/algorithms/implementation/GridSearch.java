package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by rampatra on 02/05/2016.
 */
public class GridSearch {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int R = in.nextInt();
            int C = in.nextInt();
            String G[] = new String[R];
            for (int G_i = 0; G_i < R; G_i++) {
                G[G_i] = in.next();
            }
            int r = in.nextInt();
            int c = in.nextInt();
            String P[] = new String[r];
            for (int P_i = 0; P_i < r; P_i++) {
                P[P_i] = in.next();
            }

            // create 2D array for grid
            int grid[][] = new int[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    grid[i][j] = Character.getNumericValue(G[i].charAt(j));
                }
            }

            // create 2D array for pattern to be searched in grid
            int pattern[][] = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    pattern[i][j] = Character.getNumericValue(P[i].charAt(j));
                }
            }

            // search logic
            outerLoop:
            for (int G_i = 0; G_i < R; G_i++) {
                for (int G_j = 0; G_j < C; G_j++) {
                    innerLoop:
                    for (int P_i = 0; P_i < r && G_i + P_i < R; P_i++) {
                        for (int P_j = 0; P_j < c && G_j + P_j < C; P_j++) {
                            if (grid[G_i + P_i][G_j + P_j] != pattern[P_i][P_j]) {
                                break innerLoop;
                            } else if (P_i == r - 1 && P_j == c - 1) {
                                System.out.println("YES");
                                break outerLoop;
                            }
                        }

                    }
                    if (R - G_i < r) { // no. of rows left in grid less than no. of rows in pattern
                        System.out.println("NO");
                        break outerLoop;
                    }
                }
            }
        }
    }
}

