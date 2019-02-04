package com.hackerrank.algorithms.arraysandsorting;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: rampatra
 * Date: 3/2/15
 * Time: 5:02 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class RunningTime {
    static void insertionSortPart2(int[] ar) {
        int c = 0;
        for (int i = 1; i < ar.length; i++) {
            int V = ar[i], j;
            for (j = i - 1; j >= 0 && ar[j] > V; j--, c++) {
                ar[j + 1] = ar[j];
            }
            ar[j + 1] = V;
            //printArray(ar);
        }
        System.out.print(c);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        insertionSortPart2(ar);

    }

    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}
