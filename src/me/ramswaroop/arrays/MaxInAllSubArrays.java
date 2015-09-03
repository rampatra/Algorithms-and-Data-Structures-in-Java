package me.ramswaroop.arrays;

import me.ramswaroop.common.MaxHeap;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 9/3/15
 * @time: 9:21 PM
 */
public class MaxInAllSubArrays {

    /**
     * Finds the maximum element in each and every sub-array
     * in {@param a} of size {@param k}.
     * <p/>
     * Time complexity: O(n^2)
     *
     * @param a
     * @param k
     */
    public static int[] maxInAllSubArraysOfSizeKNaive(int[] a, int k) {
        int[] maxElements = new int[a.length - k + 1];
        int[] kElements;

        for (int i = 0; i <= a.length - k; i++) {
            kElements = Arrays.copyOfRange(a, i, i + k);
            /**
             * maxHeapify() can't be used because to call maxHeapify() on i, left(i) and right (i) should 
             * already satisfy the max heap property which isn't true in this case.
             */
            MaxHeap.buildMaxHeap(kElements);
            maxElements[i] = kElements[0];
        }

        return maxElements;
    }

    public static void main(String a[]) {
        System.out.println(Arrays.toString(maxInAllSubArraysOfSizeKNaive(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6}, 3)));
        System.out.println(Arrays.toString(maxInAllSubArraysOfSizeKNaive(new int[]{8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, 4)));
    }
}
