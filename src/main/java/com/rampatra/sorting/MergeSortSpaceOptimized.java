package com.rampatra.sorting;

import java.util.Arrays;

/**
 * @author rampatra
 * @since 13/11/2018
 */
public class MergeSortSpaceOptimized {

    /**
     * This is entry point. You can call this method to sort
     * an array {@code arr}.
     *
     * @param arr array to be sorted
     */
    public static void mergeSort(int[] arr) {
        mergeSort(arr, new int[arr.length], 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] helper, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2; // to prevent overflow you can instead do: mid = low + (high - low) / 2

            mergeSort(arr, helper, low, mid);
            mergeSort(arr, helper, mid + 1, high);

            merge(arr, helper, low, mid, high);
        }
    }

    private static void merge(int[] arr, int[] helper, int low, int mid, int high) {
        int k = low;

        /*
            Similar to merging two sorted arrays, i.e, merge two parts of arr[], arr[low..mid] and arr[mid+1..high],
            and store in helper[]
         */
        for (int i = low, j = mid + 1; i <= mid || j <= high; ) {
            if (i > mid) {
                helper[k++] = arr[j++];
            } else if (j > high) {
                helper[k++] = arr[i++];
            } else if (arr[i] <= arr[j]) {
                helper[k++] = arr[i++];
            } else if (arr[i] > arr[j]) {
                helper[k++] = arr[j++];
            }
        }

        // finally copy the sorted result from helper[] to arr[]
        for (int i = low; i <= high; i++) { // note: we can use System.arraycopy() for better performance
            arr[i] = helper[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 9, 1, 2, 4};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{5, 8, 1, 2, 5, 3, 0, 1, 2, 4};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
