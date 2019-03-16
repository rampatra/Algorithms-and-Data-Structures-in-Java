package com.rampatra.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 8/31/15
 * @time: 2:52 PM
 */
public class OccurrencesInSortedArray {

    /**
     * Finds the occurrences of {@param k} in sorted array {@param a} in
     * O(log n) time.
     *
     * @param a
     * @param k
     * @return
     */
    public static int getOccurrencesInSortedArray(int[] a, int k) {
        int firstIndex = getFirstIndexOf(a, k, 0, a.length - 1);
        // element not found
        if (firstIndex == -1) {
            return 0;
        }
        return getLastIndexOf(a, k, firstIndex, a.length - 1) - firstIndex + 1;
    }

    /**
     * Returns the index of first occurrence of {@param n} in array {@param a}.
     *
     * @param a
     * @param low
     * @param high
     * @param n
     * @return
     */
    public static int getFirstIndexOf(int[] a, int n, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == n && (mid == 0 || a[mid - 1] < n)) {
                return mid;
            } else if (a[mid] < n) {
                return getFirstIndexOf(a, n, mid + 1, high);
            } else {
                return getFirstIndexOf(a, n, low, mid - 1);
            }
        } else {
            return -1;
        }
    }

    /**
     * Returns the index of last occurrence of {@param n} in array {@param a}.
     *
     * @param a
     * @param low
     * @param high
     * @param n
     * @return
     */
    public static int getLastIndexOf(int[] a, int n, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == n && (mid == a.length - 1 || a[mid + 1] > n)) {
                return mid;
            } else if (a[mid] <= n) {
                return getLastIndexOf(a, n, mid + 1, high);
            } else {
                return getLastIndexOf(a, n, low, mid - 1);
            }
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(getOccurrencesInSortedArray(new int[]{1, 1, 2, 2, 2, 2, 3}, 1));
        System.out.println(getOccurrencesInSortedArray(new int[]{1, 1, 1, 2, 2, 2, 2, 3}, 1));
        System.out.println(getOccurrencesInSortedArray(new int[]{1, 1, 2, 2, 2, 2, 3}, 2));
        System.out.println(getOccurrencesInSortedArray(new int[]{1, 1, 2, 2, 2, 2, 3}, 3));
        System.out.println(getOccurrencesInSortedArray(new int[]{1, 1, 2, 2, 2, 2, 3}, 0));
        System.out.println(getOccurrencesInSortedArray(new int[]{1, 1, 2, 2, 2, 2, 3}, 4));
    }
}
