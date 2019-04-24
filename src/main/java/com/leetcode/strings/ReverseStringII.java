package com.leetcode.strings;

/**
 * Level: Easy
 * Problem: https://leetcode.com/problems/reverse-string-ii/
 *
 * @author rampatra
 * @since 2019-04-20
 */
public class ReverseStringII {

    /**
     * Time complexity: O(n)
     * where,
     * n = no. of characters in string
     * <p>
     * Runtime: <a href="https://leetcode.com/submissions/detail/223715011/">0 ms</a>.
     *
     * @param str
     * @param k
     * @return
     */
    public static String reverseStr(String str, int k) {
        char[] chars = str.toCharArray();
        int len = str.length();
        for (int i = 0; i < len; i += 2 * k) {
            reverse(chars, i, Math.min(len, i + k));
        }
        return new String(chars);
    }

    private static void reverse(char[] chars, int start, int end) {
        char temp;
        for (int i = start, j = end - 1; i < j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
        System.out.println(reverseStr("abcdef", 2));
        System.out.println(reverseStr("abcde", 2));
    }
}
