package com.rampatra.threads;

/**
 * Problem Description: Print first name and last name (in order) using two different threads 1000 times.
 *
 * @author rampatra
 * @since 10/6/15
 */
public class NamePrint {

    Object lock = new Object();
    volatile boolean isFirstNamePrinted = false;

    class PrintFirstName implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 1000; i++) {
                    try {
                        // wait if first name is printed but not the last name
                        if (isFirstNamePrinted) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("Ram ");
                    isFirstNamePrinted = true;
                    lock.notify();
                }
            }
        }
    }

    class PrintLastName implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 1000; i++) {
                    try {
                        // wait if first name is not printed
                        if (!isFirstNamePrinted) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Swaroop");
                    isFirstNamePrinted = false;
                    lock.notify();
                }
            }
        }
    }

    public void printNameUsingMultipleThreads() {
        Runnable printFirstName = new PrintFirstName();
        Runnable printLastName = new PrintLastName();

        Thread firstThread = new Thread(printFirstName);
        Thread secondThread = new Thread(printLastName);

        firstThread.start();
        secondThread.start();
    }

    public static void main(String[] args) {
        NamePrint obj = new NamePrint();
        obj.printNameUsingMultipleThreads();
    }
}
