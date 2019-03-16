package com.rampatra.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/4/15
 * @time: 10:54 PM
 */
public class SubBit {

    /**
     * Returns the number formed with the bits from {@param start}
     * and {@param end} of {@param num} (both inclusive).
     *
     * @param num
     * @param start > 0 and <= 32
     * @param end   > 0 and <= 32
     * @return
     */
    public static int getNumberFromSubBits(int num, int start, int end) {
        return num << (32 - end) >>> (start - end + 31); // more intuitive (start - 1 + 32 - end)
    }

    public static void main(String[] args) {
        System.out.println(getNumberFromSubBits(5, 1, 2));
    }
}
