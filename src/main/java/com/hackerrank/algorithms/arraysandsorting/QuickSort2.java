package com.hackerrank.algorithms.arraysandsorting;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: rampatra
 * Date: 3/3/15
 * Time: 1:05 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class QuickSort2 {

    static int partition(int[] a, int start, int end) {

        int pivot = start, temp;

        for (int i = start + 1; i <= end; i++) {
            // maintains the relative positioning of elements in each partition
            if (a[i] < a[pivot]) {
                start++;
                temp = a[i];
                int j;
                for (j = i; j > start; j--) {
                    a[j] = a[j - 1];
                }
                a[j] = temp;
            }
        }

        temp = a[pivot];
        while (pivot < start) {
            a[pivot] = a[pivot + 1];
            pivot++;
        }
        a[pivot] = temp;

        return pivot;
    }

    static void quickSort(int[] ar, int start, int end) {
        if (start < end) {
            int p = partition(ar, start, end);
            quickSort(ar, start, p - 1);
            quickSort(ar, p + 1, end);
            for (int i = start; i <= end; i++) {
                System.out.print(ar[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        quickSort(ar, 0, n - 1);
    }
}
