package com.leetcode.strings;

/**
 * Level: Easy
 * Problem Link: https://leetcode.com/problems/implement-strstr/
 * Problem Description:
 * Implement strStr(). Return the index of the first occurrence of needle in haystack, or -1 if needle
 * is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * @author rampatra
 * @since 2019-04-28
 */
public class StrStr {

    /**
     * Time complexity: O(m*n)
     * where,
     * m = length of haystack
     * n = length of needle
     * <p>
     * Runtime: <a href="https://leetcode.com/submissions/detail/225543896/">3 ms</a>.
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("leet", "e"));
        System.out.println(strStr("mississippi", "issip"));
        System.out.println(strStr("mississippi", "pi"));
        System.out.println(strStr("aaaa", "bba"));

        // edge cases
        System.out.println(strStr("aaa", "aaaa"));
        System.out.println(strStr("aaaa", ""));
        System.out.println(strStr("", "abc"));
        System.out.println(strStr("", ""));
    }
}
