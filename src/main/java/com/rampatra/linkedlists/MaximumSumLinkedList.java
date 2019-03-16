package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/15/15
 * @time: 12:12 AM
 */
public class MaximumSumLinkedList {

    /**
     * Constructs a linked list that contains maximum sum path from start to end
     * from two linked lists starting at {@param node1} and {@param node2}.
     * <p/>
     * Example,
     * Input:
     * List1 =  1->3->30->90->120->240->511
     * List2 =  0->3->12->32->90->125->240->249
     * <p/>
     * Output: Following is maximum sum linked list out of two input lists
     * List =  1->3->12->32->90->125->240->511
     * <p/>
     * NOTE: We switch at 3 and 240 to get above maximum sum linked list
     *
     * @param node1
     * @param node2
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> SingleLinkedNode<E> maximumSumLinkedList(SingleLinkedNode<E> node1,
                                                                                     SingleLinkedNode<E> node2) {

        boolean isList1 = true;
        SingleLinkedNode<E> head = node1, node = node1, curr1 = node1.next, curr2 = node2.next;

        while (curr1 != null || curr2 != null) {
            // if either of the list runs out first
            if (curr1 == null) {
                // check whether we are in list 1 currently
                if (isList1) break;

                node.next = curr2;
                node = node.next;
                curr2 = curr2.next;
                continue;
            }
            if (curr2 == null) {
                // check whether we are in list 2 currently
                if (!isList1) break;

                node.next = curr1;
                node = node.next;
                curr1 = curr1.next;
                continue;
            }

            // switch lists once both node values match
            if (curr1.item.compareTo(curr2.item) == 0) {
                isList1 = !isList1;
            }
            if (isList1) {
                node.next = curr1;
            } else {
                node.next = curr2;
            }
            node = node.next;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return head;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList1 = new SingleLinkedList<>();
        linkedList1.add(00);
        linkedList1.add(11);
        linkedList1.add(22);
        linkedList1.add(33);
        linkedList1.add(44);
        linkedList1.add(55);
        linkedList1.add(88);
        linkedList1.add(90);
        linkedList1.printList();
        SingleLinkedList<Integer> linkedList2 = new SingleLinkedList<>();
        linkedList2.add(12);
        linkedList2.add(21);
        linkedList2.add(26);
        linkedList2.add(33);
        linkedList2.add(34);
        linkedList2.add(67);
        linkedList2.printList();
        SingleLinkedList.printList(maximumSumLinkedList(linkedList1.head, linkedList2.head));
    }
}
