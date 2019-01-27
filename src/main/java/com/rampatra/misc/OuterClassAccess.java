package com.rampatra.misc;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 11/13/15
 * @time: 11:39 AM
 */
public class OuterClassAccess {
    private int size = 7;
    private static int length = 3;

    public static void main(String[] args) {
        new OuterClassAccess().go();
    }

    void go() {
        int size = 5;
        System.out.println(new Inner().adder());
    }

    class Inner {
        int adder() {
            return size * length; // inner class can access static members of outer class
        }
    }
}
