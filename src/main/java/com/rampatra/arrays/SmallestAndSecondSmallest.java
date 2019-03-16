package com.rampatra.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/30/15
 */
public class SmallestAndSecondSmallest {

    private static int[] getSmallestAndSecondSmallest(int[] a) {
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (a[i] < smallest) {
                secondSmallest = smallest;
                smallest = a[i];
            } else if (a[i] < secondSmallest && a[i] != smallest) { // a[i] != smallest; if numbers are repeated in array
                secondSmallest = a[i];
            }
        }

        return new int[]{smallest, secondSmallest};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSmallestAndSecondSmallest(new int[]{100, 1, 60, -10, -80, 85, 70, -80})));
        System.out.println(Arrays.toString(getSmallestAndSecondSmallest(new int[]{100, 1, 60, 10, 80, 85, 70, 0})));
    }
}
