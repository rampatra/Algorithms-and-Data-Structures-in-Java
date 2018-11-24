package com.ctci.arraysandstrings;

/**
 * @author rampatra
 * @since 24/11/2018
 */
public class OneAway {

    /**
     * Checks if two strings are only one edit away, that is, by inserting, deleting, or editing
     * at max one character in {@code s1} it becomes same as {@code s2}.
     *
     * @param s1
     * @param s2
     * @return
     */
    private static boolean isOneEditAway(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return isOneCharacterDiffAtMax(s1, s2);
        } else if (s1.length() < s2.length()) {
            return checkForMaxOneInsertOrDeleteInS1(s1, s2);
        } else {
            return checkForMaxOneInsertOrDeleteInS1(s1, s2);
        }
    }

    private static boolean isOneCharacterDiffAtMax(String s1, String s2) {
        boolean foundDiff = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDiff) {
                    return false; // means we already found a difference earlier
                }
                foundDiff = true;
            }
        }
        return true;
    }

    private static boolean checkForMaxOneInsertOrDeleteInS1(String s1, String s2) {
        int i = 0;
        int j = 0;
        int s1Len = s1.length();
        int s2Len = s2.length();
        if (Math.abs(s1Len - s2Len) > 1) return false;

        while (i < s1Len && j < s2Len) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (s1Len > s2Len) {
                    i++;
                } else {
                    j++;
                }
                continue;
            }
            i++;
            j++;
        }
        return Math.abs(i - j) <= 1; // check whether difference in two strings is not more than 1
    }

    public static void main(String[] args) {
        System.out.println("pale,  ple: " + isOneEditAway("pale", "ple"));
        System.out.println("pales,pale: " + isOneEditAway("pales", "pale"));
        System.out.println("pale, bale: " + isOneEditAway("pale", "bale"));
        System.out.println("pale, bake: " + isOneEditAway("pale", "bake"));
        System.out.println("ram, rama: " + isOneEditAway("ram", "rama"));
        System.out.println("ram, ramaaaaaaa: " + isOneEditAway("ram", "ramaaaaaaa"));
    }
}
