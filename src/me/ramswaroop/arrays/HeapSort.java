package me.ramswaroop.arrays;

import me.ramswaroop.common.MaxHeap;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 8/3/15
 * @time: 3:13 PM
 */
public class HeapSort {

    /**
     * Heapsort.
     * <p/>
     * Time complexity: O(n log n)
     *
     * @param a
     */
    public static void heapSort(int[] a) {
        MaxHeap.buildMaxHeap(a);

        for (int i = a.length - 1; i > 0; i--) {
            MaxHeap.swap(a, 0, i);
            MaxHeap.maxHeapify(a, 0, i);
        }
    }

    public static void main(String a[]) {
        int[] ar = new int[]{2, 5, 1, 7, 9, 4};
        System.out.println(Arrays.toString(ar));
        heapSort(ar);
        System.out.println(Arrays.toString(ar));
    }
}
