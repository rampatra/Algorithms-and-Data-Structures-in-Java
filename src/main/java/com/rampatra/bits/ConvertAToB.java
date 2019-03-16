package com.rampatra.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/7/15
 * @time: 1:53 PM
 */
public class ConvertAToB {

    /**
     * Returns the number of bits required to be
     * flipped to convert {@param a} to {@param b}.
     *
     * @param a
     * @param b
     * @return
     */
    public static int getBitsToConvertAToB(int a, int b) {
        return CountSetBits.countSetBits(a ^ b);
    }

    public static void main(String[] args) {
        System.out.println(getBitsToConvertAToB(3, 4));
        System.out.println(getBitsToConvertAToB(3, 5));
        System.out.println(getBitsToConvertAToB(5, 3));
    }
}
