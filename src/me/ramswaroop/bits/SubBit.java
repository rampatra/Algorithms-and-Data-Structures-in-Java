package me.ramswaroop.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/4/15
 * @time: 10:54 PM
 */
public class SubBit {

    /**
     * Returns the number formed with the bits from {@param start}
     * and {@param end} of {@param num} (both inclusive).
     *
     * @param num
     * @param start > 0
     * @param end > 0
     * @return
     */
    public static int getSubBits(int num, int start, int end) {
        return num << (32 - end) >>> (start - end + 31); // more intuitive (start - 1 + 32 - end)
    }

    public static void main(String a[]) {
        System.out.println(getSubBits(5, 1, 2));
    }
}
