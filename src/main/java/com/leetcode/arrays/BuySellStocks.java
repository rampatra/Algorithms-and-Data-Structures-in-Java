package com.leetcode.arrays;

/**
 * Level: Easy
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Description:
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 *
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
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