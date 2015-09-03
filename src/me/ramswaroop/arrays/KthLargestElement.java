package me.ramswaroop.arrays;

import me.ramswaroop.arrays.sorting.MergeSort;
import me.ramswaroop.common.MaxHeap;

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
            MaxHeap.buildMaxHeap(a);
            if (k == 1) break;

            swap(a, 0, a.length - 1);
            a = Arrays.copyOfRange(a, 0, a.length - 1);
            k--;
        }

        return a[0];
    }

    private static void swap(int[] a, int firstIndex, int secondIndex) {
        a[firstIndex] = a[firstIndex] + a[secondIndex];
        a[secondIndex] = a[firstIndex] - a[secondIndex];
        a[firstIndex] = a[firstIndex] - a[secondIndex];
    }

    public static void main(String a[]) {
        int[] ar = new int[]{2, 4, 5, 7, 1, 8, 9};
        System.out.println(Arrays.toString(ar));
        System.out.println(getKthLargestElementNaive(ar, 3));
        System.out.println(Arrays.toString(ar));
        System.out.println(getKthLargestElement(ar, 3));
        System.out.println(Arrays.toString(ar));
    }
}
