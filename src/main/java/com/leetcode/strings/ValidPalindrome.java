package com.leetcode.strings;

/**
 * Level: Easy
 * Problem: https://leetcode.com/problems/valid-palindrome/
 *
 * @author rampatra
 * @since 2019-04-19
 */
public class ValidPalindrome {

    /**
     * Time complexity: O(n)
     * where,
     * n = no. of characters in the string
     * <p>
     * Runtime: <a href="https://leetcode.com/submissions/detail/223590134/">2 ms on leetcode</a>.
     *
     * @param str
     * @return
     */
    private static boolean isPalindrome(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            // if it's not alphanumeric then move the left pointer forward
            while (!isAlphaNumeric(chars[left]) && left < right) {
                left++;
            }
            // if it's not alphanumeric then move the right pointer backward
            while (!isAlphaNumeric(chars[right]) && left < right) {
                right--;
            }

            // case insensitive comparison
            if (Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    private static boolean isAlphaNumeric(char c) {
        int i = (int) c;
        return (i >= 48 && i <= 57) || (i >= 65 && i <= 90) || (i >= 97 && i <= 122);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("0P"));
    }
}