package me.ramswaroop.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 5/28/15
 * @time: 12:44 PM
 */
public class LargestSumContiguousSubArray {

    /**
     * Based on Kadane's Algorithm. 
     * 
     * @param a
     * @return
     */
    public static int getLargestSumOfContiguousSubArray(int a[]) {
        int maxSum = 0, maxSumTillIndex = 0;

        for (int i = 0; i < a.length; i++) {
            maxSumTillIndex += a[i];
            if (maxSumTillIndex < 0) {
                maxSumTillIndex = 0;
            }
            if (maxSumTillIndex > maxSum) {
                maxSum = maxSumTillIndex;
            }
        }
        return maxSum;
    }

    public static void main(String a[]) {
        System.out.println(getLargestSumOfContiguousSubArray(new int[]{-2, 1, -3, 4, 5, -1, 4}));
        System.out.println(getLargestSumOfContiguousSubArray(new int[]{2, -1, -3, 4, -5, 1, 4}));
        System.out.println(getLargestSumOfContiguousSubArray(new int[]{-2, -1, -3, -4, -5, -1, -4})); // doesn't work
    }
}
