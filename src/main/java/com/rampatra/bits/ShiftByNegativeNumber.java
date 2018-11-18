package com.rampatra.bits;

/**
 * Understanding shifting in Java. What happens when you shift a number by a negative number.
 *
 * @author rampatra
 * @link https://docs.oracle.com/javase/specs/jls/se7/html/jls-15.html#jls-15.19
 * @link https://stackoverflow.com/a/10516830/1385441
 * @since 18/11/2018
 */
public class ShiftByNegativeNumber {
    /**
     * These both are the same as in java if the left operand is int only the low five bits are considered
     * for shifting and if the left operand is a long then the low six bits are considered.
     * Binary representation of -2 is 11.....11110. The last 5 bits are 11110 which is 30.
     *
     * @param args
     */
    public static void main(String[] args) {
        int v1 = 1 << -2;
        int v2 = 1 << 30;
        System.out.println(v1);
        System.out.println(v2);
    }
}
