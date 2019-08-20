package com.leetcode.arrays.binarysearch;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Medium
 * Link: https://leetcode.com/problems/powx-n/
 * Description:
 * Implement pow(x, n), which calculates x raised to the power n (x^n).
 * <p>
 * Example 1:
 * Input: 2.00000, 10
 * Output: 1024.00000
 * <p>
 * Example 2:
 * Input: 2.10000, 3
 * Output: 9.26100
 * <p>
 * Example 3:
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/22 = 1/4 = 0.25
 * <p>
 * Note:
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 *
 * @author rampatra
 * @since 2019-08-19
 */
public class PowXN {

    /**
     * In this approach we iterate n times and keep multiplying x with x.
     * Runtime: <a href="https://leetcode.com/submissions/detail/253075786/">Time limit exceeded</a>.
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPowNaive(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double res = x;
        int absN = Math.abs(n);
        for (int i = 1; i < absN; i++) {
            res *= x;
        }
        return n < 0 ? 1 / res : res;
    }


    /**
     * In this approach, we iterate log n times. We omit half of n each time. When n is odd, we store whatever product
     * we have calculated so far in the final result.
     * <p>
     * Runtime: <a href="https://leetcode.com/submissions/detail/253276630/">1 ms</a>.
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        double res = 1;
        long absN = Math.abs((long) n); // used a long so that `absN / 2` doesn't overflow

        while (absN > 0) {
            if (absN % 2 == 1) res *= x; // store whatever we have calculated so far in the final result
            x *= x;
            absN /= 2;
        }
        return n < 0 ? 1 / res : res;
    }

    public static void main(String[] args) {
        assertEquals(1024.0, myPowNaive(2.0, 10));
        assertEquals(0.25, myPowNaive(2.0, -2));
        assertEquals(0.0, myPowNaive(0.00001, 2147483647));

        assertEquals(1024.0, myPow(2.0, 10));
        assertEquals(0.25, myPow(2.0, -2));
        assertEquals(0.0, myPow(0.00001, 2147483647));
    }
}
