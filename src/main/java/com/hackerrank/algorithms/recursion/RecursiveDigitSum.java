package com.hackerrank.algorithms.recursion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Recursive Digit Sum Problem.
 *
 * @link https://www.hackerrank.com/challenges/recursive-digit-sum/problem
 * @author rpatra16
 * @since 06/11/2018
 */
public class RecursiveDigitSum {

    /**
     * Finds the recursive digit sum of n.
     *
     * @param n number
     * @param k the number would be repeated k times
     * @return recursive sum of the digits
     */
    private static int superDigit(String n, int k) {
        if (n.length() == 1 && k == 0) {
            return Integer.parseInt(n);
        }

        Long sum = 0L;
        char[] num = n.toCharArray();
        for (int i = 0; i < num.length; i++) {
            sum += Long.parseLong(String.valueOf(num[i]));
        }

        if (k != 0) sum *= k;

        return superDigit(sum.toString(), 0);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
