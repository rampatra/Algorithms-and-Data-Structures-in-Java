package com.leetcode.hashtables;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Level: Easy
 * Link: https://leetcode.com/problems/isomorphic-strings/
 * Description:
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No
 * two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 *
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 *
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 *
 * Note:
 * You may assume both s and t have the same length.
 *
 * @author rampatra
 * @since 2019-08-11
 */
public class IsomorphicStrings {

    /**
     * Time Complexity:
     * Space Complexity:
     * Runtime: <a href="https://leetcode.com/submissions/detail/250762080/">8 ms</a>.
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic(String s, String t) {

        Map<Character, Character> sToTCharMap = new HashMap<>();
        Map<Character, Character> tToSCharMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char chFromS = s.charAt(i);
            char chFromT = t.charAt(i);
            if (sToTCharMap.get(chFromS) == null && tToSCharMap.get(chFromT) == null) {
                sToTCharMap.put(chFromS, chFromT);
                tToSCharMap.put(chFromT, chFromS);
            }
            Character mappedChFromSToT = sToTCharMap.get(chFromS);
            if (mappedChFromSToT == null || mappedChFromSToT != chFromT) {
                return false;
            }
        }

        return true;
    }

    /**
     * Time Complexity:
     * Space Complexity:
     * Runtime: <a href="https://leetcode.com/submissions/detail/250761329/">3 ms</a>.
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphicWithoutMaps(String s, String t) {
        int[] charMap = new int[512];
        for (int i = 0; i < s.length(); i++) {
            char chFromS = s.charAt(i);
            char chFromT = t.charAt(i);
            if (charMap[chFromS] != charMap[chFromT + 256]) {
                return false;
            }
            charMap[chFromS] = charMap[chFromT + 256] = i + 1;
        }

        return true;
    }

    public static void main(String[] args) {
        assertTrue(isIsomorphic("egg", "add"));
        assertFalse(isIsomorphic("foo", "bar"));
        assertTrue(isIsomorphic("paper", "title"));
        assertFalse(isIsomorphic("ab", "aa"));

        assertTrue(isIsomorphicWithoutMaps("egg", "add"));
        assertFalse(isIsomorphicWithoutMaps("foo", "bar"));
        assertTrue(isIsomorphicWithoutMaps("paper", "title"));
        assertFalse(isIsomorphicWithoutMaps("ab", "aa"));
    }
}
