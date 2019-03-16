package com.rampatra.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/27/15
 * @time: 12:15 PM
 */
public class MergeArrayOfNIntoArrayOfMPlusN {

    private static final int NA = -1;

    /**
     * Move non {@code NA} elements to the end of array leaving everything else unchanged.
     * <p/>
     * For example,
     * Input:   {2, NA, 7, NA, NA, 10, NA};
     * Output:  {2, NA, 7, NA, 2, 7, 10}
     *
     * @param arrayMPlusN
     */
    public static void moveElementsToEnd(int[] arrayMPlusN) {
        int i = arrayMPlusN.length - 1, j = i;
        for (; i >= 0; i--) {
            if (arrayMPlusN[i] != NA) {
                arrayMPlusN[j] = arrayMPlusN[i];
                j--;
            }
        }
    }

    /**
     * Merge {@param n} into {@param mPlusN}
     *
     * @param mPlusN
     * @param n
     */
    public static void merge(int[] mPlusN, int[] n) {
        moveElementsToEnd(mPlusN);

        int i = n.length, // current index in mPlusN[]
                j = 0, // current index in n[]
                k = 0; // current index in final result

        while (k < mPlusN.length) {
            if (j == n.length || (i < mPlusN.length && mPlusN[i] < n[j])) {
                mPlusN[k] = mPlusN[i];
                i++;
            } else {
                mPlusN[k] = n[j];
                j++;
            }
            k++;
        }
    }

    public static void main(String[] args) {
        int[] mPlusN = {2, NA, 12, NA, NA, 14, NA};
        int[] n = {5, 7, 8, 10};
        merge(mPlusN, n);
        System.out.println(Arrays.toString(mPlusN));
    }
}
