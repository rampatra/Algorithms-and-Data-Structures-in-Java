package com.leetcode.arrays;

/**
 * Level: Easy
 * Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author rampatra
 * @since 2019-04-23
 */
public class BuySellStocks {

    /**
     * Time complexity: O(n)
     * where,
     * n = no. of stock prices
     * <p>
     * Runtime: <a href="https://leetcode.com/submissions/detail/224463627/">0 ms</a>.
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int buyPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            } else if (prices[i] - buyPrice > profit) {
                profit = prices[i] - buyPrice;
            }
        }

        return profit;
    }

    public static void main(String[] args) {

        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 0, 6, 4}));
        System.out.println(maxProfit(new int[]{4, 3, 2, 1}));

        // edge cases
        System.out.println(maxProfit(new int[]{}));
        System.out.println(maxProfit(new int[]{1}));
    }
}