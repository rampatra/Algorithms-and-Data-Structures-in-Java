package com.rampatra.arrays;

import com.rampatra.bits.TwoNonRepeatingElements;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 8/17/15
 * @time: 7:23 PM
 */
public class TwoRepeatingElements {

    /**
     * Finds the 2 repeating elements in an array {@param a} of 1 to n elements and n+2 length. This is
     * similar to {@link TwoNonRepeatingElements}.
     * <p/>
     * EXPLANATION:
     * Let the repeating numbers be X and Y, if we xor all the elements in the array and all integers from 1 to n,
     * then the result is X xor Y.
     * The 1’s in binary representation of X xor Y is corresponding to the different bits between X and Y.
     * Suppose that the kth bit of X xor Y is 1, we can xor all the elements in the array and all integers
     * from 1 to n, whose kth bits are 1. The result will be one of X and Y.
     *
     * @param a
     * @return
     */
    public static int[] getTwoRepeatingElements(int[] a) {
        int xor = a[0];
        int rightMostSetBit;
        int x = 0, y = 0;

        for (int i = 1; i < a.length; i++) {
            xor ^= a[i];
        }

        for (int i = 1; i <= a.length - 2; i++) {
            xor ^= i;
        }

        // now xor is X xor Y, therefore find any of its set bit
        rightMostSetBit = xor & ~(xor - 1);

        for (int i = 0; i < a.length; i++) {
            // one number will have a set bit at that position and other wouldn't
            if ((a[i] & rightMostSetBit) == 0) {
                x ^= a[i];
            } else {
                y ^= a[i];
            }
        }

        for (int i = 1; i <= a.length - 2; i++) {
            // one number will have a set bit at that position and other wouldn't
            if ((i & rightMostSetBit) == 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }

        return new int[]{x, y};
    }

    /**
     * The algorithm is simple. We use index of the array to track repeating elements.
     * Once we encounter a element lets say 2 then we make the element in 2nd index -ve just
     * to mark that we have encountered 2. When we encounter 2 again and see that 2nd index
     * is already -ve we conclude that 2 is repeated.
     * <p>
     * Similar to {@link DuplicatesInArray#findDuplicatesInArray(int[])}.
     *
     * @param a
     * @return
     */
    public static int[] findTwoRepeatingElements(int[] a) {
        int[] repeatingElements = new int[2];

        for (int i = 0, j = 0; i < a.length; i++) {
            if (a[Math.abs(a[i])] >= 0) {
                a[Math.abs(a[i])] = -a[Math.abs(a[i])];
            } else {
                repeatingElements[j++] = Math.abs(a[i]);
            }
        }
        return repeatingElements;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTwoRepeatingElements(new int[]{4, 2, 4, 5, 2, 3, 1})));
        System.out.println(Arrays.toString(getTwoRepeatingElements(new int[]{2, 4, 5, 2, 3, 1, 6, 7, 7})));
        System.out.println(Arrays.toString(getTwoRepeatingElements(new int[]{1, 2, 1, 2})));
        System.out.println("========");
        System.out.println(Arrays.toString(findTwoRepeatingElements(new int[]{4, 2, 4, 5, 2, 3, 1})));
        System.out.println(Arrays.toString(findTwoRepeatingElements(new int[]{2, 4, 5, 2, 3, 1, 6, 7, 7})));
        System.out.println(Arrays.toString(findTwoRepeatingElements(new int[]{1, 2, 1, 2})));
    }
}
