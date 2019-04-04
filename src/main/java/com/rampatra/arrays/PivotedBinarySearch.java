package com.rampatra.arrays;

import com.rampatra.searching.BinarySearch;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 5/31/15
 */
public class PivotedBinarySearch {

    /**
     * Search an element in a sorted pivoted array {@code arr}.
     * <p/>
     * Example,
     * 1) For array [3,4,5,1,2] pivot is 5
     * 2) For array [6,7,8,5,4] pivot is 8
     *
     * @param arr
     * @param n
     * @return
     */
    public static int pivotedBinarySearch(int[] arr, int n) {
        int pivot = findPivotIndex(arr, 0, arr.length - 1);

        if (pivot == -1 || arr[pivot] == n) {
            return pivot;
        } else if (n < arr[0]) {
            return BinarySearch.binarySearch(arr, n, pivot + 1, arr.length - 1);
        } else {
            return BinarySearch.binarySearch(arr, n, 0, pivot - 1);
        }
    }

    /**
     * Finds the pivot element in array {@code arr}. Pivot element is the only
     * element for which next element to it is smaller than it.
     *
     * @param arr
     * @param low
     * @param high
     * @return the index of the pivot element in the {@code arr}.
     */
    public static int findPivotIndex(int[] arr, int low, int high) {
        if (low > high) return -1;

        int mid = (low + high) / 2;

        if (mid == 0 || mid == arr.length - 1) return -1;
        
        if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
            return mid;
        } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
            return findPivotIndex(arr, mid + 1, arr.length - 1);
        } else {
            return findPivotIndex(arr, 0, mid - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Pivot: " + findPivotIndex(new int[]{3, 4, 5, 1, 2}, 0, 4));
        System.out.println("Index: " + pivotedBinarySearch(new int[]{3, 4, 5, 1, 2}, 5));

        System.out.println("Pivot: " + findPivotIndex(new int[]{1, 2, 3, 4, 5}, 0, 4));
        System.out.println("Index: " + pivotedBinarySearch(new int[]{1, 2, 3, 4, 5}, 4));

        System.out.println("Pivot: " + findPivotIndex(new int[]{5, 4, 3, 2, 1}, 0, 4));
        System.out.println("Index: " + pivotedBinarySearch(new int[]{5, 4, 3, 2, 1}, 4));

        System.out.println("Pivot: " + findPivotIndex(new int[]{5}, 0, -1));
        System.out.println("Index: " + pivotedBinarySearch(new int[]{5}, -1));
    }
}
