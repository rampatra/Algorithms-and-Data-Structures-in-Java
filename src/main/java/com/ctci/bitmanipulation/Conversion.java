package com.ctci.bitmanipulation;

/**
 * @author rampatra
 * @since 2019-03-17
 */
public class Conversion {

    /**
     * Write a function to determine the number of bits you would need to flip to convert
     * integer A to integer B.
     * Example:
     * Input: 29 (or: 11101), 15 (or: 01111)
     * Output: 2
     * 
     * @param a
     * @param b
     * @return the number of bits to flip
     */
    private static int getNoOfBitsToFlipToConvertAToB(int a, int b) {
        return countSetBits(a ^ b);
    }

    private static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getNoOfBitsToFlipToConvertAToB(5, 7));
        System.out.println(getNoOfBitsToFlipToConvertAToB(5, 5));
        System.out.println(getNoOfBitsToFlipToConvertAToB(29, 15));
    }
}