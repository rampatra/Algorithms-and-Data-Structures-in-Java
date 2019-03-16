package com.rampatra.misc;

/**
 * Created by IntelliJ IDEA.
 * User: rampatra
 * Date: 3/14/15
 * Time: 4:38 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class Equals {
    public static void main(String[] args) {
        Short i = new Short((short) 12);
        Short j = new Short((short) 12);
        System.out.print(j == i); // prints false as compiler compares 2 references instead of their values
        System.out.print(12 == i); // prints true as the compiler unboxes "i" and then compares the value
    }
}
