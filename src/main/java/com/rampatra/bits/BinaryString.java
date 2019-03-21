package com.rampatra.bits;

/**
 * @author rampatra
 * @since 2019-03-21
 */
public class BinaryString {

    /**
     * Returns the binary representation of a {@code byte}.
     *
     * @param b a byte.
     * @return the binary representation of the input byte.
     */
    private static String toBinaryString(byte b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Byte.SIZE; i++) {
            sb.append(b & (byte) 1);
            b >>= 1;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(toBinaryString((byte) 0xff));
        System.out.println(toBinaryString((byte) (0xff >> 3)));
    }
}
