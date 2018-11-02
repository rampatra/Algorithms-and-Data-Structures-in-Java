package com.rampatra.linkedlists;

import com.rampatra.common.SingleLinkedList;
import com.rampatra.common.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/18/15
 * @time: 10:34 PM
 */
public class IntersectionPointOfTwoLists {


    /**
     * Returns the node at which {@param list1} and {@param list2} intersect.
     *
     * @param list1
     * @param list2
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> SingleLinkedNode<E> getIntersectionNode(SingleLinkedList<E> list1,
                                                                                    SingleLinkedList<E> list2) {

        SingleLinkedNode<E> curr1, curr2;
        int diffLength = Math.abs(list1.size - list2.size);

        // forward the pointer in the longer list by their diff. in length
        if (list1.size > list2.size) {
            curr1 = list1.head;
            curr2 = list2.head;
        } else {
            curr1 = list2.head;
            curr2 = list1.head;
        }
        while (diffLength > 0) {
            curr1 = curr1.next;
            diffLength--;
        }

        // now compare both lists node by node
        while (curr1 != null) {
            if (curr1 == curr2) return curr1;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        // lists do not intersect
        return null;
    }

    public static void main(String a[]) {
        SingleLinkedList<Integer> linkedList1 = new SingleLinkedList<>();
        linkedList1.add(00);
        linkedList1.add(11);
        linkedList1.add(22);
        linkedList1.add(33);
        linkedList1.add(44);
        linkedList1.add(55);
        linkedList1.add(66);
        linkedList1.add(77);
        linkedList1.add(88);
        SingleLinkedList<Integer> linkedList2 = new SingleLinkedList<>();
        linkedList2.add(56);
        linkedList2.add(78);
        linkedList2.add(45);
        linkedList2.add(23);
        linkedList2.getNode(3).next = linkedList1.getNode(5); // join 2 lists at some point
        linkedList2.size = 8; // IMP: update size after joining
        System.out.println(getIntersectionNode(linkedList1, linkedList2) != null ?
                getIntersectionNode(linkedList1, linkedList2).item : "List don't intersect!");
    }
}
