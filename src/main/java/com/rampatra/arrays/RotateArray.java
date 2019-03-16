package com.rampatra.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/28/15
 * @time: 10:53 AM
 */
public class RotateArray {

    /**
     * Naive approach which stores the elements to be shifted in a temp array.
     * Time complexity: O(n)
     * Space complexity: O(k)
     *
     * @param a
     * @param k
     */
    public static void rotateNaiveApproach(int[] a, int k) {
        int[] temp = new int[k];
        int i, j;
        // store elements to be shifted in temp array
        for (i = 0; i < k; i++) {
            temp[i] = a[i];
        }
        // shift elements to left
        for (j = 0; i < a.length; i++, j++) {
            a[j] = a[i];
        }
        // move elements to end
        for (i = 0; j < a.length; i++, j++) {
            a[j] = temp[i];
        }
    }

    /**
     * Reversal algorithm for array rotation.
     * <p/>
     * Example:
     * For arr[] = [1, 2, 3, 4, 5, 6, 7], k = 2 and arr.length = 7
     * A = [1, 2] and B = [3, 4, 5, 6, 7]
     * Reverse A, we get ArB = [2, 1, 3, 4, 5, 6, 7]
     * Reverse B, we get ArBr = [2, 1, 7, 6, 5, 4, 3]
     * Reverse all, we get (ArBr)r = [3, 4, 5, 6, 7, 1, 2]
     * NOTE: Ar = Reverse of A
     * See: http://www.geeksforgeeks.org/program-for-array-rotation-continued-reversal-algorithm/
     *
     * @param a
     * @param k
     */
    public static void rotateReversal(int[] a, int k) {
        ReverseArray.reverseRecursive(a, 0, k - 1);
        ReverseArray.reverseRecursive(a, k, a.length - 1);
        ReverseArray.reverseRecursive(a, 0, a.length - 1);
    }

    /**
     * Juggling algorithm for array rotation.
     * See: http://www.geeksforgeeks.org/array-rotation/
     *
     * @param a
     * @param k
     */
    public static void rotateGCD(int[] a, int k) {
        int gcd = gcd(a.length, k), temp, i, j, p;

        for (i = 0; i < gcd; i++) {
            temp = a[i];
            j = i;
            while (true) {
                p = j + k;
                if (p >= a.length)
                    p = p - a.length;
                if (p == i)
                    break;
                a[j] = a[p];
                j = p;
            }
            a[j] = temp;
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(ar));
        rotateNaiveApproach(ar, 2);
        System.out.println(Arrays.toString(ar));
        rotateGCD(ar, 2);
        System.out.println(Arrays.toString(ar));
        rotateReversal(ar, 2);
        System.out.println(Arrays.toString(ar));
    }
}
