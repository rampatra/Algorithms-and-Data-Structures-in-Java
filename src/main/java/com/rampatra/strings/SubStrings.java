package com.rampatra.strings;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 10/22/15
 * @time: 11:16 AM
 */
public class SubStrings {

    /**
     * Prints all sub-strings of string {@param s} iteratively.
     *
     * @param s
     */
    public static void printAllSubStrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                System.out.println(s.substring(i, j + 1));
            }
        }
    }

    /**
     * Prints all sub-strings of string {@param s} recursively.
     *
     * @param s
     */
    public static void printAllSubStringsRecursive(String s) {
        if (s.length() == 0) return;

        for (int i = 1; i <= s.length(); i++) {
            System.out.println(s.substring(0, i));
        }
        printAllSubStrings(s.substring(1));
    }

    public static void main(String[] args) {
        System.out.println("----Iterative----");
        printAllSubStrings("ram");
        System.out.println("--------");
        printAllSubStrings("");
        System.out.println("----Recursive----");
        printAllSubStringsRecursive("ram");
        System.out.println("--------");
        printAllSubStringsRecursive("");
    }
}
