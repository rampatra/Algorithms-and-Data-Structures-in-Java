package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/13/15
 * @time: 12:54 PM
 */
public class MergeTwoLinkedListAlternatively {

    /**
     * Given two linked lists, insert nodes of second list into first list at
     * alternate positions of first list till there are no more positions to
     * insert in first list.
     * <p/>
     * Example,
     * Input:   L1: 5->7->17->13->11 and L2: 12->10->2->4->6
     * Output:  L1: 5->12->7->10->17->2->13->4->11->6 and L2: empty
     * <p/>
     * Input:   L1: 1->2->3 and L2: 4->5->6->7->8
     * Output:  L1: 1->4->2->5->3->6 and L2: 7->8
     *
     * @param node1
     * @param node2
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> SingleLinkedNode<E> mergeTwoLinkedListAlternatively(SingleLinkedNode<E> node1,
                                                                                                SingleLinkedNode<E> node2) {

        SingleLinkedNode<E> curr1 = node1, curr2 = node2, temp1, temp2;

        while (curr1 != null && curr2 != null) {
            temp1 = curr1.next;
            temp2 = curr2.next;

            curr1.next = curr2;
            curr2.next = temp1;

            curr1 = temp1;
            curr2 = temp2;
        }

        return curr2;

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
        linkedList2.add(99);
        linkedList2.printList();
        SingleLinkedNode<Integer> list2 = mergeTwoLinkedListAlternatively(linkedList1.head, linkedList2.head);
        linkedList1.printList();
        SingleLinkedList.printList(list2);
    }
}
