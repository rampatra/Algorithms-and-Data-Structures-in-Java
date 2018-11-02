package com.hackerrank.interviewpreparation.warmup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author rpatra16
 * @since 31/10/2018
 */
public class JumpingClouds {

    private static final Scanner scanner = new Scanner(System.in);

    private static int jumpingOnClouds(int[] c) {
        int jumps = 0;
        int i = 0;
        while (i < c.length) {
            if (((i + 2) < c.length) && c[i + 2] != 1) {
                i += 2;
            } else if (((i + 1) < c.length) && c[i + 1] != 1) {
                i += 1;
            }
            jumps++;
            if (i == c.length - 1) {
                break;
            }
        }
        return jumps;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
