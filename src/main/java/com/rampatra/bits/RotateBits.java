package com.rampatra.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/8/15
 * @time: 5:12 PM
 * <p/>
 * A ROTATION (OR CIRCULAR SHIFT) is an operation similar to
 * shift except that the bits that fall off at one end are put
 * back to the other end.
 * <p/>
 * For example, 000…11100101 becomes 00..0011100101000 if the number
 * is rotated 3 times towards left and becomes 101000..0011100 if the
 * number is rotated 3 times towards right.
 */
public class RotateBits {

    public static int leftRotateBits(int n, int times) {
        return n << times | n >>> (32 - times);
    }

    public static int rightRotateBits(int n, int times) {
        return n >>> times | n << (32 - times);
    }

    public static void main(String[] args) {
        System.out.println(leftRotateBits(5, 3));
        System.out.println(leftRotateBits(234324, 3));
        System.out.println(rightRotateBits(5, 3));
        System.out.println(rightRotateBits(234324, 3));
    }
}
