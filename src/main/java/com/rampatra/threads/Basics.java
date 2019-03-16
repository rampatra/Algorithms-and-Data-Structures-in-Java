package com.rampatra.threads;

/**
 * Created by IntelliJ IDEA.
 * User: rampatra
 * Date: 4/15/15
 * Time: 11:27 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class Basics {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                    }
                    System.out.println("====== " + Thread.currentThread().getName() + " woke up ======");
                }
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

        t1.setName("T1");
        t2.setName("T2");
        t3.setName("T3");

        t1.start();
        t2.start();
        t3.start();
    }
}
