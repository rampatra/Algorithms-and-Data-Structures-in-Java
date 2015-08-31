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
     * Searches an element {@param n} in a sorted array {@param a}
     * and returns its index in O(log n) time. The Index may not
     * correspond to the first occurrence of the element.
     *
     * @param a
     * @param n
     * @return
     */
    public static int binarySearch(int a[], int n) {
        return binarySearch(a, n, 0, a.length - 1);
    }

    public static int binarySearch(int a[], int n, int low, int high) {

        if (low <= high) {
            int mid = (low + high) / 2;

            if (n == a[mid]) {
                return mid;
            } else if (n < a[mid]) {
                return binarySearch(a, n, 0, mid - 1);
            } else {
                return binarySearch(a, n, mid + 1, high);
            }
        } else {
            return -1;
        }
    }

    /**
     * Driver for testing.
     *
     * @param a
     */
    public static void main(String a[]) {
        System.out.println(binarySearch(new int[]{0, 2}, 2));
        System.out.println(binarySearch(new int[]{0, 1, 2, 3}, 2));
        System.out.println(binarySearch(new int[]{0, 1, 2, 3}, 3));
        System.out.println(binarySearch(new int[]{0, 2}, 0));
        System.out.println(binarySearch(new int[]{0, 1, 2, 2, 2, 3, 3}, 2)); // doesn't return index of first occurrence
    }
}
