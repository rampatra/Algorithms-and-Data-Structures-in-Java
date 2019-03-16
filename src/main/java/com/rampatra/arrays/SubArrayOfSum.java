package com.rampatra.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 9/27/15
 * @time: 7:32 PM
 */
public class SubArrayOfSum {

    /**
     * Prints the sub-array in array {@param a} with sum {@param sum}.
     * <p/>
     * Algorithm: Keep on adding the elements, once the sum is larger
     * than the required sum start deleting the elements from the sum.
     * (Google Interview Question)
     *
     * @param a
     * @param sum
     */
    public static void printSubArrayOfSum(int[] a, int sum) {
        int currSum = 0, startIndex = 0;
        for (int i = 0; i < a.length; i++) {

            currSum += a[i];

            while (currSum > sum && startIndex < i) {
                currSum -= a[startIndex++];
            }

            if (currSum == sum) {
                System.out.println("Sub-array lies between indexes: " + startIndex + " and " + i);
                return;
            }
        }
        System.out.println("Sub-array with sum " + sum + " not found!");
    }

    public static void main(String[] args) {
        printSubArrayOfSum(new int[]{1, 4, 20, 3, 10, 5}, 33);
        printSubArrayOfSum(new int[]{1, 4, 20, 3, 10, 5}, 38);
        printSubArrayOfSum(new int[]{1, 4, 20, 3, 10, 5}, 13);
        printSubArrayOfSum(new int[]{1, 4, 0, 0, 3, 10, 5}, 0);
        printSubArrayOfSum(new int[]{1, 4}, 0);
        printSubArrayOfSum(new int[]{1, 4}, -4);
        printSubArrayOfSum(new int[]{1, -4}, -3);
    }
}
