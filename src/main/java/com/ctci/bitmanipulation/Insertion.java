package com.ctci.bitmanipulation;

/**
 * @author rampatra
 * @since 2019-03-14
 */
public class Insertion {

    /**
     * You are given two 32-bit numbers, N and M, and two bit positions, startIndex and endIndex. Write a method to
     * insert M into N such that M starts at bit startIndex and ends at bit endIndex. You can assume that the bits
     * startIndex through endIndex have enough space to fit all of M. That is, if M = 10011, you can assume that there
     * are at least 5 bits between j and i. You would not, for example, have startIndex = 3 and endIndex = 2, because
     * M could not fully fit between bit 3 and bit 2.
     * <p>
     * EXAMPLE
     * Input: N = 10000000000, M = 10011, startIndex = 6, endIndex = 2
     * Output:    10001001100
     *
     * @param n
     * @param m
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int insertMIntoN(int n, int m, int startIndex, int endIndex) {
        // create a mask with only one bit set
        int mask = 1;
        // shift the set bit so that it starts with endIndex
        mask <<= endIndex;

        // unset the bits in 'n' from endIndex to startIndex
        for (int i = endIndex; i <= startIndex; i++) {
            n = n & ~mask; // ~mask will make the bit at ith index 0 but the rest of the bits will be 1
            mask <<= 1;
        }

        // shift 'm' so that it lines up with bits from startIndex to endIndex
        m <<= endIndex;

        // finally, return the xor of both as we know that 0 ^ a = a
        return n ^ m;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(insertMIntoN(Integer.parseInt("10000000000", 2), Integer.parseInt("10011", 2), 6, 2)));
        System.out.println(Integer.toBinaryString(insertMIntoN(Integer.parseInt("10110110111", 2), Integer.parseInt("11101", 2), 7, 3)));
    }
}