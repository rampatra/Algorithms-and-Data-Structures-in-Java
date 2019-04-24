package com.leetcode.strings;

/**
 * Level: Easy
 * Problem: https://leetcode.com/problems/first-unique-character-in-a-string/
 *
 * @author rampatra
 * @since 2019-04-16
 */
public class UniqueCharacterInString {

    /**
     * Time complexity: O(n)
     * Runtime: <a href="https://leetcode.com/submissions/detail/222914261/">7 ms on leetcode</a>.
     *
     * @param str the input string
     * @return the index of the first non-repeating character in {@code str}, {@code -1} otherwise.
     */
    private static int findFirstUniqueCharacterInString(String str) {
        int[] charCount = new int[26];

        for (int i = 0; i < str.length(); i++) {
            charCount[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (charCount[str.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findFirstUniqueCharacterInString("leetcode"));
        System.out.println(findFirstUniqueCharacterInString("loveleetcode"));
    }
}
