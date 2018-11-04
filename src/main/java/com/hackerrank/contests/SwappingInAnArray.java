package com.hackerrank.contests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author rpatra16
 * @since 04/11/2018
 */
public class SwappingInAnArray {

    /**
     * The problem asks if we can sort the array with only one swap.
     *
     * @param a array to sort
     * @return 0 if already sorted, 1 if it can be sorted with one swap, -1 otherwise
     */
    static int swapToSort(int[] a) {
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

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = swapToSort(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
