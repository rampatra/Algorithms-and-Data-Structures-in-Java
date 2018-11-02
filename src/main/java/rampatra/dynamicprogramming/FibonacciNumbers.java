package rampatra.dynamicprogramming;

import java.util.Arrays;

import static java.lang.System.out;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 9/10/15
 * @time: 3:57 PM
 */
public class FibonacciNumbers {

    /**
     * Computes first {@param k} fibonacci numbers using
     * bottom-up DP approach.
     * <p/>
     * Time complexity: O(k)
     *
     * @param k
     */
    public static int[] getFirstKFibonacciNumbers(int k) {
        int[] fib = new int[k + 1];
        int i = 1;
        while (i <= k) {
            if (i == 1 || i == 2) {
                fib[i] = 1;
            } else {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
            i++;
        }
        return fib;
    }

    public static void main(String a[]) {
        out.println(Arrays.toString(getFirstKFibonacciNumbers(0)));
        out.println(Arrays.toString(getFirstKFibonacciNumbers(10)));
        out.println(Arrays.toString(getFirstKFibonacciNumbers(46)));
    }
}
