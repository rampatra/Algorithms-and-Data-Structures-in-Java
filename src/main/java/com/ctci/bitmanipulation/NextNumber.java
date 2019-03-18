package com.ctci.bitmanipulation;

/**
 * @author rampatra
 * @since 2019-03-17
 */
public class NextNumber {

    private static class NextLargerAndSmallerNumber {
        int nextLarger;
        int nextSmaller;
    }

    /**
     * Given a positive integer, print the next smallest and the next largest number that have the same number of
     * 1 bits in their binary representation.
     *
     * @param n a positive integer.
     * @return an object containing the next larger and next smaller number containing the identical set bits.
     */
    private static NextLargerAndSmallerNumber getNextLargerAndSmallerNumber(int n) {
        NextLargerAndSmallerNumber result = new NextLargerAndSmallerNumber();
        result.nextLarger = getNextLarger(n);
        result.nextSmaller = getNextSmaller(n);
        return result;
    }

    private static int getNextLarger(int n) {
        int zeroPrecededByOneFromRight = 0;
        int noOfOnes = 0;
        int mask = 1;

        /* Find the position of the bit pattern '01' from the right and then make it '10'.
            For example, see below:        
               
                n = 10110110011110
                            ^^
                n = 10110110101110 (after bit swap)
         */
        for (int i = 0; i < Integer.BYTES * 8 - 1; i++) {
            if ((n & mask) == mask) {
                if ((n & mask << 1) == 0) {
                    n = (n & ~mask) | mask << 1; // swap the bits
                    break;
                }
                noOfOnes++;
            }
            zeroPrecededByOneFromRight++;
            mask <<= 1;
        }

        if (zeroPrecededByOneFromRight == Integer.BYTES * 8 - 1) {
            return -1;
        }

        /* Shift all the 1s to the right end and then fill with 0s until the bit pattern '01.
            For example, consider the above number: 
            
                        n = 10110110101110 (after bit swap)
                                    ^^    
              next larger = 10110110100111 (the 1s are shifted to the right end)  
         */
        mask = 1;
        for (int i = 0; i < zeroPrecededByOneFromRight; i++) {
            if (i < noOfOnes) {
                n = n | mask; // set the bits
            } else {
                n = n & ~mask; // unset the bits
            }
            mask <<= 1;
        }
        return n;
    }

    private static int getNextSmaller(int n) {
        int onePrecededByZeroFromRight = 0;
        int noOfZeros = 0;
        int mask = 1;

        // find the position of the bit pattern '10' from the right and then make it '01'
        for (int i = 0; i < Integer.BYTES * 8 - 1; i++) {
            if ((n & mask) == 0) {
                if ((n & mask << 1) == mask << 1) {
                    n = (n | mask) & ~(mask << 1); // swap the bits
                    break;
                }
                noOfZeros++;
            }
            onePrecededByZeroFromRight++;
            mask <<= 1;
        }

        if (onePrecededByZeroFromRight == Integer.BYTES * 8 - 1) {
            return -1;
        }

        // shift all the 0s to the right end and then fill with 1s until the bit pattern '10'
        mask = 1;
        for (int i = 0; i < onePrecededByZeroFromRight; i++) {
            if (i < noOfZeros) {
                n = n & ~mask; // unset the bits
            } else {
                n = n | mask; // set the bits
            }
            mask <<= 1;
        }
        return n;
    }

    public static void main(String[] args) {
        NextLargerAndSmallerNumber of0 = getNextLargerAndSmallerNumber(0);
        System.out.println("Next larger of 0: " + of0.nextLarger);
        System.out.println("Next smaller of 0: " + of0.nextSmaller);

        NextLargerAndSmallerNumber of2 = getNextLargerAndSmallerNumber(2);
        System.out.println("Next larger of 2: " + of2.nextLarger);
        System.out.println("Next smaller of 2: " + of2.nextSmaller);

        NextLargerAndSmallerNumber of5 = getNextLargerAndSmallerNumber(5);
        System.out.println("Next larger of 5: " + of5.nextLarger);
        System.out.println("Next smaller of 5: " + of5.nextSmaller);

        NextLargerAndSmallerNumber of7 = getNextLargerAndSmallerNumber(7);
        System.out.println("Next larger of 7: " + of7.nextLarger);
        System.out.println("Next smaller of 7: " + of7.nextSmaller);

        NextLargerAndSmallerNumber of8 = getNextLargerAndSmallerNumber(8);
        System.out.println("Next larger of 8: " + of8.nextLarger);
        System.out.println("Next smaller of 8: " + of8.nextSmaller);

        NextLargerAndSmallerNumber of15 = getNextLargerAndSmallerNumber(15);
        System.out.println("Next larger of 15: " + of15.nextLarger);
        System.out.println("Next smaller of 15: " + of15.nextSmaller);
    }
}