package com.rampatra.threads;

/**
 * Problem Description: A simple Producer/Consumer using Synchronize and Wait/Notify pattern. For a better
 * solution, please see {@link ProducerConsumerUsingLockApi}.
 *
 * @author rampatra
 * @since 2019-06-30
 */
public class ProducerConsumerUsingWaitNotify {

    private static int currSize = 0;
    private static int totalSize = 10;
    private static int[] buffer = new int[totalSize];
    private static final Object lock = new Object();

    static class Producer {
        void produce() throws InterruptedException {
            synchronized (lock) {
                if (isFull()) {
                    lock.wait();
                }
                buffer[currSize++] = 1;
                lock.notify();
            }
        }
    }

    static class Consumer {
        void consume() throws InterruptedException {
            synchronized (lock) {
                if (isEmpty()) {
                    lock.wait();
                }
                System.out.println(buffer[--currSize]);
                lock.notify();
            }
        }
    }

    private static boolean isFull() {
        return currSize >= totalSize - 1; // as index starts from zero
    }

    private static boolean isEmpty() {
        return currSize == 0;
    }

    public static void main(String[] args) throws InterruptedException {

        Runnable producerTask = () -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    new Producer().produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumerTask = () -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    new Consumer().consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread producer = new Thread(producerTask);
        Thread consumer = new Thread(consumerTask);

        // start both the threads
        producer.start();
        consumer.start();

        // wait for both the threads to complete
        producer.join();
        consumer.join();

        // as produce() and consume() are called equal number of times, this should be zero in the end
        System.out.println("Buffer Size: " + currSize);
    }
}