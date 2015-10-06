package me.ramswaroop.threads;

/**
 * Created by IntelliJ IDEA.
 *
 * Question: Print first name and last name (in order) using two different threads multiple times. 
 * 
 * @author: ramswaroop
 * @date: 10/6/15
 * @time: 7:10 PM
 */
public class NamePrint {

    Object lock = new Object();

    class PrintFirstName implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    try {
                        if (i > 0) lock.wait(); // releases lock
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("Ram ");
                    lock.notify();
                }
            }
        }
    }

    class PrintLastName implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    try {
                        lock.wait(); // releases lock
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Swaroop");
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

        secondThread.start();
        firstThread.start();
    }

    public static void main(String a[]) {
        NamePrint obj = new NamePrint();
        obj.printNameUsingMultipleThreads();
    }
}
