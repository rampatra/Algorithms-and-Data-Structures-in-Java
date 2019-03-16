package com.rampatra.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/14/15
 * @time: 12:37 AM
 */
public class ElementOccurringOnce {

    /**
     * Returns the element occurring once in {@param a} having
     * other elements repeating thrice.
     *
     * @param a
     * @return
     */
    public static int getElementOccurringOnceInElementsRepeatedThreeTimes(int a[]) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            // sum of all bits at ith position for all elements in a[]
            for (int j = 0; j < a.length; j++) {
                sum += (a[j] >>> i) & 1;
            }
            // bit will be set in result if sum mod 3 isn't 0
            result |= (sum % 3) << i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getElementOccurringOnceInElementsRepeatedThreeTimes(new int[]{12, 12, 6, 6, 2, 12, 6}));
        System.out.println(getElementOccurringOnceInElementsRepeatedThreeTimes(new int[]{5, 5, 45, 45, 456, 5, 45}));
        System.out.println(getElementOccurringOnceInElementsRepeatedThreeTimes(new int[]{12, 12, 34, 34, 6, 12, 34}));
    }
}

/**
 * EXPLANATION:
 * 12   =   1100
 * 12   =   1100
 * 6    =   0110
 * 6    =   0110
 * 2    =   0010
 * 12   =   1100
 * 6    =   0110
 * -------------
 * res  =   0010
 * <p>
 * 1st bit of res = (0+0+0+0+0+0+0) % 3 = 0
 * 2nd bit of res = (0+0+1+1+1+0+1) % 3 = 1
 * 3rd bit of res = (1+1+1+1+0+1+1) % 3 = 0
 * 4th bit of res = (1+1+0+0+0+1+0) % 3 = 0
 * <p>
 * NOTE: Sum of bits at a particular position will not be divisible
 * by 3 if the no. occurring once has a set bit at that position.
 */
