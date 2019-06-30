package com.rampatra.threads;


import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * Problem Description: Deadlock example.
 *
 * @author rampatra
 * @since 2019-03-13
 */
public class SimpleDeadlock implements Runnable {

    private final Object obj1;
    private final Object obj2;

    private SimpleDeadlock(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public void run() {
        try {
            synchronized (obj1) {
                // sleep for some time so that the next thread starts and acquires the other lock in the mean time
                Thread.sleep(5000);
                synchronized (obj2) {
                    System.out.println("No deadlock!");
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        Object obj1 = new Object();
        Object obj2 = new Object();

        Thread thread1 = new Thread(new SimpleDeadlock(obj1, obj2));
        Thread thread2 = new Thread(new SimpleDeadlock(obj2, obj1)); // note here that the object order is different

        thread1.start();
        thread2.start();

        // a way to detect deadlocks, although an expensive one
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        while (true) {
            long[] deadlock = threadMXBean.findDeadlockedThreads();
            if (deadlock != null && deadlock.length > 0) {
                System.out.println("Deadlock detected, exiting now...");
                System.exit(1);
            }
        }
    }
}