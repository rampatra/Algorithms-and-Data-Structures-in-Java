package com.hackerrank.algorithms.arraysandsorting;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: rampatra
 * Date: 3/1/15
 * Time: 8:58 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class InsertionSort1 {

    static void insertIntoSorted(int[] ar) {
        int V = ar[ar.length - 1], i = ar.length - 2;

        for (; i >= 0; i--) {
            if (V < ar[i]) {
                ar[i + 1] = ar[i];
            } else {
                break;
            }
            printArray(ar);
        }

        ar[i + 1] = V;
        printArray(ar);
    }

    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        insertIntoSorted(ar);
    }

    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

}
