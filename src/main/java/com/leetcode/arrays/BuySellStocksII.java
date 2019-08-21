package com.leetcode.arrays;

/**
 * Level: Easy
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * Description:
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you
 * like (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock
 * before you buy again).
 *
 * @author rampatra
 * @since 2019-04-23
 */
public class BuySellStocksII {

    /**
     * The key point is we need to consider every peak immediately following a valley to maximize the profit. In case
     * we skip one of the peaks (trying to obtain more profit), we will end up losing the profit over one of the
     * transactions leading to an overall lesser profit.
     * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/">Read this to learn more</a>.
     * <p>
     * Time complexity: O(n)
     * where,
     * n = no. of stock prices
     * <p>
     * Runtime: <a href="https://leetcode.com/submissions/detail/224655101/">0 ms</a>.
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int valley;
        int peak;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            while (i < prices.length - 1 && prices[i] > prices[i + 1]) {
                i++;
            }
            valley = i;

            while (i < prices.length - 1 && prices[i] < prices[i + 1]) {
                i++;
            }
            peak = i;

            maxProfit += prices[peak] - prices[valley];
        }

        return maxProfit;
    }

    /**
     * This solution follows the logic used in the above approach {@link #maxProfit(int[])}, but with only a slight
     * variation. In this case, instead of looking for every peak following a valley, we can simply go on crawling over
     * the slope and keep on adding the profit obtained from every consecutive transaction.
     * In the end, we will be using the peaks and valleys effectively, but we need not track the costs corresponding to
     * the peaks and valleys along with the maximum profit, but we can directly keep on adding the difference between the
     * consecutive numbers of the array if the second number is larger than the first one, and at the total sum we obtain
     * will be the maximum profit. This approach will simplify the solution.
     * <p>
     * Time complexity: O(n)
     * where,
     * n = no. of stock prices
     *
     * @param prices
     * @return
     */
    public static int maxProfitSimplified(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));

        System.out.println("----");

        System.out.println(maxProfitSimplified(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfitSimplified(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfitSimplified(new int[]{7, 6, 4, 3, 1}));
    }
}