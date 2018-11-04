package com.hackerrank.interviewpreparation.greedyalgorithmns;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author rpatra16
 * @since 04/11/2018
 */
public class LuckBalance {

    /**
     * For the full question, please see: https://www.hackerrank.com/challenges/luck-balance/
     *
     * @param k
     * @param contests
     * @return
     */
    private static int luckBalance(int k, int[][] contests) {
        int lucks = 0;
        List<Integer> lucksForImportantContests = new ArrayList<>();
        for (int i = 0; i < contests.length; i++) {
            if (contests[i][1] == 1) {
                lucksForImportantContests.add(contests[i][0]);
            } else {
                lucks += contests[i][0];
            }
        }
        lucksForImportantContests.sort(Collections.reverseOrder());
        for (int i = 0; i < lucksForImportantContests.size(); i++) {
            if (i < k) { // can lose at most k of the important contests
                lucks += lucksForImportantContests.get(i);
            } else {
                lucks -= lucksForImportantContests.get(i);
            }
        }
        return lucks;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
