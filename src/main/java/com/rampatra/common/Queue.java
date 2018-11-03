package com.rampatra.common;

/**
 * Created by IntelliJ IDEA.
 * User: ramswaroop
 * Date: 4/12/15
 * Time: 10:39 AM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public interface Queue<E> {


    /**
     * Inserts the specified element into this queue.
     *
     * @param item
     * @return
     */
    public E add(E item);


    /**
     * Retrieves and removes the head of this queue. This method throws an
     * exception if this queue is empty.
     *
     * @return
     */
    public E remove();


    /**
     * Retrieves, but does not remove, the head of this queue. This method throws an
     * exception if this queue is empty.
     *
     * @return
     */
    public E element();


    /**
     * Returns the size of this queue.
     *
     * @return
     */
    public int size();


    /**
     * Tests whether the queue is empty or not.
     *
     * @return
     */
    public boolean isEmpty();


    /**
     * Prints the content of the queue.
     */
    public void print();


}
