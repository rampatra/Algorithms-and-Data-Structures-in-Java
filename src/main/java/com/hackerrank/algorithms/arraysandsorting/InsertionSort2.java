package com.hackerrank.algorithms.arraysandsorting;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: rampatra
 * Date: 3/1/15
 * Time: 9:42 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class InsertionSort2 {

    static void insertionSortPart2(int[] ar) {
        for (int i = 1; i < ar.length; i++) {
            int V = ar[i], j;
            /**
             * keep shifting no.s to right until
             * right place for insertion(of V) is found
             */
            for (j = i - 1; j >= 0 && ar[j] > V; j--) {
                ar[j + 1] = ar[j];
            }
            ar[j + 1] = V;
            printArray(ar);
        }
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
