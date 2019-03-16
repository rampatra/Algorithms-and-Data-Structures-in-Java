package com.rampatra.bits;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/7/15
 * @time: 2:46 PM
 * @link: http://www.geeksforgeeks.org/find-two-non-repeating-elements-in-an-array-of-repeating-elements/
 */
public class TwoNonRepeatingElements {

    /**
     * Finds the 2 non-repeating elements in an array of
     * repeating elements (all elements repeated twice
     * except 2 elements).
     *
     * @param a
     * @return
     */
    public static int[] getTwoNonRepeatingElementsInArray(int a[]) {
        int xor = 0, setBit, x = 0, y = 0;
        for (int i = 0; i < a.length; i++) {
            xor ^= a[i]; // XOR all array elements
        }
        setBit = xor & ~(xor - 1); // get the rightmost set bit in XOR
        for (int i = 0; i < a.length; i++) {
            if ((a[i] & setBit) == 0) {
                x ^= a[i]; // one non-repeating element
            } else {
                y ^= a[i]; // other non-repeating element
            }
        }
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTwoNonRepeatingElementsInArray(new int[]{2, 3, 4, 2, 3, 4, 5, 6})));
    }
}

/**
 * EXPLANATION:
 * Consider input arr[] = {2, 4, 7, 9, 2, 4}
 * 1) Get the XOR of all the elements.
 * xor = 2^4^7^9^2^4 = 14 (1110)
 * 2) Get a number which has only one set bit of the xor.
 * Since we can easily get the rightmost set bit, let us use it.
 * set_bit_no = xor & ~(xor-1) = (1110) & ~(1101) = 0010
 * Now set_bit_no will have only set as rightmost set bit of xor.
 * 3) Now divide the elements in two sets and do xor of
 * elements in each set, and we get the non-repeating
 * elements 7 and 9. Please see implementation for this
 * step.
 */
