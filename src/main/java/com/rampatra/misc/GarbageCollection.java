package com.rampatra.misc;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 10/2/15
 * @time: 12:44 AM
 */
public class GarbageCollection {
    public void finalize() {
        System.out.println("object is garbage collected");
    }

    public static void main(String args[]) {
        GarbageCollection s1 = new GarbageCollection();
        GarbageCollection s2 = new GarbageCollection();
        s1 = null;
        s2 = null;
        System.gc();
    }
} 
