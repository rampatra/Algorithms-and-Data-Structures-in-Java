package com.rampatra.sorting;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/29/15
 * @time: 8:47 PM
 */
public class MergeSort {

    /**
     * Merge sort. Note that we are creating unnecessary arrays in each recursive
     * call. This makes the algorithm simple but it occupies more space. Look at
     * {@link MergeSortSpaceOptimized} instead.
     * <p/>
     * Time complexity:     O(n log n)
     * Space complexity:    O(n) (also needs O(log n) stack space as it is recursive)
     *
     * @param arr
     * @return
     */
    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) return arr;

        int[] x = mergeSort(Arrays.copyOfRange(arr, 0, arr.length / 2));
        int[] y = mergeSort(Arrays.copyOfRange(arr, arr.length / 2, arr.length));

        return merge(x, y);
    }

    /**
     * Merges two sorted arrays {@code a} and {@code b}.
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
            }
        }

        return sortedArray;
    }

    public static void main(String[] args) {
        int[] ar = new int[]{3, 5, 1, 6, 9, 8};
        System.out.println(Arrays.toString(ar));
        System.out.println(Arrays.toString(mergeSort(ar)));
    }
}
