package com.rampatra.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/14/15
 * @time: 12:24 AM
 */
public class OppositeSign {

    public static int isOppositeSign(int a, int b) {
        return (a ^ b) >>> 31;
    }

    public static void main(String[] args) {
        System.out.println(isOppositeSign(-5, -3));
        System.out.println(isOppositeSign(-5, 3));
        System.out.println(isOppositeSign(5, -3));
    }
}
