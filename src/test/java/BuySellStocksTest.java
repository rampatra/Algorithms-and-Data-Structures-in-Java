

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuySellStocksTest {
    @Test
    void testEmptyArray() {
        int[] prices = {};
        int result = BuySellStocks.maxProfit(prices);

        assertEquals(0, result);
    }

    @Test
    void testUpdateBuyPrice() {
        int[] prices = {8, 5, 10};
        int result = BuySellStocks.maxProfit(prices);

        assertEquals(5, result);
    }

    @Test
    void testUpdateProfit() {
        int[] prices = {1, 5, 10};
        int result = BuySellStocks.maxProfit(prices);

        assertEquals(9, result);
    }

    @Test
    void testNoUpdateProfit() {
        int[] prices = {1, 10, 5};
        int result = BuySellStocks.maxProfit(prices);

        assertEquals(9, result);
    }

    @Test
    void testMixedUpdates() {
        int[] prices = {10, 2, 7, 3, 8, 4};
        int result = BuySellStocks.maxProfit(prices);

        assertEquals(6, result);
    }
}
