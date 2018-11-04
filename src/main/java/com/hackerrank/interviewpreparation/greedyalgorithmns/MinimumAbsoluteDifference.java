package com.hackerrank.interviewpreparation.greedyalgorithmns;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rpatra16
 * @since 04/11/2018
 */
public class MinimumAbsoluteDifference {

    /**
     * Finds the minimum absolute difference in the array.
     *
     * @param a input array
     * @return the minimum absolute difference between any two different elements in the array a
     */
    static int minimumAbsoluteDifference(int[] a) {
        int minDiff = Integer.MAX_VALUE, diff;
        Arrays.sort(a);
        for (int i = 0; i < a.length - 1; i++) {
            if ((diff = Math.abs(a[i] - a[i + 1])) < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = minimumAbsoluteDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
