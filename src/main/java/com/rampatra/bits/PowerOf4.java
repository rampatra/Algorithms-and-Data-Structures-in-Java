package com.rampatra.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/9/15
 * @time: 12:56 PM
 */
public class PowerOf4 {

    /**
     * Determines whether any +ve number
     * is power of 4 or not.
     *
     * @param n
     * @return
     */
    public static boolean isPowerOf4(int n) {
        int zeroBitCount = 0;
        // first check whether only 1 bit is set
        if (n > 0 && (n & (n - 1)) == 0) {
            // count no. of unset bits after the set bit
            while (n > 1) {
                zeroBitCount++;
                n >>= 1;
            }
            // if no. of unset bits are even then its a power of 4
            return zeroBitCount % 2 == 0;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOf4(0));
        System.out.println(isPowerOf4(1));
        System.out.println(isPowerOf4(4));
        System.out.println(isPowerOf4(16));
        System.out.println(isPowerOf4(18));
        System.out.println(isPowerOf4(64));
    }
}
