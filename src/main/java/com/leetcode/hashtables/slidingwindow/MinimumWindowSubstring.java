package com.leetcode.hashtables.slidingwindow;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Hard
 * Link: https://leetcode.com/problems/minimum-window-substring/
 * Description:
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in
 * complexity O(n).
 * <p>
 * Example:
 * <p>
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * <p>
 * Note:
 * - If there is no such window in S that covers all characters in T, return the empty string "".
 * - If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 *
 * @author rampatra
 * @since 2019-08-13
 */
public class MinimumWindowSubstring {

    /**
     * Sliding Window Approach (using map).
     *
     * Note:
     * If we know that the charset is rather small, we can replace the Map with an integer array as direct access table.
     *
     * Commonly used tables are:
     *
     * int[26] for Letters 'a' - 'z' or 'A' - 'Z'
     * int[128] for ASCII
     * int[256] for Extended ASCII
     *
     * Runtime: <a href="https://leetcode.com/submissions/detail/251862380/">22 ms</a>.
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {

        int left = 0; // start of window
        int right = 0; // end of window
        int begin = 0;
        int windowSize = Integer.MAX_VALUE;
        int charsInWindow = 0; // to check whether the window has all the characters in t with the required frequency

        // characters and their counts in t
        Map<Character, Integer> dictT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            dictT.put(ch, dictT.getOrDefault(ch, 0) + 1);
        }

        // characters and their counts in the window
        Map<Character, Integer> dictWindow = new HashMap<>();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            int rightCharCount;
            dictWindow.put(rightChar, (rightCharCount = dictWindow.getOrDefault(rightChar, 0) + 1));

            // once the window has a character in t with the required frequency, increment charsInWindow
            if (dictT.get(rightChar) != null && dictT.get(rightChar).equals(rightCharCount)) {
                charsInWindow++;
            }

            // once the window has all characters in t with required frequency then shorten the window by moving the
            // left window forward until the window no longer has all characters of t
            while (left <= right && charsInWindow == dictT.size()) {
                if (right - left < windowSize) {
                    windowSize = right - left + 1;
                    begin = left;
                }

                char leftChar = s.charAt(left);
                Integer leftCharCount = dictWindow.get(leftChar);
                dictWindow.put(leftChar, leftCharCount - 1);

                if (dictT.get(leftChar) != null && leftCharCount - 1 < dictT.get(leftChar)) {
                    charsInWindow--;
                }
                left++;
            }
            right++;
        }

        return windowSize == Integer.MAX_VALUE ? "" : s.substring(begin, begin + windowSize);
    }

    public static void main(String[] args) {
        assertEquals("BANC", minWindow("ADOBECODEBANC", "ABC"));
        assertEquals("BAC", minWindow("ADOBECODEBAC", "ABC"));
        assertEquals("ba", minWindow("bba", "ab"));
        assertEquals("baca", minWindow("acbbaca", "aba"));
    }
}