package com.rampatra.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Problem Description: A simple Producer/Consumer using the Lock and Condition Api pattern. For the language primitive,
 * i.e, synchronize and wait/notify pattern, please see {@link ProducerConsumerUsingWaitNotify}.
 * <p>
 * <p>
 * There are a few advantages of going with the Lock Api pattern instead of the language primitive synchronize and
 * wait/notify pattern:
 * <p>
 * - Can be interrupted which means that the application won't continue to run forever in weird situations. Consider this
 * example, what happens if the Consumer starts first and there are no elements to consume and the Producer also fails
 * due to some exception. In wait/notify the Consumer would stall forever. You would have to restart the JVM to get
 * rid of this. However, with Lock api, you can use {@link Lock#lockInterruptibly()}.
 * <p>
 * - Timed lock acquisition. You can try to acquire a lock and if it is not instantly available then do something else.
 * See {@link Lock#tryLock()} to learn more. You can also wait for a certain amount of time before giving up with the
 * {@link Lock#tryLock(long, TimeUnit)} method. This isn't possible with the primitive pattern.
 * <p>
 * - A fair Lock generates a fair Condition. Fair here means the first thread in the waiting queue will be picked first
 * by the scheduler. This is a costly operation so use it only when necessary.
 *
 * @author rampatra
 * @since 2019-07-10
 */
public class ProducerConsumerUsingLockApi {

    private static int currSize = 0;
    private static int totalSize = 10;
    private static int[] buffer = new int[totalSize];
    private static Lock lock = new ReentrantLock();
    private static Condition isEmpty = lock.newCondition();
    private static Condition isFull = lock.newCondition();

    static class Producer {
        static void produce() {
            try {

                lock.lock();
                while (currSize >= totalSize) {
                    isFull.await();
                }
                buffer[currSize++] = 1;
                isEmpty.signal();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class Consumer {
        static void consume() {
            try {

                lock.lock();
                while (currSize <= 0) {
                    isEmpty.await();
                }
                System.out.println(buffer[--currSize]);
                isFull.signal();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable producerTask = () -> {
            for (int i = 0; i < 1000; i++) {
                Producer.produce();
            }
        };

        Runnable consumerTask = () -> {
            for (int i = 0; i < 1000; i++) {
                Consumer.consume();
            }
        };

        executorService.submit(producerTask);
        executorService.submit(consumerTask);

        executorService.awaitTermination(3000, TimeUnit.MILLISECONDS);

        // as produce() and consume() are called equal number of times, this should be zero in the end
        System.out.println("Buffer Size: " + currSize);

        executorService.shutdown();
    }
}