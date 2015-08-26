package me.ramswaroop.practice;

/**
 * Created by IntelliJ IDEA.
 * User: ramswaroop
 * Date: 4/18/15
 * Time: 2:50 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class DivideByZero {
    public static void main(String[] a) {
        System.out.println(5.0/0); // doesn't throw any exception
        System.out.println(5/0); // throws runtime exception (arithmetic exception)
    }
}
