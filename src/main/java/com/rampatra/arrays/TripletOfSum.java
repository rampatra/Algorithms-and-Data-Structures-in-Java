package com.rampatra.arrays;

import com.rampatra.sorting.QuickSort;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 9/28/15
 * @time: 10:39 PM
 */
public class TripletOfSum {

    /**
     * Finds any 3 numbers in array {@param a}
     * whose sum is equal to {@param sum}.
     * <p/>
     * Time complexity: O(n^2)
     *
     * @param a
     * @param sum
     * @return
     */
    public static int[] getTripletOfSum(int[] a, int sum) {

        QuickSort.quickSort(a);

        int len = a.length;
        for (int i = 0, j = i + 1, k = len - 1; i < len - 2; i++) {
            while (j < k) {
                if (a[i] + a[j] + a[k] == sum) {
                    return new int[]{a[i], a[j], a[k]};
                } else if (a[i] + a[j] + a[k] < sum) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return new int[]{-1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTripletOfSum(new int[]{12, 3, 4, 5, 1, 6, 9}, 24)));
        System.out.println(Arrays.toString(getTripletOfSum(new int[]{12, 3, 4, 5, 1, 6, 9}, 19)));
        System.out.println(Arrays.toString(getTripletOfSum(new int[]{1, 2, 3}, 6)));
    }
}
