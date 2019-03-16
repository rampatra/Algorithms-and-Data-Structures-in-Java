package com.rampatra.sorting;

import java.util.Arrays;

/**
 * Wiggle Sort: Arrange the elements in the array such that elements in
 * even indices are greater than or equal to its neighbouring elements
 * and elements in odd indices are less than or equal to its neighbouring
 * elements. In other words, all elements in array {@code a} are arranged
 * such that, a[i-1] <= a[i] => a[i+1]
 * <p>
 * Ex: {1, 3, 2, 5, 4, 6}
 *
 * @author rampatra
 * @version 01/09/2016
 */
public class WiggleSort {

    public static int[] wiggleSortEasyWay(int[] a) {
        a = MergeSort.mergeSort(a);
        for (int i = 1; i < a.length; i += 2) {
            swap(a, i, i + 1);
        }
        return a;
    }

    private static void swap(int[] a, int index1, int index2) {
        if (index2 >= a.length) return;

        a[index1] = a[index1] + a[index2];
        a[index2] = a[index1] - a[index2];
        a[index1] = a[index1] - a[index2];
    }

    public static void main(String[] args) {
        int[] ar = {3, 5, 6, 7, 8, 1, 2};
        System.out.println(Arrays.toString(wiggleSortEasyWay(ar)));
        int[] ar1 = {3, 5, 6, 7, 2, 1};
        System.out.println(Arrays.toString(wiggleSortEasyWay(ar1)));
        int[] ar2 = {3, 5, 6, 7, 8, 1};
        System.out.println(Arrays.toString(wiggleSortEasyWay(ar2)));
        int[] ar3 = {3, 5, 6, 5, 8, 1};
        System.out.println(Arrays.toString(wiggleSortEasyWay(ar3)));
    }
}
