package com.rampatra.misc;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 9/30/15
 * @time: 9:37 AM
 */
class BigOuter {
    static class Nest {
        void go() {
            System.out.println("hi");
        }
    }
}

public class Outer {
    static class B2 {
        void goB2() {
            System.out.println("hi 2");
        }
    }

    public static void main(String[] args) {
        BigOuter.Nest n = new BigOuter.Nest();
        n.go();
        B2 b2 = new B2();
        b2.goB2();
        //B2.goB2(); not possible
    }
}
