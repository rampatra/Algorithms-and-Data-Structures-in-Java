package com.leetcode.math;

/**
 * Level: Easy
 * Problem Link: https://leetcode.com/problems/reverse-integer/
 * Problem Description:
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * Input: 123
 * Output: 321
 * <p>
 * Example 2:
 * Input: -123
 * Output: -321
 * <p>
 * Example 3:
 * Input: 120
 * Output: 21
 * <p>
 * Note: Assume we are dealing with an environment which could only store integers within the 32-bit signed
 * integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 0 when
 * the reversed integer overflows.
 *
 * @author rampatra
 * @since 2019-05-31
 */
public class ReverseInteger {

    /**
     * Reverses the input integer.
     * Time complexity: O(d)
     * where,
     * d = number of digits in num
     * <p>
     * Runtime: <a href="https://leetcode.com/submissions/detail/232679205/">1 ms</a>.
     *
     * @param num an integer.
     * @return the reverse of {@code num}.
     */
    private static int reverse(int num) {
        long reverse = 0;
        int pop;

        while (num != 0) {
            pop = num % 10;
            num = num / 10;
            reverse = reverse * 10 + pop;
        }

        return reverse < Integer.MIN_VALUE || reverse > Integer.MAX_VALUE ? 0 : (int) reverse;
    }

    public static void main(String[] args) {
        System.out.println(reverse(0));
        System.out.println(reverse(-0));
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(Integer.MAX_VALUE));
        System.out.println(reverse(Integer.MIN_VALUE));
    }
}