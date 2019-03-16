package com.rampatra.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 9/6/15
 * @time: 10:53 PM
 */
public class MinimumDistanceBetweenTwoNos {

    /**
     * Finds the minimum distance between two no.s {@param x}
     * and {@param y} in an unsorted array {@param a} which
     * may contain duplicates.
     * <p/>
     * Note: Either of the no.s may occur first in the array.
     *
     * @param a
     * @param x
     * @param y
     * @return
     */
    public static int getMinimumDistanceBetweenTwoNos(int[] a, int x, int y) {
        int startIndex = -1, endIndex = a.length, minDiff = a.length;

        for (int i = 0; i < a.length; i++) {
            // find the 1st occurrence of either of the numbers
            if (startIndex == -1 && (a[i] == x || a[i] == y)) {
                startIndex = i; // holds the index of the number that occurred first in array 
            } else if (a[i] == x || a[i] == y) {
                // see if it is same as the number that occurred first
                if (a[startIndex] == a[i]) {
                    startIndex = i;
                } else {
                    endIndex = i;
                }
            }
            // if distance is less, then update
            if (Math.abs(endIndex - startIndex) < minDiff) {
                minDiff = Math.abs(endIndex - startIndex);
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        System.out.println(getMinimumDistanceBetweenTwoNos(new int[]{1, 2}, 1, 2));
        System.out.println(getMinimumDistanceBetweenTwoNos(new int[]{3, 4, 5}, 3, 5));
        System.out.println(getMinimumDistanceBetweenTwoNos(new int[]{3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3}, 3, 6));
        System.out.println(getMinimumDistanceBetweenTwoNos(new int[]{3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 1, 2, 4, 3}, 3, 6));
        System.out.println(getMinimumDistanceBetweenTwoNos(new int[]{2, 5, 3, 5, 4, 4, 2, 3}, 3, 2));
    }
}
