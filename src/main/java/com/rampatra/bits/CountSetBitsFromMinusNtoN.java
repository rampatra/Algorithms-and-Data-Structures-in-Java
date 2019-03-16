package com.rampatra.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/22/15
 * @time: 12:42 PM
 */
public class CountSetBitsFromMinusNtoN {

    /**
     * Explanation:
     * <p>
     * -3:  101
     * -2:  110
     * -1:  111
     * 0:   000
     * 1:   001
     * 2:   010
     * 3:   110
     * <p>
     * If you fold the above representation between -1 and 0, the total no. of set bits from -3 to 2
     * will be equal to the total no. of bits in nos. from -3 to 2.
     *
     * @param n
     * @return
     */
    public static int countSetBitsFromMinusNtoN(int n) {
        return n * 32 + CountSetBits.countSetBits((long) n); // 32 because int is of 32 bits in java
    }

    public static void main(String[] args) {
        System.out.println(countSetBitsFromMinusNtoN(3));
        System.out.println(countSetBitsFromMinusNtoN(0));
        System.out.println(countSetBitsFromMinusNtoN(9));
    }
}
