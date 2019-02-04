package com.hackerrank.algorithms.arraysandsorting;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: rampatra
 * Date: 3/2/15
 * Time: 5:13 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class QuickSort1 {

    static void partition(int[] ar) {
        int pivot = ar[0], j = 0;
        int[] arCopy = ar.clone();

        for (int i = 0; i < arCopy.length; i++) {
            if (arCopy[i] < pivot) ar[j++] = arCopy[i];
        }
        for (int i = 0; i < arCopy.length; i++) {
            if (arCopy[i] >= pivot) ar[j++] = arCopy[i];
        }
        printArray(ar);
    }

    static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        partition(ar);
    }
}
