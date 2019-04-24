package com.leetcode.strings;

/**
 * Level: Easy
 * Problem: https://leetcode.com/problems/reverse-vowels-of-a-string/
 *
 * @author rampatra
 * @since 2019-04-19
 */
public class ReverseVowels {

    /**
     * Reverse only the vowels in the string {@code str}.
     * <p>
     * Time Complexity: O(n)
     * where,
     * n = no. of characters in the string
     * <p>
     * Runtime: <a href="https://leetcode.com/submissions/detail/223519160/">2 ms on leetcode</a>.
     *
     * @param str
     * @return
     */
    private static String reverseVowels(String str) {

        char[] chars = str.toCharArray();
        char temp;
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            // find the vowel from left
            while (!isVowel(chars[left]) && left < right) {
                left++;
            }
            // find the vowel from right
            while (!isVowel(chars[right]) && left < right) {
                right--;
            }

            if (!isVowel(chars[left]) || !isVowel(chars[right])) {
                break;
            }

            // swap the characters
            temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }
        return new String(chars);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("a"));
        System.out.println(reverseVowels(""));
    }
}