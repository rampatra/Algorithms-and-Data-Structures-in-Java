package com.rampatra.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/31/15
 */
public class MajorityElementInSortedArray {

    /**
     * Checks if {@code n} is a majority element in array {@code arr}
     * by performing a binary search.
     * <p/>
     * Time complexity: O(log n)
     *
     * @param arr
     * @param n
     * @return
     */
    public static boolean isMajorityElement(int[] arr, int n) {
        int l = arr.length;
        int startIndex = getFirstIndexOf(arr, n, 0, l - 1);

        // element not found
        if (startIndex == -1) return false;

        if (startIndex + l / 2 < l && arr[startIndex + l / 2] == n) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Returns the index of first occurrence of {@code n} in array {@code arr}.
     *
     * @param arr
     * @param low
     * @param high
     * @param n
     * @return
     */
    public static int getFirstIndexOf(int[] arr, int n, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            /**
             * Check if a[mid] is the first occurrence of n:
             * a[mid] is first occurrence if n is one of the following
             * is true:
             * (i)  mid == 0 and a[mid] == n
             * (ii) n > a[mid-1] and a[mid] == n
             */
            if (arr[mid] == n && (mid == 0 || n > arr[mid - 1])) {
                return mid;
            } else if (n <= arr[mid]) {
                return getFirstIndexOf(arr, n, low, mid - 1);
            } else {
                return getFirstIndexOf(arr, n, mid + 1, high);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(isMajorityElement(new int[]{2, 2}, 2));
        System.out.println(isMajorityElement(new int[]{1, 2}, 2));
        System.out.println(isMajorityElement(new int[]{1, 2, 2, 2, 2, 2, 3, 3}, 2));
        System.out.println(isMajorityElement(new int[]{1, 2, 2, 2, 2, 3, 3, 3}, 2));
    }
}
