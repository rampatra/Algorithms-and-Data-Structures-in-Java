package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/9/15
 * @time: 4:00 PM
 */
public class TripletFromThreeLinkedLists {

    public static SingleLinkedNode<Integer> findTripletWithSumEqualsTo(SingleLinkedNode<Integer> node1,
                                                                       SingleLinkedNode<Integer> node2,
                                                                       SingleLinkedNode<Integer> node3,
                                                                       int sum) {
        node2 = MergeSort.mergeSort(node2);
        node3 = MergeSort.mergeSort(node3);
        node3 = ReverseSingleLinkedList.recursiveReverseList(node3);

        SingleLinkedNode<Integer> curr1 = node1, curr2, curr3;
        int s;

        while (curr1 != null) {

            curr2 = node2;
            curr3 = node3;

            while (curr2 != null && curr3 != null) {
                s = curr1.item + curr2.item + curr3.item;

                if (s == sum) {
                    curr1.next = curr2;
                    curr2.next = curr3;
                    curr3.next = null;
                    return curr1;
                }

                if (s < sum) {
                    curr2 = curr2.next;
                } else {
                    curr3 = curr3.next;
                }
            }

            curr1 = curr1.next;

        }

        return null;

    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList1 = new SingleLinkedList<>();
        linkedList1.add(2);
        SingleLinkedList<Integer> linkedList2 = new SingleLinkedList<>();
        linkedList2.add(6);
        linkedList2.add(8);
        linkedList2.add(7);
        SingleLinkedList<Integer> linkedList3 = new SingleLinkedList<>();
        linkedList3.add(9);
        linkedList3.add(6);
        linkedList3.add(12);
        linkedList1.printList();
        linkedList2.printList();
        linkedList3.printList();
        SingleLinkedList.printList(findTripletWithSumEqualsTo(linkedList1.head,
                linkedList2.head,
                linkedList3.head,
                18));
    }
}
