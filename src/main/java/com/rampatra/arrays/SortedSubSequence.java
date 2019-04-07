package com.rampatra.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 10/12/15
 */
public class SortedSubSequence {

    /**
     * Finds 3 elements such that a[i] < a[j] < a[k] and i < j < k in O(n) time
     * in an array of n integers. If there are multiple such triplets, then prints any
     * one of them.
     * <p>
     * Algorithm:
     * 1) Create an auxiliary array smaller[0..n-1]. smaller[i] should store the index of a number which is smaller than arr[i] and is on left side of arr[i]. smaller[i] should contain -1 if there is no such element.
     * 2) Create another auxiliary array greater[0..n-1]. greater[i] should store the index of a number which is greater than arr[i] and is on right side of arr[i]. greater[i] should contain -1 if there is no such element.
     * 3) Finally traverse both smaller[] and greater[] and find the index i for which both smaller[i] and greater[i] are not -1.
     *
     * @param arr
     */
    public static void printSortedSubSequenceOfSize3(int[] arr) {
        int len = arr.length, min = arr[0], max = arr[len - 1];

        int[] smaller = new int[len], larger = new int[len];

        smaller[0] = -1;
        for (int i = 1; i < len; i++) {
            if (arr[i] < min) {
                smaller[i] = -1;
                min = arr[i];
            } else {
                smaller[i] = min;
            }
        }

        larger[len - 1] = -1;
        for (int i = len - 2; i >= 0; i--) {
            if (arr[i] > max) {
                larger[i] = -1;
                max = arr[i];
            } else {
                larger[i] = max;
            }
        }

        for (int i = 0; i < len; i++) {
            if (smaller[i] != -1 && larger[i] != -1) {
                System.out.println(smaller[i] + "," + arr[i] + "," + larger[i]);
                break;
            }
        }

    }

    public static void main(String[] args) {
        printSortedSubSequenceOfSize3(new int[]{12, 11, 10, 5, 6, 2, 30});
        printSortedSubSequenceOfSize3(new int[]{1, 2, 3, 4});
        printSortedSubSequenceOfSize3(new int[]{4, 3, 2, 1});
    }
}
