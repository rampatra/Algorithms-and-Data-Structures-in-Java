package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/3/15
 * @time: 3:07 PM
 */
public class RotateLinkedList {

    /**
     * Rotates the {@param list} anti-clockwise by {@param k} nodes.
     *
     * @param list
     * @param k
     * @param <E>
     */
    public static <E extends Comparable<E>> void rotateCounterClockwise(SingleLinkedList<E> list, int k) {
        int clockwiseK = list.size - k;
        rotateClockwise(list, clockwiseK);
    }


    /**
     * Rotates the {@param list} clockwise by {@param k} nodes.
     * <p/>
     * Example,
     * <p/>
     * Input:   [0,11,22,33,44,55] and k = 2
     * Output:  [22,33,44,55,0,11]
     *
     * @param list
     * @param k
     * @param <E>
     */
    public static <E extends Comparable<E>> void rotateClockwise(SingleLinkedList<E> list, int k) {
        int i = 0;
        SingleLinkedNode<E> curr = list.head, end = curr;

        // get a pointer to the last node
        while (end.next != null) {
            end = end.next;
        }

        // start moving first k nodes from start to end
        while (i < k && k < list.size) {
            end.next = curr;
            end = end.next;
            curr = curr.next;
            i++;
        }

        // change head to k+1 node
        list.head = curr;
        end.next = null;

    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(00);
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(44);
        linkedList.add(55);
        linkedList.printList();
        rotateClockwise(linkedList, 2);
        linkedList.printList();
        rotateCounterClockwise(linkedList, 2);
        linkedList.printList();
    }
}
