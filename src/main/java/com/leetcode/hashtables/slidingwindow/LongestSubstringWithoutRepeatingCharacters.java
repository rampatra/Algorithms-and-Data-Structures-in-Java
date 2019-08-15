package com.leetcode.hashtables.slidingwindow;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Medium
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Description:
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * @author rampatra
 * @since 2019-08-15
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Sliding Window Approach (using map).
     * <p>
     * Note:
     * If we know that the charset is rather small, we can replace the Map with an integer array as direct access table.
     * <p>
     * Commonly used tables are:
     * <p>
     * int[26] for Letters 'a' - 'z' or 'A' - 'Z'
     * int[128] for ASCII
     * int[256] for Extended ASCII
     * <p>
     * Runtime: <a href="https://leetcode.com/submissions/detail/251869571/">8 ms</a>.
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int longestSubstringLen = 0;
        Set<Character> charsInWindow = new HashSet<>();


        while (right < s.length()) {

            if (charsInWindow.contains(s.charAt(right))) {
                while (s.charAt(left) != s.charAt(right)) {
                    longestSubstringLen = Math.max(longestSubstringLen, right - left);
                    charsInWindow.remove(s.charAt(left));
                    left++;
                }
                left++;
            }

            charsInWindow.add(s.charAt(right));
            right++;
        }

        return Math.max(longestSubstringLen, right - left);
    }

    /**
     * Sliding Window Approach using int array.
     *
     * Runtime: <a href="https://leetcode.com/submissions/detail/251869406/">2 ms</a>.
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringNoMap(String s) {
        int left = 0;
        int right = 0;
        int longestSubstringLen = 0;
        int[] charsInWindow = new int[128];

        // keep moving forward the right pointer and adding characters to the window
        while (right < s.length()) {

            // once we encounter repeated characters, move the left pointer until the repeated character is removed
            if (charsInWindow[s.charAt(right)] == 1) {
                while (s.charAt(left) != s.charAt(right)) {
                    longestSubstringLen = Math.max(longestSubstringLen, right - left);
                    charsInWindow[s.charAt(left)] = 0;
                    left++;
                }
                left++;
            }

            charsInWindow[s.charAt(right)] = 1;
            right++;
        }

        return Math.max(longestSubstringLen, right - left);
    }

    public static void main(String[] args) {
        assertEquals(0, lengthOfLongestSubstring(""));
        assertEquals(1, lengthOfLongestSubstring(" "));
        assertEquals(1, lengthOfLongestSubstring("a"));
        assertEquals(2, lengthOfLongestSubstring("aab"));
        assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, lengthOfLongestSubstring("pwwkew"));

        assertEquals(0, lengthOfLongestSubstringNoMap(""));
        assertEquals(1, lengthOfLongestSubstringNoMap(" "));
        assertEquals(1, lengthOfLongestSubstringNoMap("a"));
        assertEquals(2, lengthOfLongestSubstringNoMap("aab"));
        assertEquals(3, lengthOfLongestSubstringNoMap("abcabcbb"));
        assertEquals(1, lengthOfLongestSubstringNoMap("bbbbb"));
        assertEquals(3, lengthOfLongestSubstringNoMap("pwwkew"));
    }
}