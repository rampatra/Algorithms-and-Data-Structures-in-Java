package com.leetcode.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BuySellStocksTest {

    @Test
    public void testMaxProfitSimpleCase() {
        assertEquals(5, BuySellStocks.maxProfit(new int[]{7, 1, 5, 3, 6, 4}), 
                     "Phải trả về lợi nhuận tối đa là 5");
    }

    @Test
    public void testMaxProfitNoTransaction() {
        assertEquals(0, BuySellStocks.maxProfit(new int[]{7, 6, 4, 3, 1}), 
                     "Phải trả về lợi nhuận tối đa là 0 khi không có giao dịch nào được thực hiện");
    }

    @Test
    public void testMaxProfitWithZeroPrice() {
        assertEquals(6, BuySellStocks.maxProfit(new int[]{7, 1, 5, 0, 6, 4}), 
                     "Phải trả về lợi nhuận tối đa là 6 khi có giá là 0");
    }

    @Test
    public void testMaxProfitDescendingOrder() {
        assertEquals(0, BuySellStocks.maxProfit(new int[]{4, 3, 2, 1}), 
                     "Phải trả về lợi nhuận tối đa là 0 với giá giảm dần");
    }

    @Test
    public void testMaxProfitEmptyArray() {
        assertEquals(0, BuySellStocks.maxProfit(new int[]{}), 
                     "Phải trả về lợi nhuận tối đa là 0 với mảng trống");
    }

    @Test
    public void testMaxProfitSingleElement() {
        assertEquals(0, BuySellStocks.maxProfit(new int[]{1}), 
                     "Phải trả về lợi nhuận tối đa là 0 với mảng chỉ một phần tử");
    }
}
