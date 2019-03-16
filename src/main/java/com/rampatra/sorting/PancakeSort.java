package com.rampatra.sorting;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 10/26/15
 * @time: 9:20 PM
 */
public class PancakeSort {

    /**
     * Sorts the array {@param a} in-place in O(n^2) time complexity.
     * <p/>
     * This can also be seen as: Sort the array {@param a} using a method
     * {@code reverse(int[] a, int end)} which reverses array {@code int[] a}
     * from {@code 0} index till {@code end} index (both inclusive).
     *
     * @param a
     */
    public static void sort(int[] a) {

        int maxIndex; // max element's index
        int unsortedIndex = a.length - 1; // index till which elements are unsorted 

        while (unsortedIndex > 0) {
            maxIndex = 0;
            // find max element's index
            for (int j = 1; j <= unsortedIndex; j++) {
                if (a[j] > a[maxIndex]) {
                    maxIndex = j;
                }
            }
            // move the max element to its appropriate index if its not already in its correct index
            if (maxIndex != unsortedIndex) {
                reverse(a, maxIndex); // bring the max element to the front 
                reverse(a, unsortedIndex); // move the max element to its appropriate index
            }
            unsortedIndex--;
        }
    }

    /**
     * Reverses array {@param a} from {@code 0} index
     * till {@code end} index.
     *
     * @param a
     * @param end
     */
    public static void reverse(int[] a, int end) {
        int temp;
        for (int i = 0; i <= end / 2; i++) {
            temp = a[i];
            a[i] = a[end - i];
            a[end - i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(ar));
        sort(ar);
        System.out.println(Arrays.toString(ar));
        ar = new int[]{3, 4, 7, 1, 9, 0};
        System.out.println(Arrays.toString(ar));
        sort(ar);
        System.out.println(Arrays.toString(ar));
        ar = new int[]{6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(ar));
        sort(ar);
        System.out.println(Arrays.toString(ar));
        ar = new int[]{};
        System.out.println(Arrays.toString(ar));
        sort(ar);
        System.out.println(Arrays.toString(ar));
        ar = new int[]{1};
        System.out.println(Arrays.toString(ar));
        sort(ar);
        System.out.println(Arrays.toString(ar));
    }
}
