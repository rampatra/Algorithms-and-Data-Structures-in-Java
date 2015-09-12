package me.ramswaroop.misc;

/**
 * Created by IntelliJ IDEA.
 * User: ramswaroop
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
        class A {
            void m() {
                System.out.println("inner");
            }
        }
        new A().m();
    }

    class A {
        void m() {
            System.out.println("middle");
        }
    }
}
