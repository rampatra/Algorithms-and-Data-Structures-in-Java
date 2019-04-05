package com.rampatra.stacks;

/**
 * Given a bar histogram, calculate the maximum possible rectangle area in the histogram. Consider each bar is 1 unit
 * wide.
 * <p>
 * Level: Hard
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author rampatra
 * @since 2019-04-04
 */
public class MaxRectangleAreaInHistogram {

    public static int getMaxRectangleArea(int[] hist) {
        Stack<Integer> stack = new Stack<>();
        int area;
        int maxArea = 0;
        int currMaxIndex;
        int i = 0;

        while (i < hist.length) {
            // keep adding indexes of bars which are equal to or larger than what's there in stack currently
            if (stack.isEmpty() || hist[i] >= hist[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                /* 
                    Whenever we encounter a bar smaller than what is there in the stack, we pop the topmost 
                    element and compute the area.
                 */
                currMaxIndex = stack.pop();
                /*
                    Compute area from stack.peek() to (i - 1), 
                        
                        Why (i - 1)?      Because i has been incremented and is now pointing to the next bar in the
                                          histogram
                        
                        Why stack.peak()? Because hist[stack.peek() + 1] is the last bar in the histogram with height more 
                                          than or equal to the current bar height
                 */
                area = hist[currMaxIndex] * (i - (stack.isEmpty() ? 0 : stack.peek() + 1));
                maxArea = Math.max(maxArea, area);
            }
        }

        /*
            Process the left over elements in the stack. Note: the below code can also be merged with the loop
            above but I have separated it out for simplicity.
         */
        while (!stack.isEmpty()) {
            currMaxIndex = stack.pop();
            area = hist[currMaxIndex] * (i - (stack.isEmpty() ? 0 : stack.peek() + 1));
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        /*
                  ___
            ___   |  |  ___
            |  |__|  |__|  |
            |  |  |  |  |  |
             2  1  3  1  2
             
             Max. area in this histogram is 5, which is the bottom horizontal rectangle.
         */
        System.out.println(getMaxRectangleArea(new int[]{2, 1, 3, 1, 2})); // maxArea = 5
        System.out.println(getMaxRectangleArea(new int[]{2, 1, 5, 6, 2, 3})); // maxArea = 10
        System.out.println(getMaxRectangleArea(new int[]{2, 2, 2, 6, 1, 5, 4, 2, 2, 2, 2})); // maxArea = 12
        
        // edge cases
        System.out.println(getMaxRectangleArea(new int[]{})); // maxArea = 0
        System.out.println(getMaxRectangleArea(new int[]{1})); // maxArea = 1
    }
}