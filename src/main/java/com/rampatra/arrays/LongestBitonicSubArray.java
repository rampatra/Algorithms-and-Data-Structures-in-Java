package com.rampatra.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 9/18/15
 * @time: 5:10 PM
 */
public class LongestBitonicSubArray {

    /**
     * Returns the length of the longest bitonic sub-array in
     * array {@param a}.
     * <p/>
     * A subarray A[i … j] is bitonic if there is a k with i <= k <= j such
     * that A[i] <= A[i + 1] ... <= A[k] >= A[k + 1] >= ... A[j – 1] > = A[j].
     *
     * @param a
     * @return
     */
    public static int getLongestBitonicSubArrayLength(int[] a) {
        int len = a.length;
        int bitonicLength;
        int[] increasingSequence = new int[len];
        int[] decreasingSequence = new int[len];

        increasingSequence[0] = 1; // stores the length of the increasing sequence so far 
        decreasingSequence[len - 1] = 1; // stores the length of the decreasing sequence so far

        for (int i = 1; i < len; i++) {
            if (a[i] > a[i - 1]) {
                increasingSequence[i] = increasingSequence[i - 1] + 1;
            } else {
                increasingSequence[i] = 1;
            }
        }

        for (int i = len - 2; i >= 0; i--) {
            if (a[i] > a[i + 1]) {
                decreasingSequence[i] = decreasingSequence[i + 1] + 1;
            } else {
                decreasingSequence[i] = 1;
            }
        }

        bitonicLength = increasingSequence[0] + decreasingSequence[0] - 1;
        for (int i = 0; i < len; i++) {
            if ((increasingSequence[i] + decreasingSequence[i] - 1) > bitonicLength) {
                bitonicLength = increasingSequence[i] + decreasingSequence[i] - 1;
            }
        }

        return bitonicLength;
    }

    public static void main(String[] args) {
        System.out.println(getLongestBitonicSubArrayLength(new int[]{1, 2, 5, 4, 3}));
        System.out.println(getLongestBitonicSubArrayLength(new int[]{12, 4, 78, 90, 45, 23}));
        System.out.println(getLongestBitonicSubArrayLength(new int[]{10, 20, 30, 40}));
        System.out.println(getLongestBitonicSubArrayLength(new int[]{40, 30, 20, 10}));
        System.out.println(getLongestBitonicSubArrayLength(new int[]{10}));
    }
}
