package com.ctci.bitmanipulation;

/**
 * @author rampatra
 * @since 2019-03-18
 */
public class PairwiseSwap {

    /**
     * Write a program to swap odd and even bits in an integer with as few instructions as 
     * possible (e.g., bit O and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
     * 
     * Approach:
     * Shift the odd bits to the left, shift the even bits to the right, and finally, OR both the results. 
     * Note: You can operate on only odd bits or only even bits by using the appropriate masks, for e.g., 
     * 0x55555555 for odd bits and 0xaaaaaaaa for even bits.
     * 
     * @param n an input integer.
     * @return an integer with even and odd bits swapped.
     */
    private static int swapBits(int n) {
        return ((n & 0x55555555) << 1) | ((n & 0xaaaaaaaa) >>> 1);
    }

    public static void main(String[] args) {
        System.out.println("Input:  " + Integer.toBinaryString(1569) +
                "\nOutput: " + Integer.toBinaryString(swapBits(1569)));
        
        assert Integer.toBinaryString(swapBits(1569)).equals("100100010010");

        System.out.println("Input:  " + Integer.toBinaryString(2680) +
                "\nOutput: " + Integer.toBinaryString(swapBits(2680)));

        assert Integer.toBinaryString(swapBits(2680)).equals("10110110100");
        
        // fyi
        System.out.println(Integer.toBinaryString(0x55555555));
        System.out.println(Integer.toBinaryString(0xaaaaaaaa));
    }
}