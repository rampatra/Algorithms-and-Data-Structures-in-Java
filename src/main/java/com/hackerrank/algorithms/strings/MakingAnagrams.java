package com.hackerrank.algorithms.strings;

import java.util.Arrays;

/**
 * @author rampatra
 * @version 28/09/2016
 */
public class MakingAnagrams {

    /**
     * Find number of characters to be deleted to make {@param a}
     * and {@param b} anagrams.
     * See: https://www.hackerrank.com/challenges/making-anagrams
     *
     * @param a
     * @param b
     * @return
     */
    public static int makeAnagrams(String a, String b) {

        int i = 0, j = 0, c = 0;
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);

        while (i < s1.length || j < s2.length) {
            if (i >= s1.length) {
                c++;
                j++;
            } else if (j >= s2.length) {
                c++;
                i++;
            } else if (s1[i] < s2[j]) {
                c++;
                i++;
            } else if (s1[i] > s2[j]) {
                c++;
                j++;
            } else {
                i++;
                j++;
            }
        }

        return c;
    }

    public static void main(String[] args) {
        System.out.println(makeAnagrams("abc", "cde"));
    }
}
