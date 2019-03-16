package com.rampatra.bits;

/**
 * {@code >>} shifts bits to right filling left bits with the left most
 * bit (most significant bit). Also called signed right shift.
 * {@code >>>} shifts bits to the right filling left bits
 * with 0. Also called unsigned right shift.
 *
 * @author rampatra
 * @since 6/2/15
 */
public class RightShiftOperator {

    public static void main(String[] args) {
        int n = -4;
        System.out.printf("n:     %32d\n", n);
        System.out.printf("n:     %32s\n", Integer.toBinaryString(n));
        System.out.printf("n>>1:  %32s\n", Integer.toBinaryString(n >> 1));
        System.out.printf("n>>1:  %32d\n", n >> 1);
        System.out.printf("n>>>1: %32s\n", Integer.toBinaryString(n >>> 1));
        System.out.printf("n>>>1: %32d\n", n >>> 1);

        System.out.println("=======================================");

        n = -235034334;
        System.out.printf("n:     %32d\n", n);
        System.out.printf("n:     %32s\n", Integer.toBinaryString(n));
        System.out.printf("n>>1:  %32s\n", Integer.toBinaryString(n >> 1));
        System.out.printf("n>>1:  %32d\n", n >> 1);
        System.out.printf("n>>>1: %32s\n", Integer.toBinaryString(n >>> 1));
        System.out.printf("n>>>1: %32d\n", n >>> 1);
        System.out.printf("n>>2:  %32s\n", Integer.toBinaryString(n >> 2));
        System.out.printf("n>>>2: %32s\n", Integer.toBinaryString(n >>> 2));

        System.out.println("=======================================");

        n = 235034334;
        System.out.printf("n:     %32d\n", n);
        System.out.printf("n:     %32s\n", Integer.toBinaryString(n));
        System.out.printf("n>>1:  %32s\n", Integer.toBinaryString(n >> 1));
        System.out.printf("n>>1:  %32d\n", n >> 1);
        System.out.printf("n>>>1: %32s\n", Integer.toBinaryString(n >>> 1));
        System.out.printf("n>>>1: %32d\n", n >>> 1);
        System.out.printf("n>>2:  %32s\n", Integer.toBinaryString(n >> 2));
        System.out.printf("n>>>2: %32s\n", Integer.toBinaryString(n >>> 2));
    }
}