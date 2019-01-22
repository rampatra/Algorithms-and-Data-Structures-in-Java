package com.ctci.arraysandstrings;

/**
 * Assume you have a method isSubString which checks if one word is a substring of another. Given two
 * strings, S1 and S2, write code to check if S2 is a rotation of S1 using only one call to isSubString
 * (e.g., "waterbottle" is a rotation of" erbottlewat").
 *
 * @author rampatra
 * @since 2019-01-22
 */
public class StringRotation {

    private static boolean isStringRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        s2 = s2 + s2;
        return isSubString(s1, s2);
    }

    /**
     * Given method in question.
     *
     * @param s1 first string
     * @param s2 second string
     * @return {@code true} if s1 is a substring of s2 or else {@code false}
     */
    private static boolean isSubString(String s1, String s2) {
        return s2.contains(s1);
    }

    public static void main(String[] args) {
        System.out.println(isStringRotation("waterbottle", "erbottlewat")); // true
        System.out.println(isStringRotation("rampatra", "atraramp")); // true
        System.out.println(isStringRotation("rampatra", "arampata")); // false
        System.out.println(isStringRotation("rampatra", "arampat")); // false
        System.out.println(isStringRotation("", "")); // true
    }
}
