package com.rampatra.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/5/15
 * @time: 3:50 PM
 */
public class FlippingBits {

    /**
     * Returns the number by flipping/inverting its bits using
     * XOR operation with 1......11 (size of int i.e, 32 1's).
     *
     * @param n
     * @return
     */
    public static int getNumberByFlippingBits(int n) {
        return n ^ 0xffffffff; // equivalent to 11....1 (32 times) in binary
    }

    /**
     * Returns the number by flipping/inverting its bits using
     * the NOT operator.
     *
     * @param n
     * @return
     */
    public static int getNumberByFlippingBits_V1(int n) {
        return ~n;
    }

    public static void main(String[] args) {
        System.out.println(getNumberByFlippingBits(5));
        System.out.println(getNumberByFlippingBits_V1(5));
    }
}

/**
 * EXPLANATION:
 * <p>
 * For input: 5
 * <p>
 * Binary:    000.....101
 * Inverted:  111.....010 (which is the 2's compliment of -6)
 * <p>
 * Therefore, result is -6.
 */
