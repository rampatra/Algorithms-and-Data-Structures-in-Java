package me.ramswaroop.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 7/31/15
 * @time: 10:02 AM
 */
public class MajorityElementInSortedArray {

    /**
     * Checks if {@param n} is a majority element in array {@param a}
     * by performing a binary search.
     * <p/>
     * Time complexity: O(log n)
     *
     * @param a
     * @param n
     * @return
     */
    public static boolean isMajorityElement(int[] a, int n) {
        int l = a.length;
        int startIndex = getIndexOf(a, 0, l - 1, n);

        if (startIndex + l / 2 < l && a[startIndex + l / 2] == n) {
            return true;
        } else {
            return false;
        }

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
    public static int getIndexOf(int[] a, int low, int high, int n) {
        int mid = (low + high) / 2;
        if (low < high) {
            /**
             * Check if a[mid] is the first occurrence of n:
             * a[mid] is first occurrence if n is one of the following
             * is true:
             * (i)  mid == 0 and a[mid] == n
             * (ii) n > a[mid-1] and a[mid] == n
             */
            if ((mid == 0 || n > a[mid - 1]) && (a[mid] == n)) {
                return mid;
            } else if (n < a[mid]) {
                getIndexOf(a, low, mid - 1, n);
            } else {
                getIndexOf(a, mid + 1, high, n);
            }
        }
        return -1;
    }

    public static void main(String a[]) {
        System.out.println(isMajorityElement(new int[]{1, 2}, 2));
        System.out.println(isMajorityElement(new int[]{1, 2, 2, 2, 2, 2, 3, 3}, 2));
        System.out.println(isMajorityElement(new int[]{1, 2, 2, 2, 2, 2, 3, 3}, 3));
    }
}
