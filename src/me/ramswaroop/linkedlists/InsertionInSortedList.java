package me.ramswaroop.linkedlists;

import me.ramswaroop.common.SingleLinkedList;
import me.ramswaroop.common.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/21/15
 * @time: 10:20 PM
 */
public class InsertionInSortedList<E extends Comparable<E>> extends SingleLinkedList<E> {

    /**
     * Insert an element in the sorted linked list.
     *
     * @param item
     */
    public void insert(E item) {
        int index = 0;
        SingleLinkedNode<E> node = head;
        while (node != null) {
            if (item.compareTo(node.item) < 0) break;
            index++;
            node = node.next;
        }
        add(index, item);
    }

    public static void main(String a[]) {
        InsertionInSortedList<Integer> linkedList = new InsertionInSortedList<>();
        linkedList.add(00);
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.printList();
        linkedList.insert(13);
        linkedList.printList();
    }
}