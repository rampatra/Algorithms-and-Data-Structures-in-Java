package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by rampatra on 08/05/2016.
 */
public class CavityMap {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String grid[] = new String[n];
        for (int grid_i = 0; grid_i < n; grid_i++) {
            grid[grid_i] = in.next();
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (Character.getNumericValue(grid[i].charAt(j)) > Character.getNumericValue(grid[i].charAt(j - 1))
                        && Character.getNumericValue(grid[i].charAt(j)) > Character.getNumericValue(grid[i].charAt(j + 1))
                        && Character.getNumericValue(grid[i].charAt(j)) > Character.getNumericValue(grid[i - 1].charAt(j))
                        && Character.getNumericValue(grid[i].charAt(j)) > Character.getNumericValue(grid[i + 1].charAt(j))) {
                    grid[i] = grid[i].substring(0, j) + "X" + grid[i].substring(j + 1);
                }
            }
        }
        for (int grid_i = 0; grid_i < n; grid_i++) {
            System.out.println(grid[grid_i]);
        }
    }
}
