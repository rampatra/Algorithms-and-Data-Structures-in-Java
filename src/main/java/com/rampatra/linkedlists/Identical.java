package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/29/15
 */
public class Identical {

    /**
     * Returns {@code true} if linked list {@param list1} and {@param list2}
     * are identical i.e, the data in the nodes as well as their arrangements are
     * similar. Ex: 1->2->3 and 1->2->3 are identical.
     *
     * @param list1
     * @param list2
     * @param <E>
     * @return
     */
    private static <E extends Comparable<E>> boolean isIdentical(SingleLinkedList<E> list1,
                                                                SingleLinkedList<E> list2) {

        // base cases
        if (list1.size != list2.size) {
            return false;
        } else if (list1.size == 0) {
            return true;
        }

        SingleLinkedNode<E> curr1 = list1.getNode(0), curr2 = list2.getNode(0);

        while (curr1 != null && curr2 != null) {
            if (!curr1.item.equals(curr2.item)) {
                return false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return true;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList1 = new SingleLinkedList<>();
        linkedList1.add(0);
        linkedList1.add(1);
        linkedList1.add(2);
        linkedList1.add(3);
        linkedList1.add(4);
        linkedList1.add(5);
        linkedList1.add(6);
        linkedList1.printList();
        SingleLinkedList<Integer> linkedList2 = new SingleLinkedList<>();
        linkedList2.add(0);
        linkedList2.add(1);
        linkedList2.add(2);
        linkedList2.add(3);
        linkedList2.add(4);
        linkedList2.add(5);
        linkedList2.add(6);
        linkedList2.printList();
        System.out.println(isIdentical(linkedList1, linkedList2));
    }
}
