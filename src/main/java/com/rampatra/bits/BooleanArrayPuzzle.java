package com.rampatra.bits;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/12/15
 * @time: 3:31 PM
 */
public class BooleanArrayPuzzle {

    /**
     * Change 1 to 0 in an array of length 2 containing
     * one 0 and the other either 1 or 0.
     *
     * @param a
     * @return
     */
    public static int[] change1To0InArray(int a[]) {
        a[a[1]] = a[a[0]];
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(change1To0InArray(new int[]{0, 0})));
        System.out.println(Arrays.toString(change1To0InArray(new int[]{0, 1})));
        System.out.println(Arrays.toString(change1To0InArray(new int[]{1, 0})));
    }
}
