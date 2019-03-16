package com.rampatra.arrays;

import com.rampatra.sorting.MergeSort;
import com.rampatra.base.MaxHeap;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 8/1/15
 * @time: 11:26 PM
 */
public class KthLargestElement {

    /**
     * Naive approach.
     * <p/>
     * Time complexity: O(n log n)
     *
     * @param a
     * @param k
     * @return
     */
    public static int getKthLargestElementNaive(int[] a, int k) {
        if (k >= a.length) return -1;

        a = MergeSort.mergeSort(a);

        return a[a.length - k];
    }

    /**
     * Determines the kth largest element by building a max heap
     * k times removing the root each time.
     *
     * @param a
     * @param k
     * @return
     */
    public static int getKthLargestElement(int[] a, int k) {
        MaxHeap maxHeap = new MaxHeap(a);
        maxHeap.buildMaxHeap();
        while (true) {
            if (k == 1) break;

            maxHeap.extractMax();
            k--;
        }

        return maxHeap.findMax();
    }

    public static void main(String[] args) {
        int[] ar = new int[]{2, 4, 5, 7, 1, 8, 9};
        System.out.println(Arrays.toString(ar));
        System.out.println(getKthLargestElementNaive(ar, 3));
        System.out.println(Arrays.toString(ar));
        System.out.println(getKthLargestElement(ar, 3));
        System.out.println(Arrays.toString(ar));
    }
}
