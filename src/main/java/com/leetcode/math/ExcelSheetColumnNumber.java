package com.leetcode.math;

/**
 * Level: Easy
 * Problem Link: https://leetcode.com/problems/excel-sheet-column-number/
 * Problem Description:
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *  A -> 1
 *  B -> 2
 *  C -> 3
 *  ...
 *  Z -> 26
 *  AA -> 27
 *  AB -> 28
 *  ...
 *
 * Example 1:
 * Input: "A"
 * Output: 1
 *
 * Example 2:
 * Input: "AB"
 * Output: 28
 *
 * Example 3:
 * Input: "ZY"
 * Output: 701
 *
 * @author rampatra
 * @since 2019-05-31
 */
public class ExcelSheetColumnNumber {

    private static int titleToNumber(String title) {
        int res = 0;
        for (int i = 0; i < title.length(); i++) {
            char c = title.charAt(i);
            if (((int) c) >= 65 && ((int) c) <= 90) {
                res = res * 26 + (int) c - 64;
            } else {
                return -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        assertEquals(1, titleToNumber("A"));

        assertEquals(28, titleToNumber("AB"));

        assertEquals(701, titleToNumber("ZY"));

        assertEquals(-1, titleToNumber("a"));

        assertEquals(-1, titleToNumber("@"));

        assertEquals(2147483647, titleToNumber("FXSHRXW"));
    }
}
