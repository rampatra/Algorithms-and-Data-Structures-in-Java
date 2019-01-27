package com.hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 10/22/15
 * @time: 8:47 AM
 */
public class Pangram {

    public static String isPangram(String s) {

        char c;
        s = s.replaceAll("\\s+", "");
        s = s.toUpperCase();
        int[] alphabets = new int[26];

        // check if all alphabets are present only once
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (alphabets[c - 65] == 0) {
                alphabets[c - 65] = 1;
            }
        }

        // check if all alphabets are present in string at least once
        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] == 0) return "not pangram";
        }

        return "pangram";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(isPangram(s));
    }
}
