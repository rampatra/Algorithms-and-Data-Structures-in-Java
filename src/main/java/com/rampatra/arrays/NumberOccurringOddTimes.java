package com.rampatra.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 5/20/15
 * @time: 11:09 PM
 */

import com.rampatra.bits.TwoNonRepeatingElements;

/**
 * Given an array of positive integers. All numbers occur
 * even number of times except one number which occurs odd
 * number of times. Find the number in O(n) time & constant space.
 * <p>
 * See {@link TwoNonRepeatingElements} for a more
 * complex problem which is solved in a similar approach.
 */
public class NumberOccurringOddTimes {

    public static int numberOccurringOddTimes(int a[]) {
        int res = a[0];
        for (int i = 1; i < a.length; i++) {
            res ^= a[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.print(numberOccurringOddTimes(new int[]{2, 3, 3, 3, 1, 2, 1}));
    }
}
