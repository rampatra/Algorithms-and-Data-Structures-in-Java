package me.ramswaroop.threads;

/**
 * Created by IntelliJ IDEA.
 * <p/>
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

        /**
         * Starting secondThread first so that secondThread starts waiting before the firstThread
         * calls notify(). But this behavior is not guaranteed as you cannot be 100% sure that 
         * secondThread will actually run before firstThread (though it may run before most of the 
         * time).
         */
        secondThread.start();
        firstThread.start();
    }

    public static void main(String a[]) {
        NamePrint obj = new NamePrint();
        obj.printNameUsingMultipleThreads();
    }
}
