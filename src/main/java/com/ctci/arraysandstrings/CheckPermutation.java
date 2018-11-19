package com.ctci.arraysandstrings;

import java.util.Arrays;

/**
 * @author rampatra
 * @since 19/11/2018
 */
public class CheckPermutation {

    /**
     * Checks if {@code s1} is a permutation of {@code s2}.
     *
     * @param s1
     * @param s2
     * @return
     */
    private static boolean isOnePermutationOfOther(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);

        return Arrays.equals(c1, c2);
    }

    /**
     * Checks if {@code s1} is a permutation of {@code s2}.
     *
     * @param s1
     * @param s2
     * @return
     */
    private static boolean isOnePermutationOfOtherGivenThatStringsContainOnlyAscii(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] chars = new int[128]; // assuming strings contain only ASCII characters

        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i)]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            chars[s2.charAt(i)]--;
            if (chars[s2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isOnePermutationOfOther("ram", "mar"));
        System.out.println(isOnePermutationOfOther("rama", "mar"));
        System.out.println(isOnePermutationOfOther("rama", "marA"));
        System.out.println("-------");
        System.out.println(isOnePermutationOfOtherGivenThatStringsContainOnlyAscii("ram", "mar"));
        System.out.println(isOnePermutationOfOtherGivenThatStringsContainOnlyAscii("rama", "mar"));
        System.out.println(isOnePermutationOfOtherGivenThatStringsContainOnlyAscii("rama", "marA"));
    }
}
