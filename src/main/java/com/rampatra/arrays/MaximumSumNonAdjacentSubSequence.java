package com.rampatra.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/29/15
 * @time: 9:18 AM
 */
public class MaximumSumNonAdjacentSubSequence {

    /**
     * Given an array of positive numbers, finds the maximum sum of a sub-sequence
     * with the constraint that no 2 numbers in the sub-sequence should be adjacent
     * in the array.
     * <p/>
     * Example:
     * 1) 3 2 7 10 should return 13 (sum of 3 and 10)
     * 2) 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).
     * <p>
     * Here we maintain 2 variables incl and excl which is max sum till now (satisfying the constraint)
     * including the current element and excluding the current element respectively.
     *
     * @param a
     * @return
     */
    public static int maximumSumNonAdjacentSubSequence(int[] a) {
        int incl = a[0], excl = 0, prevIncl = incl; // incl is max sum including the current element
        // and excl is max sum excluding the current element
        for (int i = 1; i < a.length; i++) {
            incl = excl + a[i]; // because we have to exclude the previous element if we consider the current element
            excl = Math.max(prevIncl, excl); // we are excluding the current element so we can consider the previous element or dont
            prevIncl = incl;
        }
        return Math.max(incl, excl);
    }

    public static void main(String[] args) {
        System.out.println(maximumSumNonAdjacentSubSequence(new int[]{3, 2, 7, 10}));
        System.out.println(maximumSumNonAdjacentSubSequence(new int[]{3, 2, 5, 10, 7}));
    }
}
