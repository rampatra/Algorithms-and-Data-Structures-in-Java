package com.hackerrank.contests;

/**
 * @author rpatra16
 * @since 04/11/2018
 */
public class SwappingInAnArray {
    // Complete the swapToSort function below.
    static int swapToSort(int[] a) {
        // Return -1 or 0 or 1 as described in the problem statement.
        int swaps = 0;
        for (int i=0; i < a.length-1; i++) {
            int swapIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    swapIndex = j;
                }
            }
            if (swapIndex != i) {
                swap(a, i, swapIndex);
                swaps++;
                i--;
            }
        }
        if (swaps > 1) {
            return -1;
        } else {
            return swaps;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {

    }
}
