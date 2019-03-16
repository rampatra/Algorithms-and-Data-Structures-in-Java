package com.rampatra.permutations;

/**
 * Prints all the permutations of a string by using the characters in the
 * input only once.
 *
 * @author rampatra
 * @link http://www.ericleschinski.com/c/java_permutations_recursion/
 * @link http://introcs.cs.princeton.edu/java/23recursion/Permutations.java.html
 * @link me.rampatra.strings.StringPermutationCount for a modification of this problem
 * @since 9/24/15
 */
public class StringPermutations {

    /**
     * Generates and prints all possible permutations (in order)
     * of string {@param s}.
     *
     * @param prefix empty string, needed for the recursive method
     * @param s input string with no repeated characters
     */
    public static void printAllPermutations(String prefix, String s) {
        int len = s.length();
        if (len == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < len; i++) {
                printAllPermutations(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1));
            }
        }
    }

    public static void main(String[] args) {
        printAllPermutations("", "a");
        System.out.println("-------");
        printAllPermutations("", "ab");
        System.out.println("-------");
        printAllPermutations("", "abc");
    }
}
