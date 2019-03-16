package com.rampatra.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 8/12/15
 * @time: 5:40 PM
 */
public class MaxDiffWithLargerElementAfterSmallerElement {

    /**
     * Finds the difference between any two elements such that larger
     * element appears after the smaller number in array {@param a}.
     * <p/>
     * Example:
     * If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8 (Diff between 10 and 2).
     * If array is [ 7, 9, 5, 6, 3, 2 ] then returned value should be 2 (Diff between 7 and 9).
     *
     * @param a
     * @return
     */
    public static int getMaxDiffWithLargerElementAfterSmallerElement(int[] a) {
        int minElement = a[0], maxDiff = a[1] - a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] < minElement) {
                minElement = a[i];
            }
            if (a[i] - minElement > maxDiff) {
                maxDiff = a[i] - minElement;
            }
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        System.out.println(getMaxDiffWithLargerElementAfterSmallerElement(new int[]{2, 1, 4, 5, 10, 0}));
        System.out.println(getMaxDiffWithLargerElementAfterSmallerElement(new int[]{2, -6, 4, 5, 10, 1}));
        System.out.println(getMaxDiffWithLargerElementAfterSmallerElement(new int[]{-2, -6, -4, -5, -10, -1}));
    }
}
