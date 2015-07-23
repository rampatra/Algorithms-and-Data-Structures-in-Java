package me.ramswaroop.arrays;

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
     * pivot element to its right.
     *
     * @param ar
     * @param low
     * @param high
     * @return
     */
    public static int partition(int[] ar, int low, int high) {
        int pivot = high, temp;

        for (int i = low; i < high; i++) {
            /**
             * if ith element is smaller than pivot element then
             * swap it with the last larger element known.
             */
            if (ar[i] < ar[pivot]) {
                temp = ar[low];
                ar[low] = ar[i];
                ar[i] = temp;
                low++;
            }
        }

        // place the pivot element in its correct position
        temp = ar[low];
        ar[low] = ar[pivot];
        ar[pivot] = temp;

        return low;
    }

    /**
     * Recursive Quick sort.
     * NOTE: This function is tail-recursive.
     * <p/>
     * Time complexity:
     * Best Case:   O(nlogn)
     * Worst Case:  O(n*n)
     *
     * @param ar
     * @param low
     * @param high
     */
    public static void quickSort(int[] ar, int low, int high) {
        if (low < high) {
            int partition = partition(ar, low, high);
            quickSort(ar, low, partition - 1);
            quickSort(ar, partition + 1, high);
        }
    }

    public static void main(String a[]) {
        int[] ar = {3, 2, 1, 6, 4, 9, 7, 8};
        System.out.println(Arrays.toString(ar));
        quickSort(ar, 0, ar.length - 1);
        System.out.println(Arrays.toString(ar));
    }
}
