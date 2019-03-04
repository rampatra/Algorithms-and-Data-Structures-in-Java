package com.ctci.recursionanddp;

/**
 * The fabled fibonacci numbers problem with three different solutions.
 * The {@link FibonacciNumber#fibonacciBottomUpOptimized(int)} version is the most optimized among all w.r.t space
 * and time. See {@link com.rampatra.dynamicprogramming.FibonacciNumbers} for Fibonacci series.
 *
 * @author rampatra
 * @since 2019-02-26
 */
public class FibonacciNumber {

    private static int fibonacciTopDown(int n, int[] memo) {
        if (n == 0 || n == 1) return n;

        if (memo[n] != 0) {
            return memo[n];
        } else {
            memo[n] = fibonacciTopDown(n - 1, memo) + fibonacciTopDown(n - 2, memo);
            return memo[n];
        }
    }

    private static int fibonacciBottomUp(int n) {
        if (n == 0 || n == 1) return n;

        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    private static int fibonacciBottomUpOptimized(int n) {
        if (n == 0 || n == 1) return n;

        int a = 0;
        int b = 1;
        int res = a + b;

        for (int i = 2; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(fibonacciTopDown(4, new int[5]));
        System.out.println(fibonacciBottomUp(4));
        System.out.println(fibonacciBottomUpOptimized(4));
        System.out.println("---");
        System.out.println(fibonacciTopDown(5, new int[6]));
        System.out.println(fibonacciBottomUp(5));
        System.out.println(fibonacciBottomUpOptimized(5));
        System.out.println("---");
        System.out.println(fibonacciTopDown(10, new int[11]));
        System.out.println(fibonacciBottomUp(10));
        System.out.println(fibonacciBottomUpOptimized(10));
    }
}