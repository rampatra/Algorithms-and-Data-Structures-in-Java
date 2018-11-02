package com.rampatra.arrays.sorting;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 7/21/15
 * @time: 4:12 PM
 * @see: http://www.csanimated.com/animation.php?t=Quicksort
 */
public class QuickSort {

    /**
     * In-place partition method which moves all elements smaller than
     * the pivot element to its left and all elements larger than the
     * pivot element to its right and finally places the pivot element
     * at its correct position.
     *
     * @param ar
     * @param startIndex
     * @param endIndex
     * @return position of the pivot element
     */
    public static int partition(int[] ar, int startIndex, int endIndex) {
        int pivot = endIndex, temp;

        for (int i = startIndex; i < endIndex; i++) {
            /**
             * if ith element is smaller than pivot element then
             * swap it with the last larger element known
             */
            if (ar[i] < ar[pivot]) {
                // swap a[startIndex] with a[i]
                temp = ar[startIndex];
                ar[startIndex] = ar[i];
                ar[i] = temp;
                startIndex++;
            }
        }

        // place the pivot element in its correct position
        temp = ar[startIndex];
        ar[startIndex] = ar[pivot];
        ar[pivot] = temp;

        return startIndex;
    }

    /**
     * Recursive Quick sort.
     * NOTE: This function is tail-recursive (doesn't use extra stack space per recursive call in many
     * programming languages but not in Java as it doesn't support tail-recursive optimization).
     * <p/>
     * Time complexity:
     * Best Case:   O(nlogn)
     * Worst Case:  O(n*n)
     *
     * @param ar
     * @param startIndex
     * @param endIndex
     */
    public static void quickSort(int[] ar, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int partition = partition(ar, startIndex, endIndex);
            quickSort(ar, startIndex, partition - 1);
            quickSort(ar, partition + 1, endIndex);
        }
    }

    /**
     * Wrapper method to quick sort the entire array.
     *
     * @param a
     */
    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public static void main(String a[]) {
        int[] ar = {3, 2, 1, 6, 4, 9, 7, 8};
        System.out.println(Arrays.toString(ar));
        quickSort(ar);
        System.out.println(Arrays.toString(ar));
    }
}
