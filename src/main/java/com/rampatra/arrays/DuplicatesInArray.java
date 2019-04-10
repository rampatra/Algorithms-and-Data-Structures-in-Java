package com.rampatra.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 8/21/15
 */
public class DuplicatesInArray {

    /**
     * Given an array of n elements which contains elements from 0 to n-1, with any of
     * these numbers appearing any number of times. Find these repeating numbers in O(n)
     * time complexity.
     * <p/>
     * For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be
     * 1, 3 and 6.
     * <p/>
     * EXPLANATION:
     * The algorithm is simple. We use index of the array to track repeating elements.
     * Once we encounter a element lets say 2 then we make the element in 2nd index -ve just
     * to mark that we have encountered 2. When we encounter 2 again and see that 2nd index
     * is already -ve we conclude that 2 is repeated.
     * <p/>
     * Similar to {@link TwoRepeatingElements#findTwoRepeatingElements(int[])}.
     *
     * @param a
     * @return
     */
    public static int[] findDuplicatesInArray(int[] a) {
        int[] duplicates = new int[a.length];

        for (int i = 0, j = 0; i < a.length; i++) {
            if (a[Math.abs(a[i])] >= 0) {
                a[Math.abs(a[i])] = -a[Math.abs(a[i])];
            } else {
                duplicates[j++] = Math.abs(a[i]);
            }
        }
        return duplicates;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findDuplicatesInArray(new int[]{1, 1, 2, 3, 1, 3, 6, 6})));
        // doesn't work if 0 is present in array (as -0 makes no sense but we can modify the algorithm to handle 0)
        System.out.println(Arrays.toString(findDuplicatesInArray(new int[]{1, 0, 1, 2, 3, 1, 3, 6, 6})));
        System.out.println(Arrays.toString(findDuplicatesInArray(new int[]{0, 0, 1, 2, 3, 1, 3, 6, 6})));
    }
}
