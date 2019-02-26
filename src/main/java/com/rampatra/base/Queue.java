package com.rampatra.base;

/**
 * A generic interface for a queue.
 *
 * @author rampatra
 * @since 4/12/15
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
