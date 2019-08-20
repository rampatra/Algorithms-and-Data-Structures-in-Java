package com.leetcode.arrays.binarysearch;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Easy
 * Link: https://leetcode.com/problems/sqrtx/
 * Description:
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part
 * of the result is returned.
 *
 * Example 1:
 * Input: 4
 * Output: 2
 *
 * Example 2:
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 *
 * @author rampatra
 * @since 2019-08-19
 */
public class SqrtX {

    /**
     * Runtime: <a href="https://leetcode.com/submissions/detail/253282868/">1 ms</a>.
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long low = 1;
        long high = x / 2;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) high;
    }

    public static void main(String[] args) {
        assertEquals(2, mySqrt(8));
        assertEquals(3, mySqrt(9));
        assertEquals(46339, mySqrt(2147395599));
    }
}