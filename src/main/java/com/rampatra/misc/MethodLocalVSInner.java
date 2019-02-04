package com.rampatra.misc;

/**
 * Created by IntelliJ IDEA.
 * User: rampatra
 * Date: 4/14/15
 * Time: 11:39 AM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
class A {
    void m() {
        System.out.println("outer");
    }
}

public class MethodLocalVSInner {

    public static void main(String[] args) {
        new MethodLocalVSInner().go();
    }

    void go() {
        new A().m();
        class A {
            void m() {
                System.out.println("inner");
            }
        }
    }

    class A {
        void m() {
            System.out.println("middle");
        }
    }
}
