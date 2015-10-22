package com.hackerrank.algorithms.arraysandsorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: ramswaroop
 * Date: 3/3/15
 * Time: 1:05 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class QuickSort2 {

    static void quickSort(int[] ar, int start, int end) {
        int pivot = ar[0];
        List<Integer> ar1 = new ArrayList<>();
        List<Integer> ar2 = new ArrayList<>();

        for (int i = start; i < end; i++) {
            if (ar[i] < pivot) {
                ar1.add(ar[i]);
            } else if (ar[i] > pivot) {
                ar2.add(ar[i]);
            }
        }

        //TODO
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
        quickSort(ar, 0, ar.length);
    }
}
