package com.rampatra.bits;

import java.nio.ByteOrder;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/5/15
 * @time: 3:10 PM
 * @link http://www.cs.umd.edu/class/sum2003/cmsc311/Notes/Data/endian.html
 */
public class LittleAndBigEndian {

    public static boolean isLittleEndian() {
        return ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN);
    }

    public static void main(String[] args) {
        System.out.println(isLittleEndian());
    }
}
