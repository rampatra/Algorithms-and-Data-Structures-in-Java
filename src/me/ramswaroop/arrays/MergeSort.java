package me.ramswaroop.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 7/29/15
 * @time: 8:47 PM
 */
public class MergeSort {

    /**
     * Merge sort.
     * <p/>
     * Time complexity:     O(n log n)
     * Space complexity:    O(n) (also needs O(log n) stack space as it is recursive)
     *
     * @param a
     * @return
     */
    public static int[] mergeSort(int[] a) {
        if (a.length == 1) return a;

        int[] x = mergeSort(Arrays.copyOfRange(a, 0, a.length / 2));
        int[] y = mergeSort(Arrays.copyOfRange(a, a.length / 2, a.length));

        return merge(x, y);
    }

    /**
     * Merges two sorted arrays {@param a} and {@param b}.
     *
     * @param a
     * @param b
     * @return
     */
    public static int[] merge(int[] a, int[] b) {
        int lenA = a.length, lenB = b.length, k = 0;
        int[] sortedArray = new int[lenA + lenB];

        for (int i = 0, j = 0; i < lenA || j < lenB; ) {
            if (j == lenB || (i < lenA && a[i] < b[j])) {
                sortedArray[k++] = a[i++];
            } else {
                sortedArray[k++] = b[j++];
            }
        }

        return sortedArray;
    }

    public static void main(String a[]) {
        int[] ar = new int[]{3, 5, 1, 6, 9, 8};
        System.out.println(Arrays.toString(ar));
        System.out.println(Arrays.toString(mergeSort(ar)));
    }
}
