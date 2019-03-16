package com.rampatra.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/3/15
 * @time: 3:50 PM
 */

/**
 * PARITY: Parity of a number refers to whether it
 * contains an odd or even number of 1-bits. The number
 * has “odd parity”, if it contains odd number of 1-bits
 * and is “even parity” if it contains even number of 1-bits.
 */
public class Parity {

    /**
     * Uses BRIAN KERNIGAN'S bit counting. Acc. to this, the  right most/least significant set bit is unset
     * in each iteration. The time complexity is proportional to the number of bits set.
     * <p>
     * {@see http://stackoverflow.com/questions/12380478/bits-counting-algorithm-brian-kernighan-in-an-integer-time-complexity}
     * {@see http://graphics.stanford.edu/~seander/bithacks.html#ParityNaive}
     *
     * @param n
     * @return
     */
    public static boolean isEvenParity(long n) {
        boolean parity = true;

        while (n > 0) {
            parity = !parity;
            n = n & (n - 1);
        }
        return parity;
    }


    /**
     * Old school method
     *
     * @param n
     * @return true if {@param n} has even number of 1-bits
     */
    public static boolean isEvenParityByCountingSetBits(long n) {
        int setBitsCount = 0;

        while (n > 0) {
            if ((n & 1) == 1) setBitsCount++;
            n >>= 1;
        }

        return setBitsCount % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(isEvenParity(0));
        System.out.println(isEvenParity(1));
        System.out.println(isEvenParity(5));
        System.out.println(isEvenParity(6));
        System.out.println(isEvenParity(7));
        System.out.println(isEvenParity(12));
        System.out.println("==========================");
        System.out.println(isEvenParityByCountingSetBits(0));
        System.out.println(isEvenParityByCountingSetBits(1));
        System.out.println(isEvenParityByCountingSetBits(5));
        System.out.println(isEvenParityByCountingSetBits(6));
        System.out.println(isEvenParityByCountingSetBits(7));
        System.out.println(isEvenParityByCountingSetBits(12));
    }
}
