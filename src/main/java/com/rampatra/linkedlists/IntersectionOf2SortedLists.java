package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/27/15
 * @time: 11:13 AM
 */
public class IntersectionOf2SortedLists {

    /**
     * Returns a linked list with elements common in
     * both {@param list1} and {@param list2}.
     *
     * @param list1
     * @param list2
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> SingleLinkedList<E> getIntersectionList(SingleLinkedList<E> list1,
                                                                                    SingleLinkedList<E> list2) {

        SingleLinkedNode<E> curr1 = list1.getNode(0), curr2 = list2.getNode(0);
        SingleLinkedList<E> intersectedList = new SingleLinkedList<>();
        while (curr1 != null && curr2 != null) {
            // advance the current pointer of the list having smaller {@code item}
            if (curr1.item.compareTo(curr2.item) < 0) {
                curr1 = curr1.next;
            } else if (curr1.item.compareTo(curr2.item) > 0) {
                curr2 = curr2.next;
            } else { // both nodes are equal so add it to the result
                intersectedList.add(curr1.item);
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
        }

        return intersectedList;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList1 = new SingleLinkedList<>();
        linkedList1.add(00);
        linkedList1.add(11);
        linkedList1.add(22);
        linkedList1.add(33);
        linkedList1.add(44);
        linkedList1.add(55);
        linkedList1.printList();
        SingleLinkedList<Integer> linkedList2 = new SingleLinkedList<>();
        linkedList2.add(21);
        linkedList2.add(33);
        linkedList2.add(44);
        linkedList2.add(55);
        linkedList2.add(67);
        linkedList2.add(89);
        linkedList2.printList();
        getIntersectionList(linkedList1, linkedList2).printList();
    }
}
