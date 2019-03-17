package com.ctci.bitmanipulation;

/**
 * @author rampatra
 * @since 2019-03-16
 */
public class FlipBitToWin {

    /**
     * You have an integer and you can flip exactly one bit from a O to a 1. Write code to find the length of the
     * longest sequence of 1s you could create.
     * Example:
     * Input: 1775 (or: 11011101111)
     * Output: 8
     * <p>
     * Approach:
     * We just walk through the integer tracking the current 1s sequence length and the previous 1s sequence length.
     * When we see a zero, update previous length as follows:
     * - If the next bit is a 1, previous Length should be set to current Length.
     * - If the next bit is a 0, then we can't merge these sequences together. So, set previous Length to 0.
     *
     * @param n an integer
     * @return the longest sequence of set bits in {@code n} by flipping only one zero bit
     */
    private static int findLongestSequence(int n) {
        // if all bits are set, return the total number of bits in an integer
        if (n == ~0) {
            return Integer.BYTES * 8;
        }

        int prevOnesLen = 0;
        int currOnesLen = 0;
        int maxOnesLen = 0;

        while (n > 0) {
            // if the current bit is 0, reset the currOnesLen
            if ((n & 1) == 0) {
                prevOnesLen = (n & 2) == 0 ? 0 : currOnesLen; // if the next bit is also 0, set prevOnesLen to 0
                currOnesLen = 0;
            } else {
                currOnesLen++;
            }
            n >>>= 1;
            maxOnesLen = Math.max(maxOnesLen, prevOnesLen + 1 + currOnesLen);
        }
        return maxOnesLen;
    }

    public static void main(String[] args) {
        System.out.println("Longest seq in " + Integer.toBinaryString(125) + " is " + findLongestSequence(125));
        System.out.println("Longest seq in " + Integer.toBinaryString(1275) + " is " + findLongestSequence(1275));
    }
}
