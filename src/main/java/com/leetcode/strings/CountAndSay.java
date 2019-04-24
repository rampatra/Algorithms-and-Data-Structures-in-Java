package com.leetcode.strings;

/**
 * Level: Easy
 * Problem: https://leetcode.com/problems/count-and-say/
 *
 * @author rampatra
 * @since 2019-04-20
 */
public class CountAndSay {

    /**
     * Time complexity:
     * Runtime: <a href="https://leetcode.com/submissions/detail/223728660/">1 ms</a>.
     *
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        if (n == 1) return "1";

        String s = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count++;

            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                sb.append(count);
                sb.append(s.charAt(i));
                count = 0;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
        System.out.println(countAndSay(10));
    }
}