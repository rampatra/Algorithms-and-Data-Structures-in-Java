package com.rampatra.sorting;

import java.util.Arrays;

/**
 * @author rpatra16
 * @since 03/11/2018
 */
public class BubbleSort {

    /**
     * In bubble sort, we start at the beginning of the array and swap
     * the first two elements if the first is greater than the second.
     * Then, we go to the next pair, and so on, continuously making sweeps
     * of the array until it is sorted. In doing so, the smaller items
     * slowly "bubble" up to the beginning of the list and in each inner
     * iteration the largest element is sorted. Ergo, the inner loop runs
     * until {@code length - i - 1} times. Time complexity: O(n^2). Space
     * complexity: O(1), in place. To learn more: {@see https://youtu.be/6Gv8vg0kcHc}
     *
     * @param ar to be sorted
     */
    private static void bubbleSort(int[] ar) {
        for (int i = 0; i < ar.length - 1; i++) {
            for (int j = 0; j < ar.length - i - 1; j++) {
                if (ar[j] > ar[j + 1]) {
                    swap(ar, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public static void main(String[] args) {
        int[] ar = {2, 5, 1, 7, 8};
        System.out.println(Arrays.toString(ar));
        bubbleSort(ar);
        System.out.println(Arrays.toString(ar));
        ar = new int[]{7, 5, 1, 7, 8, 0, 23};
        System.out.println(Arrays.toString(ar));
        bubbleSort(ar);
        System.out.println(Arrays.toString(ar));
    }
}
