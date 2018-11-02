package com.hackerrank.interviewpreparation.warmup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Repeated String problem.
 *
 * @author rpatra16
 * @since 29/10/2018
 */
public class RepeatedString {

    private static final Scanner scanner = new Scanner(System.in);

    private static long repeatedString(String s, long n) {
        int extraLetters;
        long totalCount = 0, count = 0, stringLength = s.length();
        // count the no of a in non-repeated string
        for (int i = 0; i < stringLength; i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }
        totalCount += (n / stringLength * count);
        extraLetters = (int) (n % stringLength);
        // count the no of a in the remainder of the string
        for (int i = 0; i < extraLetters; i++) {
            if (s.charAt(i) == 'a') {
                totalCount++;
            }
        }
        return totalCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

