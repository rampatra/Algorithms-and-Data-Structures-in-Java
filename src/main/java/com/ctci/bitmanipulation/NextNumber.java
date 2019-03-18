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
        int rightmostNonTrailingZero = 0;
        int noOfZeros = 0;
        int noOfOnes = 0;
        int temp = n;

        /* Count the number of zeros and ones until the rightmost non-trailing zero
            For example, see below:       
               
                n = 10110110011110
                            ^
         */
        while ((temp & 1) == 0 && temp != 0) {
            noOfZeros++;
            temp >>>= 1;
        }

        while ((temp & 1) == 1 && temp != 0) {
            noOfOnes++;
            temp >>>= 1;
        }
        
        if (noOfZeros + noOfOnes == 31 || noOfZeros + noOfOnes == 0) {
            return -1;
        }

        /* Flip the bit and then shift all the 1s to the right end and then fill with 0s until the bit pattern '01.
            For example, consider the above number: 
                    n = 10110110011110 (original)
                                ^
                    n = 10110110111110 (after flip bit)
                                ^    
          next larger = 10110110100111 (the 1s are shifted to the right end and 0s to the left but before the rightmostNonTrailingZero)
                                ^  
         */
        rightmostNonTrailingZero = noOfOnes + noOfZeros;
        n |= 1 << rightmostNonTrailingZero; // set the rightmost non-trailing zero
        n &= ~((1 << rightmostNonTrailingZero) - 1); // unset all bits until rightmost non-trailing zero
        n |= (1 << noOfOnes - 1) - 1; // set (noOfOnes - 1) bits from the right

        return n;
    }

    private static int getNextSmaller(int n) {
        int rightmostNonTrailingOne = 0;
        int noOfZeros = 0;
        int noOfOnes = 0;
        int temp = n;
        
        while ((temp & 1) == 1 && temp != 0) {
            noOfOnes++;
            temp >>>= 1;
        }
        
        if (temp == 0) {
            return -1;
        }

        while ((temp & 1) == 0 && temp != 0) {
            noOfZeros++;
            temp >>>= 1;
        }
        
        rightmostNonTrailingOne = noOfZeros + noOfOnes;
        n &= ~(1 << rightmostNonTrailingOne); // unset the rightmost non-trailing one
        n |= (1 << rightmostNonTrailingOne - 1); // set all the bits until rightmost non-trailing one
        n &= ~((1 << noOfZeros - 1) - 1); // unset (noOfZeros - 1) bits from the right
        
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