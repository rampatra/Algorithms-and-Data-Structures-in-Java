package com.rampatra.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/2/15
 * @time: 12:18 PM
 */
public class PowerOf2 {

    /**
     * Power of 2 no. always has only one set bit.
     *
     * @param n
     * @return
     */
    public static boolean isPowerOf2(long n) {
        return CountSetBits.countSetBits(n) == 1;
    }

    /**
     * AND operation of power of 2 no.s and the no. minus 1 is always 0.
     * ex: 100 & 011 is 000
     *
     * @param n
     * @return
     */
    public static boolean isPowerOf2UsingANDoperator(long n) {
        return n != 0 && (n & (n - 1)) == 0; // n != 0 check added for input 0
    }

    /**
     * The following code can be found in {@link java.util.Random#nextInt(int)}.
     *
     * @param n
     * @return
     */
    public static boolean isPowerOf2FromRandomClass(long n) {
        return n != 0 && (n & -n) == n;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOf2(18));
        System.out.println(isPowerOf2UsingANDoperator(18));
        System.out.println(isPowerOf2FromRandomClass(18));

        System.out.println(isPowerOf2(16));
        System.out.println(isPowerOf2UsingANDoperator(16));
        System.out.println(isPowerOf2FromRandomClass(16));

        System.out.println(isPowerOf2(0)); // works for 0
        System.out.println(isPowerOf2UsingANDoperator(0)); // works for 0 with a check
        System.out.println(isPowerOf2FromRandomClass(0)); // works for 0 with a check

        System.out.println(isPowerOf2(-2)); // doesn't work for -ve no.s
        System.out.println(isPowerOf2UsingANDoperator(-2)); // doesn't work for -ve no.s
        System.out.println(isPowerOf2FromRandomClass(-2)); // doesn't work for -ve no.s
    }
}
