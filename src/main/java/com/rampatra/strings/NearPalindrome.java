package com.rampatra.strings;

/**
 * @author rampatra
 * @since 05/12/2018
 */
public class NearPalindrome {

    /**
     * Checks if a string can be a palindrome by changing just one character in the string {@code str}.
     *
     * @param str the input string
     * @return {@code true} if it can be converted to a palindrome with one character change or else {@code false}
     */
    private static boolean isStringPalindromeByChangingOneChar(String str) {
        int diffCount = 0;
        for (int i = 0, j = str.length() - 1; i < str.length() / 2; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                if (diffCount > 0) {
                    return false;
                } else {
                    diffCount++;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isStringPalindromeByChangingOneChar(""));
        System.out.println(isStringPalindromeByChangingOneChar("a"));
        System.out.println(isStringPalindromeByChangingOneChar("ab"));
        System.out.println(isStringPalindromeByChangingOneChar("aabbca"));
        System.out.println(isStringPalindromeByChangingOneChar("abccaa"));
        System.out.println(isStringPalindromeByChangingOneChar("abbcca"));
    }
}
