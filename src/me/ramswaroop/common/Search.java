package me.ramswaroop.common;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 5/31/15
 * @time: 10:45 PM
 */
public class Search {

    /**
     * Searches an item in a sorted array in O(log n) time.
     *
     * @param a
     * @param n
     * @return
     */
    public static int binarySearch(int a[], int n) {
        return binarySearch(a, n, 0, a.length - 1);
    }

    public static int binarySearch(int a[], int n, int low, int high) {
        int mid = (low + high) / 2;

        if (high < low) {
            return -1;
        } else if (n == a[mid]) {
            return mid;
        } else if (n < a[mid]) {
            return binarySearch(a, n, 0, mid - 1);
        } else {
            return binarySearch(a, n, mid + 1, high);
        }
    }

    /**
     * Driver for testing.
     *
     * @param a
     */
    public static void main(String a[]) {
        System.out.print(binarySearch(new int[]{2, 3, 4, 5, 6}, 10));
    }
}
