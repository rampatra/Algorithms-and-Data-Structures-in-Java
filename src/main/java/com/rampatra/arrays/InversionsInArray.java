package com.rampatra.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/29/15
 * @time: 8:37 PM
 */
public class InversionsInArray {

    static int inversionCount = 0;

    /**
     * Naive approach.
     * <p/>
     * INVERSION COUNT for an array indicates how far (or close) the array is from being
     * sorted. If array is already sorted then inversion count is 0. If array is sorted in
     * reverse order then inversion count is the maximum.
     * <p/>
     * Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
     * <p/>
     * Example:
     * The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
     *
     * @param a
     * @return
     */
    public static int getInversionCountNaiveApproach(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length - 2; i++) {
            for (int j = 1; j < a.length - 1; j++) {
                if (a[i] > a[j]) count++;
            }
        }
        return count;
    }

    /**
     * Optimized approach.
     * <p>
     * Explanation: In merge() if a[i] > b[j] then all elements in array a starting
     * from i are greater than b[j] which equals to the number of inversions for
     * the two sub-arrays.
     *
     * @param a
     * @return
     * @see: http://www.geeksforgeeks.org/counting-inversions/
     */
    public static int getInversionCount(int[] a) {
        mergeSort(a);
        return inversionCount;
    }

    /**
     * Merge sort.
     * <p/>
     * Time complexity:     O(n log n)
     * Space complexity:    O(n) (also needs O(log n) stack space as it is recursive)
     *
     * @param a
     * @return
     */
    public static int[] mergeSort(int[] a) {
        if (a.length == 1) return a;

        int[] x = mergeSort(Arrays.copyOfRange(a, 0, a.length / 2));
        int[] y = mergeSort(Arrays.copyOfRange(a, a.length / 2, a.length));

        return merge(x, y);
    }

    /**
     * Merges two sorted arrays {@param a} and {@param b}.
     *
     * @param a
     * @param b
     * @return
     */
    public static int[] merge(int[] a, int[] b) {
        int lenA = a.length, lenB = b.length, k = 0;
        int[] sortedArray = new int[lenA + lenB];

        for (int i = 0, j = 0; i < lenA || j < lenB; ) {
            if (j == lenB || (i < lenA && a[i] < b[j])) {
                sortedArray[k++] = a[i++];
            } else {
                sortedArray[k++] = b[j++];
                inversionCount += lenA - i;
            }
        }

        return sortedArray;
    }

    public static void main(String[] args) {
        System.out.println(getInversionCountNaiveApproach(new int[]{2, 4, 1, 3, 5}));
        System.out.println(getInversionCount(new int[]{2, 4, 1, 3, 5}));
    }
}
