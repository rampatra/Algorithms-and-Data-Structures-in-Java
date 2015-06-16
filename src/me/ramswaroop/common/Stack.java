package me.ramswaroop.common;

/**
 * Created by IntelliJ IDEA.
 * User: ramswaroop
 * Date: 4/3/15
 * Time: 9:47 AM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public interface Stack<E> {
    /**
     * Pushes an item onto the top of this stack.
     *
     * @param item
     */
    public E push(E item);

    /**
     * Removes the object at the top of this stack and returns it.
     * This method throws an exception if this queue is empty.
     *
     * @return
     */
    public E pop();

    /**
     * Looks at the object at the top of this stack without
     * removing it from the stack. This method throws an
     * exception if this queue is empty.
     *
     * @return
     */
    public E peek();

    /**
     * Returns the number of items currently in the stack.
     *
     * @return
     */
    public int size();

    /**
     * Tests if this stack is empty.
     *
     * @return
     */
    public boolean isEmpty();

    /**
     * Prints the content of the stack.
     */
    public void print();
}
