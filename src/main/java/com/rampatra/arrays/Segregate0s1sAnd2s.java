package com.rampatra.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 8/18/15
 * @time: 8:38 PM
 */
public class Segregate0s1sAnd2s {

    /**
     * Segregates an array {@param a} consisting of only 0s, 1s and 2s. Based on
     * Dutch National Flag (DNF) problem {@see: http://www.csse.monash.edu.au/~lloyd/tildeAlgDS/Sort/Flag/}.
     *
     * @param a
     */
    public static void segregate0s1sAnd2s(int[] a) {
        // assume low points to 0 and mid to 1 and high to 2
        int low = 0, mid = 0, high = a.length - 1;

        while (mid <= high) {
            switch (a[mid]) {
                case 0: // mid points to 0 but it should point to 1 so swap it with low
                    swap(a, low, mid);
                    low++;
                    mid++;
                    break;
                case 1: // mid points to 1 which is correct acc. to our assumption so proceed
                    mid++;
                    break;
                case 2: // mid points to 2 instead of 1 so swap it with high
                    swap(a, mid, high);
                    high--;
                    break;
            }
        }
    }

    private static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    public static void main(String[] args) {
        int[] ar = new int[]{0, 1, 2, 0, 1, 2};
        segregate0s1sAnd2s(ar);
        System.out.println(Arrays.toString(ar));

        ar = new int[]{0, 2, 1, 1, 2, 0};
        segregate0s1sAnd2s(ar);
        System.out.println(Arrays.toString(ar));

        ar = new int[]{0, 1, 2};
        segregate0s1sAnd2s(ar);
        System.out.println(Arrays.toString(ar));

        ar = new int[]{2, 1, 0, 2, 1, 0};
        segregate0s1sAnd2s(ar);
        System.out.println(Arrays.toString(ar));

        ar = new int[]{1, 2, 1, 0, 2, 1, 0};
        segregate0s1sAnd2s(ar);
        System.out.println(Arrays.toString(ar));
    }
}
