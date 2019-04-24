package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Level: Easy
 * Problem: https://leetcode.com/problems/pascals-triangle/
 *
 * @author rampatra
 * @since 2019-04-20
 */
public class PascalsTriangle {

    /**
     * Time complexity: O(numRows^2)
     * Space complexity: O(numRows^2)
     * <p>
     * Runtime: <a href="https://leetcode.com/submissions/detail/223784377/">0 ms</a>.
     *
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generatePascalsTriangle(int numRows) {
        List<List<Integer>> pascalsTriangle = new ArrayList<>();

        if (numRows == 0) return pascalsTriangle;

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        pascalsTriangle.add(firstRow);

        List<Integer> prevRow;
        for (int i = 1; i < numRows; i++) {
            prevRow = pascalsTriangle.get(i - 1);

            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            for (int j = 0; j < prevRow.size() - 1; j++) {
                currRow.add(prevRow.get(j) + prevRow.get(j + 1));
            }
            currRow.add(1);

            pascalsTriangle.add(currRow);
        }

        return pascalsTriangle;
    }

    public static void main(String[] args) {
        System.out.println(generatePascalsTriangle(5));
    }
}
