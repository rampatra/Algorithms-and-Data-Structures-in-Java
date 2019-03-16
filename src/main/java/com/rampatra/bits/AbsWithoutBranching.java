package com.rampatra.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/9/15
 * @time: 12:26 PM
 */
public class AbsWithoutBranching {

    /**
     * Returns the absolute value of any integer.
     * <p/>
     * EXPLANATION:
     * For example, consider int takes 4 bits:
     * So for input = -5, we have
     * -5               = 1011
     * mask             = 1111
     * mask + n         = 1010
     * (mask + n)^mask  = 0101 (which is 5)
     *
     * @param n
     * @return
     */
    public static int abs(int n) {
        int mask = n >> 31;
        return (mask + n) ^ mask;
    }

    public static void main(String[] args) {
        System.out.println(abs(-5));
        System.out.println(abs(5));
        System.out.println(abs(0));
        System.out.println(abs(-0));
    }
}
