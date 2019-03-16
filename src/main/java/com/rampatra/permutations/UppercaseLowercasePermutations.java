package com.rampatra.permutations;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 9/26/15
 * @time: 4:43 PM
 */
public class UppercaseLowercasePermutations {

    /**
     * Generates all possible case combinations for string {@param s}.
     * <p/>
     * For example,
     * Input: 0ab
     * Output: ["0ab","0AB","0aB","0Ab"]
     *
     * @param prefix
     * @param s
     */
    public static void printUppercaseLowercasePermutations(String prefix, String s) {

        if (s.isEmpty()) {
            System.out.println(prefix);
            return;
        }

        if (isNumber(s.charAt(0))) {
            printUppercaseLowercasePermutations(prefix + s.charAt(0), s.substring(1));
        } else {
            printUppercaseLowercasePermutations(prefix + Character.toUpperCase(s.charAt(0)), s.substring(1));
            printUppercaseLowercasePermutations(prefix + Character.toLowerCase(s.charAt(0)), s.substring(1));
        }
    }

    public static boolean isNumber(char s) {
        try {
            Integer.parseInt(String.valueOf(s));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        printUppercaseLowercasePermutations("", "0ab");
        System.out.println("========");
        printUppercaseLowercasePermutations("", "01");
        System.out.println("========");
        printUppercaseLowercasePermutations("", "0a1");
        System.out.println("========");
        printUppercaseLowercasePermutations("", "0ab1c");
    }
}
