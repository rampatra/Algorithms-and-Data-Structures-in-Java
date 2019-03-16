package com.rampatra.sorting;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 8/22/15
 * @time: 12:28 PM
 */
public class SelectionSort {

    /**
     * Selection Sort.
     * <p/>
     * Explanation:
     * This is one of the simplest algorithm where each time the smallest/largest
     * element is chosen and placed at the appropriate position and then again the
     * logic is applied on rest of the elements till the entire array is sorted.
     * <p/>
     * Time complexity: O(n^2) for all cases. Space complexity: O(1).
     * <p/>
     * NOTE: Advantage of this sort is that it requires minimum number of memory writes
     * like Cycle sort.
     *
     * @param a
     */
    public static void selectionSort(int[] a) {
        int minIndex;

        for (int i = 0; i < a.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            swap(a, i, minIndex);
        }
    }

    /**
     * Swaps variables in {@param a} at {@param index1} with {@param index2}.
     *
     * @param a
     * @param index1
     * @param index2
     */
    private static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    public static void main(String[] args) {
        int[] ar = new int[]{3, 2, 1, 5, 6, 9, 7, 10};
        selectionSort(ar);
        System.out.println(Arrays.toString(ar));

        ar = new int[]{3, 2, 1, 5, 5, 6, 9, 7, 6, 10};
        selectionSort(ar);
        System.out.println(Arrays.toString(ar));
    }
}
