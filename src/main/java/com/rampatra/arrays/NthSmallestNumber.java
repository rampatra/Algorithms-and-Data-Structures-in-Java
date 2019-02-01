package com.rampatra.arrays;

/**
 * A Google Interview Question. For a simpler version of this question see {@link SmallestAndSecondSmallest}.
 *
 * @author rampatra
 * @since 2019-02-01
 */
public class NthSmallestNumber {

    private static int findNthSmallestNumber(int[] arr, int n, int start, int end) {
        if (arr.length == 0 || arr.length < n) {
            return -1;
        }
        int temp;
        for (int i = start; i < end; i++) {
            if (arr[i] < arr[end]) {
                temp = arr[i];
                arr[i] = arr[start];
                arr[start] = temp;
                start++;
            }
        }
        temp = arr[end];
        arr[end] = arr[start];
        arr[start] = temp;

        if (start + 1 < n) {
            return findNthSmallestNumber(arr, n, 0, start);
        } else if (start + 1 > n) {
            return findNthSmallestNumber(arr, n, start + 1, end);
        } else {
            return arr[start];
        }
    }

    public static void main(String[] args) {
        System.out.println(findNthSmallestNumber(new int[]{}, 3, 0, 5));
        System.out.println(findNthSmallestNumber(new int[]{0, 1}, 3, 0, 1));
        System.out.println(findNthSmallestNumber(new int[]{0, 1}, 2, 0, 1));
        System.out.println(findNthSmallestNumber(new int[]{1, 0}, 2, 0, 1));
        System.out.println(findNthSmallestNumber(new int[]{2, 3, 5, 10, 9, 4}, 3, 0, 5));
        System.out.println(findNthSmallestNumber(new int[]{2, 3, 4, 10, 9, 4}, 3, 0, 5));
        System.out.println(findNthSmallestNumber(new int[]{4, 8, 1, 9, 10, 2, 7, 3, 2, 6}, 3, 0, 9));
//        System.out.println(findNthSmallestNumber(new int[]{4, 4, 4, 4, 4, 4}, 3, 0, 5));
    }
}
