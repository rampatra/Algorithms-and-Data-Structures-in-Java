package com.rampatra.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/31/15
 * @time: 5:13 PM
 */
public class SegregateEvenAndOddNos {

    /**
     * Segregate even and odd numbers by traversing the
     * array {@param a} only once.
     * <p/>
     * This is similar to {@link Segregate0sAnd1s}.
     *
     * @param a
     */
    public static void segregateEvenAndOddNos(int[] a) {
        for (int i = 0, j = a.length - 1; i < j; ) {
            if (a[i] % 2 != 0 && a[j] % 2 == 0) {
                // swap
                a[i] = a[i] + a[j];
                a[j] = a[i] - a[j];
                a[i] = a[i] - a[j];
                i++;
                j--;
            } else if (a[i] % 2 == 0 && a[j] % 2 == 0) {
                i++;
            } else if (a[i] % 2 != 0 && a[j] % 2 != 0) {
                j--;
            } else {
                i++;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] ar = new int[]{12, 34, 45, 9, 8, 90, 3};
        segregateEvenAndOddNos(ar);
        System.out.println(Arrays.toString(ar));
        int[] ar1 = new int[]{34, 1, 45, 9, 8, 67, 3, 56, 78, 79, 101, 100};
        segregateEvenAndOddNos(ar1);
        System.out.println(Arrays.toString(ar1));
    }
}
