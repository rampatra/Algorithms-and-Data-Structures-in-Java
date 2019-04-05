package com.rampatra.dynamicprogramming;

import com.rampatra.stacks.MaxRectangleAreaInHistogram;

/**
 * Given a 2D matrix of 0s and 1s. Find the largest rectangle of all 1s in this matrix.
 * <p>
 * Level: Hard
 * Time Complexity: O(rows * cols)
 * Space Complexity: O(cols)
 * <p>
 * Note: If the number of cols is too large as compared to rows then you can process the matrix column-wise and create
 * the histogram for each column. In this way the hist[] array will be of size = number of rows in the matrix.
 *
 * @author rampatra
 * @since 2019-04-05
 */
public class MaximumRectangleOf1sInMatrix {

    private static int getMaxRectangleSizeOf1s(int[][] binaryMatrix) {
        int area;
        int maxArea = 0;
        int[] hist = new int[binaryMatrix[0].length];

        /*
            Create a histogram with the rows. Start with the first row, create a histogram and then extend this 
            histogram based on the elements in the next rows. If the element in the row is a 0 then make the bar in 
            the histogram 0 or else just increase the bar in the histogram. 
            
            Basically, we are creating a histogram with all the 1s in the matrix and then finding the maximum 
            rectangle size of this histogram. 
          */
        for (int row = 0; row < binaryMatrix.length; row++) {
            for (int col = 0; col < binaryMatrix[0].length; col++) {
                if (binaryMatrix[row][col] == 0) {
                    hist[col] = 0;
                } else {
                    hist[col] += binaryMatrix[row][col];
                }
            }
            area = MaxRectangleAreaInHistogram.getMaxRectangleArea(hist);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(getMaxRectangleSizeOf1s(
                new int[][]{{0, 1, 1},
                        {0, 0, 1},
                        {0, 1, 1}}));
        
        System.out.println(getMaxRectangleSizeOf1s(
                new int[][]{{0, 1, 1, 1, 0},
                        {0, 0, 1, 1, 0},
                        {0, 1, 1, 1, 0}}));

        System.out.println(getMaxRectangleSizeOf1s(
                new int[][]{{1, 1, 1, 0},
                        {1, 1, 1, 1},
                        {0, 1, 1, 0},
                        {0, 1, 1, 1},
                        {1, 0, 0, 1},
                        {1, 1, 1, 1}}));

        // edge cases
        System.out.println(getMaxRectangleSizeOf1s(
                new int[][]{{}}));

        System.out.println(getMaxRectangleSizeOf1s(
                new int[][]{{0}}));

        System.out.println(getMaxRectangleSizeOf1s(
                new int[][]{{0, 0, 0}}));

        System.out.println(getMaxRectangleSizeOf1s(
                new int[][]{{1}}));
    }
}
