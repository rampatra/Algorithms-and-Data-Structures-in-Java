package com.rampatra.misc;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 5/8/15
 * @time: 12:08 PM
 */
class MethodOverloading {

    static void go(float x) {
        System.out.print("float ");
    }

    static void go(Long x) {
        System.out.print("Long ");
    }

    static void go(double x) {
        System.out.print("double ");
    }

    static void go(Double x) {
        System.out.print("Double ");
    }

    static void go(int x, int y) {
        System.out.print("int,int ");
    }

    static void go(byte... x) {
        System.out.print("byte... ");
    }

    static void go(Long x, Long y) {
        System.out.print("Long,Long ");
    }

    static void go(long... x) {
        System.out.print("long... ");
    }

    public static void main(String[] args) {
        byte b = 5;
        short s = 5;
        long l = 5;
        float f = 5.0f;
        // widening beats autoboxing
        go(b);
        go(s);
        go(l);
        go(f);
        // widening beats var-args
        go(b, b);
        // auto-boxing beats var-args
        go(l, l);
    }
}
