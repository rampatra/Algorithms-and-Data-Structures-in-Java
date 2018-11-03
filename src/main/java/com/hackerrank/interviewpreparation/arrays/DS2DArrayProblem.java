package com.hackerrank.interviewpreparation.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author rpatra16
 * @since 31/10/2018
 */
public class DS2DArrayProblem {

    private static final Scanner scanner = new Scanner(System.in);

    private static int hourglassSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;
        int hourglassSum;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr[0].length - 2; j++) {
                hourglassSum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] +
                        arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                if (hourglassSum > maxSum) {
                    maxSum = hourglassSum;
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
