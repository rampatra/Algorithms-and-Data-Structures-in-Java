package com.rampatra.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/13/15
 * @time: 4:45 PM
 */
public class SwapBits {

    /**
     * Swaps bits at even position with bits
     * at odd position in {@param n}.
     *
     * @param n
     * @return
     */
    public static int swapEvenOddBits(int n) {
        int evenBits = n & 0x55555555;
        int oddBits = n & 0xaaaaaaaa;

        return evenBits << 1 | oddBits >> 1;
    }

    /**
     * Swaps bits at even position with bits
     * at odd position in {@param n}.
     *
     * @param n
     * @return
     */
    public static int swapEvenOddBits_V1(int n) {
        for (int i = 0; i < 32; i += 2) {
            int evenBit = (n >> i) & 1;
            int oddBit = (n >> (i + 1)) & 1;
            int xor = evenBit ^ oddBit;

            n ^= xor << i;
            n ^= xor << (i + 1);
        }
        return n;
    }


    /**
     * Swaps {@param length} bits in {@param n} starting from
     * {@param pos1} with bits starting from {@param pos2}.
     * <p/>
     * For example,
     * x = 28 (11100)
     * p1 = 0 (Start from first bit from right side)
     * p2 = 3 (Start from 4th bit from right side)
     * l = 2 (No of bits to be swapped)
     * Output:
     * 7 (00111)
     *
     * @param n
     * @param pos1   starts from 0
     * @param pos2   starts from 0
     * @param length
     * @return
     */
    public static int swapBitRangeInNumber(int n, int pos1, int pos2, int length) {
        int set1 = (n >> pos1) & ((1 << length) - 1); // 1st set of bits to be swapped
        int set2 = (n >> pos2) & ((1 << length) - 1); // 2nd set of bits to be swapped
        int xor = set1 ^ set2; // difference pattern between the bits to be swapped

        return n ^ (xor << pos1) ^ (xor << pos2);   // XORing the difference pattern at the appropriate
        // position of the bits to be swapped gives us the result
        // (this logic is similar to swapping bits using XOR)
    }

    public static void main(String[] args) {
        System.out.println(swapEvenOddBits(23));
        System.out.println(swapEvenOddBits(0));
        System.out.println(swapEvenOddBits(5));
        System.out.println(swapEvenOddBits(6));
        System.out.println("-------------------------------");
        System.out.println(swapEvenOddBits_V1(23));
        System.out.println(swapEvenOddBits_V1(0));
        System.out.println(swapEvenOddBits_V1(5));
        System.out.println(swapEvenOddBits_V1(6));
        System.out.println("-------------------------------");
        System.out.println(swapBitRangeInNumber(47, 1, 5, 3));
        System.out.println(swapBitRangeInNumber(28, 0, 3, 2));
        System.out.println(swapBitRangeInNumber(269, 1, 3, 2));
    }
}
