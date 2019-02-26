package com.rampatra.base;

/**
 * A generic interface for LinkedList.
 *
 * @author rampatra
 * @since 6/16/15
 */
public interface LinkedList<E extends Comparable<E>> {

    /**
     * Appends the specified element to the end of this list.
     *
     * @param item
     * @return {@code true} (as specified by {@link java.util.Collection#add})
     */
    boolean add(E item);

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index
     * @param item
     * @return
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    boolean add(int index, E item);

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param item
     */
    void addFirst(E item);

    /**
     * Appends the specified element to the end of this list.
     *
     * @param item
     */
    void addLast(E item);

    /**
     * Removes all of the elements from this list.
     */
    void clear();

    /**
     * Returns a shallow copy of this LinkedList.
     *
     * @return
     */
    LinkedList<E> clone();

    /**
     * Returns true if this list contains the specified element.
     *
     * @param item
     * @return
     */
    boolean contains(E item);

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index
     * @return
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    E get(int index);

    /**
     * Returns the first element in this list.
     *
     * @return
     * @throws java.util.NoSuchElementException if this list is empty
     */
    E getFirst();

    /**
     * Returns the last element in this list.
     *
     * @return
     * @throws java.util.NoSuchElementException if this list is empty
     */
    E getLast();

    /**
     * Prints the contents of this list.
     */
    void printList();

    /**
     * Retrieves and removes the head (first element) of this list.
     *
     * @return
     * @throws java.util.NoSuchElementException if this list is empty
     */
    E remove();

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index
     * @return
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    E remove(int index);

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     *
     * @param item
     * @return {@code true} if this list contained the specified element
     */
    boolean removeItem(E item);

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index
     * @param item
     * @return
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    E set(int index, E item);

    /**
     * Returns the number of elements in this list.
     *
     * @return
     */
    int size();

}
