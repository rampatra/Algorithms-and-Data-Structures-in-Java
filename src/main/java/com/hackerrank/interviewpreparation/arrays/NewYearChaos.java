package com.hackerrank.interviewpreparation.arrays;

import java.util.Scanner;

/**
 * @author rpatra16
 * @since 02/11/2018
 */
public class NewYearChaos {

    /**
     * To solve this question, we just need to count the number of persons
     * that overtake a particular person.
     *
     * @param q the queue
     */
    private static void minimumBribes(int[] q) {
        int bribes = 0;
        for (int i = q.length - 1; i >= 0; i--) {
            if (q[i] - i - 1 > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, q[i] - 2); j < i; j++) {
                if (q[j] > q[i]) bribes++;
            }
        }
        System.out.println(bribes);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
