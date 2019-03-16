package com.rampatra.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 5/28/15
 * @time: 4:34 PM
 */

/**
 * You are given a list of n-1 integers and these integers are in the
 * range of 1 to n. There are no duplicates in list. One of the integers
 * is missing in the list. Write an efficient code to find the missing integer.
 */
public class MissingNumber {

    public static int missingNumber(int a[], int n) {
        int sum = n * (n + 1) / 2;
        int arraySum = 0;

        for (int i = 0; i < a.length; i++) {
            arraySum += a[i];
        }
        return sum - arraySum;
    }

    /**
     * Using XOR:
     * 1) XOR all the array elements, let the result of XOR be X1.
     * 2) XOR all numbers from 1 to n, let XOR be X2.
     * 3) XOR of X1 and X2 gives the missing number.
     *
     * @param a
     * @param n
     * @return
     */
    public static int missingNumberUsingXOR(int a[], int n) {
        int nXOR = 0, arrayXOR = 0;

        for (int i = 1; i <= n; i++) {
            nXOR ^= i;
        }

        for (int i = 0; i < a.length; i++) {
            arrayXOR ^= a[i];
        }
        return nXOR ^ arrayXOR;
    }

    public static void main(String[] args) {
        System.out.println("Missing No: " + missingNumber(new int[]{2, 3, 1, 4, 6, 7, 8}, 8));
        System.out.println("Missing No using XOR: " + missingNumberUsingXOR(new int[]{2, 3, 1, 4, 6, 7, 8}, 8));
    }
}
