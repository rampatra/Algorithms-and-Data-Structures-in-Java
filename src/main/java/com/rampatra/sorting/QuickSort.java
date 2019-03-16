package com.rampatra.sorting;

import java.util.Arrays;

/**
 * The basic Quick Sort. See http://www.csanimated.com/animation.php?t=Quicksort to learn more.
 *
 * @author rampatra
 * @since 7/21/15
 */
public class QuickSort {

    /**
     * In-place partition method which moves all elements smaller than
     * the pivot element to its left and all elements larger than the
     * pivot element to its right and finally places the pivot element
     * at its correct position.
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return position of the pivot element
     */
    public static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = endIndex, temp;

        for (int i = startIndex; i < endIndex; i++) {
            // if ith element is smaller than pivot element then 
            // swap it with the last larger element known
            if (arr[i] < arr[pivot]) {
                // swap a[startIndex] with a[i]
                temp = arr[startIndex];
                arr[startIndex] = arr[i];
                arr[i] = temp;
                startIndex++;
            }
        }

        // place the pivot element in its correct position
        temp = arr[startIndex];
        arr[startIndex] = arr[pivot];
        arr[pivot] = temp;

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
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int partition = partition(arr, startIndex, endIndex);
            quickSort(arr, startIndex, partition - 1);
            quickSort(arr, partition + 1, endIndex);
        }
    }

    /**
     * Wrapper method to quick sort the entire array.
     *
     * @param arr the input array to sort
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] ar = {3, 2, 1, 6, 4, 9, 7, 8};
        System.out.println(Arrays.toString(ar));
        quickSort(ar);
        System.out.println(Arrays.toString(ar));
        
        System.out.println("------");
        
        ar = new int[]{3, 2, 6, 8, 4, 3, 7, 8};
        System.out.println(Arrays.toString(ar));
        quickSort(ar);
        System.out.println(Arrays.toString(ar));
        
        System.out.println("------");
        
        ar = new int[]{4, 4, 4, 4, 4, 4, 4};
        System.out.println(Arrays.toString(ar));
        quickSort(ar);
        System.out.println(Arrays.toString(ar));
        
        System.out.println("------");
        
        ar = new int[]{};
        System.out.println(Arrays.toString(ar));
        quickSort(ar);
        System.out.println(Arrays.toString(ar));
    }
}
