package com.rampatra.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/3/15
 * @time: 11:35 PM
 */

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * <p/>
 * Note: Works only for positive integers.
 */
public class Multiply {

    /**
     * Multiplies {@param n} with 3.5 and returns only the
     * integral part of the number and omits the fractional part.
     *
     * @param n
     * @return
     */
    public static long multiplyWith3point5(long n) {
        return ((n << 3) - n) >> 1; // (8n-n)/2 = 7n/2 = 3.5n
    }

    /**
     * Multiplies {@param n} with 3.5 and returns only the
     * integral part of the number and omits the fractional part.
     *
     * @param n
     * @return
     */
    public static long multiplyWith3point5_V1(long n) {
        return (n << 1) + n + (n >> 1); // n*2 + n + n/2 = 7n/2 = 3.5n
    }

    /**
     * 3 left shifts gives us 8n but we want 7n, so we subtract
     * 1n from it. Similarly we can do any multiplication by shifting
     * and then adding/subtracting.
     *
     * @param n
     * @return
     */
    public static long multiplyWith7(long n) {
        return (n << 3) - n;
    }

    /**
     * Multiplies a number with 8 by performing 3 left shifts.
     *
     * @param n
     * @return
     */
    public static long multiplyWith8(long n) {
        return (n << 3);
    }

    public static void main(String[] args) {
        System.out.println(multiplyWith3point5(3));
        System.out.println(multiplyWith3point5(4));
        System.out.println(multiplyWith3point5(6));
        System.out.println(multiplyWith3point5(-7));

        System.out.println(multiplyWith7(6));
        System.out.println(multiplyWith7(7));

        System.out.println(multiplyWith8(4));
        System.out.println(multiplyWith8(6));
        System.out.println(multiplyWith8(7));
    }
}
