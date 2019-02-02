package com.rampatra.arrays;

/**
 * A Google Interview Question. For a simpler version of this question see {@link SmallestAndSecondSmallest}.
 *
 * @author rampatra
 * @since 2019-02-01
 */
public class NthSmallestNumber {

    /**
     * Given an unsorted array of integers, find the nth smallest integer in the array in most optimized way possible.
     * <p>
     * Approach: Similar to Quick Sort where in every iteration, we choose a pivot element and shift all lesser integers
     * to left and higher integers to the right. After doing this we compare the pivot index with n and recursively call
     * the method accordingly. See {@link com.rampatra.sorting.QuickSort}.
     *
     * @param arr   the input unsorted array of integers
     * @param n     nth smallest integer to find
     * @param start the start index in the array to search (inclusive)
     * @param end   the last index in the array to search (inclusive)
     * @return the nth smallest integer, {@code -1} if invalid input
     */
    private static int findNthSmallestNumber(int[] arr, int n, int start, int end) {
        if (arr.length == 0 || arr.length < n) {
            return -1;
        }
        int temp;
        int lastBigger = start;
        for (int i = start; i < end; i++) {
            if (arr[i] < arr[end]) {
                temp = arr[i];
                arr[i] = arr[lastBigger];
                arr[lastBigger] = temp;
                lastBigger++;
            }
        }
        temp = arr[lastBigger];
        arr[lastBigger] = arr[end];
        arr[end] = temp;

        if (lastBigger + 1 < n) {
            return findNthSmallestNumber(arr, n, lastBigger + 1, end);
        } else if (lastBigger + 1 > n) {
            return findNthSmallestNumber(arr, n, start, lastBigger - 1);
        } else {
            return arr[lastBigger];
        }
    }

    public static void main(String[] args) {
        System.out.println(findNthSmallestNumber(new int[]{}, 3, 0, 5));
        System.out.println(findNthSmallestNumber(new int[]{0, 1}, 3, 0, 1));
        System.out.println(findNthSmallestNumber(new int[]{0, 1}, 2, 0, 1));
        System.out.println(findNthSmallestNumber(new int[]{1, 0}, 2, 0, 1));
        System.out.println(findNthSmallestNumber(new int[]{2, 3, 5, 10, 9, 4}, 3, 0, 5));
        System.out.println(findNthSmallestNumber(new int[]{2, 3, 4, 10, 9, 4}, 3, 0, 5));
        System.out.println(findNthSmallestNumber(new int[]{4, 4, 4, 4, 4, 4}, 3, 0, 5));
        System.out.println(findNthSmallestNumber(new int[]{4, 8, 1, 9, 10, 2, 7, 3, 2, 6}, 3, 0, 9)); // TODO: doesn't work with duplicates currently
    }
}
