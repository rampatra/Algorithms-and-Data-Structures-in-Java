package me.ramswaroop.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/3/15
 * @time: 11:56 PM
 */
public class RightmostSetBit {

    public static int getRightmostSetBitPosition(long n) {
        int position = 0;
        while (n > 0) {
            position++;
            if ((n & 1) == 1) {
                break;
            }
            n >>= 1;
        }
        return position;
    }

    public static long unsetRightmostSetBit(long n) {
        return n & (n - 1);
    }

    public static void main(String a[]) {
        System.out.println(getRightmostSetBitPosition(0));
        System.out.println(getRightmostSetBitPosition(1));
        System.out.println(getRightmostSetBitPosition(2));
        System.out.println(getRightmostSetBitPosition(5));
        System.out.println(getRightmostSetBitPosition(18));
        System.out.println(getRightmostSetBitPosition(19));

        System.out.println("========================");

        System.out.println(unsetRightmostSetBit(0));
        System.out.println(unsetRightmostSetBit(2));
        System.out.println(unsetRightmostSetBit(12));
        System.out.println(unsetRightmostSetBit(16));
        System.out.println(unsetRightmostSetBit(18));
        System.out.println(unsetRightmostSetBit(-1));
    }
}
