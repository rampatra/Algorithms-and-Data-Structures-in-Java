package com.rampatra.sorting;

import java.util.Arrays;

/**
 * @author rampatra
 * @since 13/11/2018
 */
public class MergeSortSpaceOptimized {

    /**
     * This is entry point. You can call this method to sort
     * an array {@code a}.
     *
     * @param a array to be sorted
     */
    public static void mergeSort(int[] a) {
        mergeSort(a, new int[a.length], 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int[] helper, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2; // to prevent overflow you can instead do: mid = low + (high - low) / 2

            mergeSort(a, helper, low, mid);
            mergeSort(a, helper, mid + 1, high);

            merge(a, helper, low, mid, high);
        }
    }

    private static void merge(int[] a, int[] helper, int low, int mid, int high) {
        // have a helper array from which you will choose numbers and finally place it in a
        for (int i = low; i <= high; i++) {
            helper[i] = a[i];
        }

        int helperLeft = low;
        int helperRight = mid + 1;
        int current = low;

        // check left half of the helper array with the right half
        while (helperLeft <= mid && helperRight <= high) {
            if (helper[helperLeft] < helper[helperRight]) {
                a[current++] = helper[helperLeft++];
            } else {
                a[current++] = helper[helperRight++];
            }
        }

        // copy the left half of the helper array and not the right
        // half as the right half is already there in array a
        for (int i = helperLeft; i <= mid; i++) {
            a[current++] = helper[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 6, 8, 9, 1, 2, 4};
        System.out.println(Arrays.toString(a));
        mergeSort(a);
        System.out.println(Arrays.toString(a));
        a = new int[]{5, 8, 1, 2, 5, 3, 0, 1, 2, 4};
        System.out.println(Arrays.toString(a));
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }
}
