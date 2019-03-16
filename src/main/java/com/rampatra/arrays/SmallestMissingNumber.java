package com.rampatra.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 8/29/15
 * @time: 12:51 PM
 */
public class SmallestMissingNumber {

    /**
     * Modified Binary Search to find the smallest missing number in an array
     * {@param a} consisting of numbers between 0 to m - 1 and m > n where n is
     * length of array.
     * <p/>
     * Time complexity: O(log n)
     * Con: Doesn't work if there are repetitive elements.
     * <p/>
     * EXPLANATION:
     * In standard Binary Search, the element to be searched is compared with
     * the middle element and on the basis of comparison result, we decide whether
     * to search is over or to go to left half or right half.
     * In this method, we modify the standard Binary Search algorithm to compare the
     * middle element with its index and make decision on the basis of this comparison.
     *
     * @param a
     * @param low
     * @param high
     * @return
     */
    public static int smallestMissingNumber(int[] a, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;

            if (a[mid] == mid) {
                return smallestMissingNumber(a, mid + 1, high);
            } else if (a[mid] > mid) {
                return smallestMissingNumber(a, low, mid - 1);
            } else {
                return smallestMissingNumber(a, mid + 1, high);
            }
        } else {
            return low;
        }
    }

    public static void main(String[] args) {
        System.out.println(smallestMissingNumber(new int[]{0, 1}, 0, 1));
        System.out.println(smallestMissingNumber(new int[]{0, 1, 2, 6, 9}, 0, 4));
        System.out.println(smallestMissingNumber(new int[]{4, 5, 10, 11}, 0, 3));
        System.out.println(smallestMissingNumber(new int[]{0, 4, 5, 10, 56}, 0, 4));
        System.out.println(smallestMissingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 10}, 0, 8));
        System.out.println(smallestMissingNumber(new int[]{0, 1, 2, 3, 3}, 0, 4)); // doesn't work
    }
}
