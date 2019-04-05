package com.rampatra.dynamicprogramming;

import java.util.Arrays;

import static java.lang.System.out;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 9/10/15
 */
public class FibonacciNumbers {

    /**
     * Computes first {@code k} fibonacci numbers using
     * bottom-up DP approach.
     * <p/>
     * Time complexity: O(k)
     *
     * @param k
     */
    public static int[] getFirstKFibonacciNumbers(int k) {
        int[] fib = new int[k];
        int i = 1;
        while (i < k) {
            if (i == 1 || i == 2) {
                fib[i] = 1;
            } else {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
            i++;
        }
        return fib;
    }

    public static void main(String[] args) {
        out.println(Arrays.toString(getFirstKFibonacciNumbers(0)));
        out.println(Arrays.toString(getFirstKFibonacciNumbers(10)));
        out.println(Arrays.toString(getFirstKFibonacciNumbers(46)));
    }
}
