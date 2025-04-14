package com.leetcode.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CountAndSayTest {

    @Test
    public void testCountAndSayBaseCase() {
        assertEquals("1", CountAndSay.countAndSay(1),
                "Phải trả về '1' khi n = 1.");
    }

    @Test
    public void testCountAndSaySecond() {
        assertEquals("11", CountAndSay.countAndSay(2),
                "Phải trả về '11' khi n = 2.");
    }

    @Test
    public void testCountAndSayThird() {
        assertEquals("21", CountAndSay.countAndSay(3),
                "Phải trả về '21' khi n = 3.");
    }

    @Test
    public void testCountAndSayFourth() {
        assertEquals("1211", CountAndSay.countAndSay(4),
                "Phải trả về '1211' khi n = 4.");
    }

    @Test
    public void testCountAndSayFifth() {
        assertEquals("111221", CountAndSay.countAndSay(5),
                "Phải trả về '111221' khi n = 5.");
    }
}
