package com.hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 10/22/15
 * @time: 9:24 AM
 */
public class AlternatingCharacters {

    public static int countDeletions(String s) {
        int count = 0, index = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(index)) {
                count++;
            } else {
                index = i;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        String[] input = new String[t];
        for (int i = 0; i < t; i++) {
            input[i] = in.nextLine();
        }
        for (int i = 0; i < t; i++) {
            System.out.println(countDeletions(input[i]));
        }
    }
}
