package com.leetcode.arrays;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Level: Easy
 * Problem Link: https://leetcode.com/problems/can-place-flowers/
 * Problem Description:
 * Suppose you have a long flowerBed in which some of the plots are planted and some are not. However, flowers cannot
 * be planted in adjacent plots - they would compete for water and both would die.
 * <p>
 * Given a flowerBed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a
 * number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 * <p>
 * Example 1:
 * Input: flowerBed = [1,0,0,0,1], n = 1
 * Output: True
 * <p>
 * Example 2:
 * Input: flowerBed = [1,0,0,0,1], n = 2
 * Output: False
 * <p>
 * Note:
 * The input array won't violate no-adjacent-flowers rule.
 * The input array size is in the range of [1, 20000].
 * n is a non-negative integer which won't exceed the input array size.
 *
 * @author rampatra
 * @since 2019-07-24
 */
public class CanPlaceFlowers {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Runtime: <a href="https://leetcode.com/submissions/detail/246312039/">1 ms</a>.
     *
     * @param flowerBed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers(int[] flowerBed, int n) {
        int i = 0, count = 0;
        while (i < flowerBed.length) {
            if (flowerBed[i] == 0 && (i == 0 || flowerBed[i - 1] == 0) && (i == flowerBed.length - 1 || flowerBed[i + 1] == 0)) {
                flowerBed[i++] = 1;
                count++;
            }
            if (count >= n)
                return true;
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        assertTrue(canPlaceFlowers(new int[]{0}, 0));
        assertTrue(canPlaceFlowers(new int[]{0}, 1));
        assertTrue(canPlaceFlowers(new int[]{1}, 0));
        assertFalse(canPlaceFlowers(new int[]{1}, 1));
        assertTrue(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        assertFalse(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        assertFalse(canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2));
        assertTrue(canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0}, 2));
    }
}