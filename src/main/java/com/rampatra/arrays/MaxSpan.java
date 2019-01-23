package com.rampatra.arrays;

import com.sun.tools.javac.util.Assert;

/**
 * Consider the leftmost and rightmost appearances of some value in an array. We'll say that the "span" is the
 * number of elements between the two inclusive. A single value has a span of 1. Returns the largest span found
 * in the given array.
 * <p>
 * Examples:
 * maxSpan([1, 2, 1, 1, 3]) → 4
 * maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6
 * maxSpan([1, 4, 2, 1, 4, 4, 4]) → 6
 * <p>
 * Level: Easy
 *
 * @author rampatra
 * @link https://codingbat.com/prob/p189576
 * @since 2019-01-23
 */
public class MaxSpan {

    public static int maxSpan(int[] nums) {
        if (nums.length == 0) return 0;
        int largestSpan = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] == nums[j]) {
                    if (j - i + 1 > largestSpan) {
                        largestSpan = j - i + 1;
                    }
                }
            }
        }
        return largestSpan;
    }

    public static void main(String[] args) {
        Assert.check(maxSpan(new int[]{1, 2, 1, 1, 3}) == 4);
        Assert.check(maxSpan(new int[]{1, 4, 2, 1, 4, 1, 4}) == 6);
        Assert.check(maxSpan(new int[]{1, 4, 2, 1, 4, 4, 4}) == 6);
        Assert.check(maxSpan(new int[]{1}) == 1);
        Assert.check(maxSpan(new int[]{}) == 0);
    }
}
