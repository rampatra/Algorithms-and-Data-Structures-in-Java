package com.rampatra.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 10/20/15
 * @time: 11:34 PM
 */
public class SymmetricDifference {

    /**
     * Returns the symmetric difference between array {@param a1}
     * and array {@param a2}.
     * <p/>
     * SYMMETRIC DIFFERENCE refers to the numbers which are present in
     * only one of the arrays and not both.
     *
     * @param a1
     * @param a2
     * @return
     */
    public static int[] getSymmetricDifference(int[] a1, int[] a2) {
        int index = 0;
        int[] res = new int[a1.length + a2.length];

        Arrays.sort(a1);
        Arrays.sort(a2);

        for (int i = 0, j = 0; i < a1.length || j < a2.length; ) {
            if (j >= a2.length) {
                res[index++] = a1[i];
                i++;
            } else if (i >= a1.length) {
                res[index++] = a2[j];
                j++;
            } else if (a1[i] < a2[j]) {
                res[index++] = a1[i];
                i++;
            } else if (a2[j] < a1[i]) {
                res[index++] = a2[j];
                j++;
            } else {
                i++;
                j++;
            }
        }

        return Arrays.copyOf(res, index);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSymmetricDifference(new int[]{1, 2, 3, 4}, new int[]{2, 4, 5})));
        System.out.println(Arrays.toString(getSymmetricDifference(new int[]{1, 2, 3, 4}, new int[]{5, 6, 7})));
        System.out.println(Arrays.toString(getSymmetricDifference(new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8})));
        System.out.println(Arrays.toString(getSymmetricDifference(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4})));
    }
}
