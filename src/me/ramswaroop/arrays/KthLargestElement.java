package me.ramswaroop.arrays;

import me.ramswaroop.common.Heap;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 8/1/15
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
        while (true) {
            Heap.buildMaxHeap(a);
            if (k == 1) break;

            Heap.swap(a, 0, a.length - 1);
            a = Arrays.copyOfRange(a, 0, a.length - 1);
            k--;
        }

        return a[0];
    }

    public static void main(String a[]) {
        System.out.println(getKthLargestElementNaive(new int[]{2, 4, 5, 7, 1, 8, 9}, 3));
        System.out.println(getKthLargestElement(new int[]{2, 4, 5, 7, 1, 8, 9}, 3));
    }
}
