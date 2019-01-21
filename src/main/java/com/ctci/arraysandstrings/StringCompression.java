package com.ctci.arraysandstrings;

/**
 * @author rampatra
 * @since 24/11/2018
 */
public class StringCompression {

    /**
     * Compresses the string {@code s} such that a string {@code aabccccaaa} becomes {@code a2b1c4a3}.
     * Also, if the compressed string is not shorter than the original, returns the original string.
     *
     * @param str input string containing only a-z characters, both cases
     * @return which ever is the shorter string
     */
    private static String compressString(String str) {
        StringBuilder compressedSb = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            /* If next character is different than current, append this char to result. */
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedSb.append(str.charAt(i));
                compressedSb.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressedSb.length() < str.length() ? compressedSb.toString() : str;
    }

    public static void main(String[] args) {
        System.out.println("aabccccaaa: " + compressString("aabccccaaa"));
        System.out.println("aabccccAAAA: " + compressString("aabccccAAAA"));
        System.out.println("abcd: " + compressString("abcd"));
        System.out.println("a: " + compressString("a"));
        System.out.println("aabcccccccccccccccccccccccccaaa: " + compressString("aabcccccccccccccccccccccccccaaa"));
    }
}
