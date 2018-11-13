package com.rampatra.arrays;

import com.rampatra.searching.BinarySearch;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 5/31/15
 * @time: 10:44 PM
 */
public class PivotedBinarySearch {

    /**
     * Search an element in a sorted pivoted array {@param a}.
     * <p/>
     * Example,
     * 1) For array [3,4,5,1,2] pivot is 5
     * 2) For array [6,7,8,5,4] pivot is 8
     *
     * @param a
     * @param n
     * @return
     */
    public static int pivotedBinarySearch(int a[], int n) {
        int pivot = findPivot(a, 0, a.length - 1);

        if (pivot == -1 || a[pivot] == n) {
            return pivot;
        } else if (n <= a[0]) {
            return BinarySearch.binarySearch(a, n, pivot + 1, a.length - 1);
        } else {
            return BinarySearch.binarySearch(a, n, 0, pivot - 1);
        }
    }

    /**
     * Finds the pivot element in array {@param a}. Pivot element is the only
     * element for which next element to it is smaller than it.
     *
     * @param a
     * @param low
     * @param high
     * @return
     */
    public static int findPivot(int a[], int low, int high) {
        if (low > high) return -1;
        if (low == high) return low;

        int mid = (low + high) / 2;

        if (a[mid] > a[mid + 1] && a[mid] > a[mid - 1]) {
            return mid;
        } else if (a[mid] > a[mid - 1] && a[mid] < a[mid + 1]) {
            return findPivot(a, mid + 1, a.length - 1);
        } else {
            return findPivot(a, 0, mid - 1);
        }
    }

    public static void main(String a[]) {
        System.out.println("Pivot: " + findPivot(new int[]{1, 2, 3, 4, 5}, 0, 3));
        System.out.println("Index: " + pivotedBinarySearch(new int[]{1, 2, 3, 4, 5}, 4));

        System.out.println("Pivot: " + findPivot(new int[]{5}, 0, 0));
        System.out.println("Index: " + pivotedBinarySearch(new int[]{5}, 5));
    }
}
