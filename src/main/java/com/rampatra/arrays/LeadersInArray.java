package com.rampatra.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/29/15
 * @time: 12:06 PM
 */
public class LeadersInArray {

    /**
     * Returns an array containing all leaders present in {@param a}.
     * An element is a LEADER if its greater than all elements to
     * the right of it in the array.
     *
     * @param a
     * @return
     */
    public static int[] getAllLeaders(int[] a) {

        int i = a.length - 2, j = 0;
        int[] leaders = new int[a.length];

        // rightmost element is always a leader
        leaders[0] = a[a.length - 1];

        for (; i >= 0; i--) {
            if (a[i] > leaders[j]) {
                leaders[++j] = a[i];
            }
        }

        // omit the extra space which aren't filled with leaders
        return Arrays.copyOfRange(leaders, 0, j + 1);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getAllLeaders(new int[]{16, 17, 4, 3, 5, 2})));
        System.out.println(Arrays.toString(getAllLeaders(new int[]{16, 1, 4, 3, 5, 12})));
        System.out.println(Arrays.toString(getAllLeaders(new int[]{16, 15, 14, 13, 12, 10})));
    }
}
