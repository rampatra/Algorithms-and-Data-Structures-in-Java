package com.leetcode.maps.slidingwindow;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Hard
 * Link: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * Description:
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 * <p>
 * Example 1:
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: T is "ece" which its length is 3.
 * <p>
 * Example 2:
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: T is "aa" which its length is 2.
 *
 * @author rampatra
 * @since 2019-08-09
 */
public class LongestSubstringWithKDistinctCharacters {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(k), as we keep at most k characters in the hash table
     *
     * @param str
     * @param k
     * @return
     */
    public static int lengthOfLongestSubstringKDistinct(String str, int k) {
        int length = 0;
        Map<Character, Integer> letterCountInWindow = new HashMap<>();

        int i = 0; // start of window
        int j = i; // end of window

        while (j < str.length()) {
            char ch = str.charAt(j);

            letterCountInWindow.put(ch, letterCountInWindow.getOrDefault(ch, 0) + 1);

            // when number of distinct characters in the window exceeds k:
            // - update length
            // - remove the first character in the window or reduce its count if the window had more than one of this character
            // - lastly, move the window forward
            if (letterCountInWindow.keySet().size() > k) {
                char firstChar = str.charAt(i);
                int firstCharCount = letterCountInWindow.get(firstChar);
                if (firstCharCount > 1) {
                    letterCountInWindow.put(firstChar, firstCharCount - 1);
                } else {
                    letterCountInWindow.remove(firstChar);
                }
                length = Math.max(length, j - i);
                i++;
            }
            j++;
        }

        return length == 0 ? j - i : length;
    }

    public static void main(String[] args) {
        assertEquals(3, lengthOfLongestSubstringKDistinct("eceba", 2));
        assertEquals(7, lengthOfLongestSubstringKDistinct("eceeeeeba", 2));
        assertEquals(2, lengthOfLongestSubstringKDistinct("abcdef", 2));
        assertEquals(1, lengthOfLongestSubstringKDistinct("a", 1));
        assertEquals(2, lengthOfLongestSubstringKDistinct("aa", 1));
        assertEquals(3, lengthOfLongestSubstringKDistinct("aaa", 1));
        assertEquals(0, lengthOfLongestSubstringKDistinct("aa", 0));
    }
}
