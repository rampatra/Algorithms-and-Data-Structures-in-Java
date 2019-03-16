package com.rampatra.searching;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 9/1/15
 * @time: 4:57 PM
 */
public class InterpolationSearch {

    /**
     * @param a
     * @param k
     * @return
     */
    public static int search(int[] a, int k) {
        int low = 0, high = a.length - 1, mid;

        while (a[low] != a[high] && k >= a[low] && k <= a[high]) {
            mid = low + (k - a[low]) * (high - low) / a[high] - a[low];

            if (k < a[mid]) {
                high = mid - 1;
            } else if (k > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        if (k == a[low]) {
            return low;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{0, 2}, 2));
        System.out.println(search(new int[]{0, 1}, 2));
        System.out.println(search(new int[]{0, 1, 2, 3}, 2));
        System.out.println(search(new int[]{0, 1, 2, 3}, 3));
        System.out.println(search(new int[]{0, 2}, 0));
        System.out.println(search(new int[]{0, 1, 2, 2, 2, 3, 3}, 2));
    }
}
