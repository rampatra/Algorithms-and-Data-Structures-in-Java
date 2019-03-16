package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/7/15
 * @time: 1:04 PM
 */
public class IntersectionAndUnionOf2Lists {

    /**
     * @param list1
     * @param list2
     * @param <E>
     * @return an array of list consisting of intersection and union of two sorted
     * list {@param list1} and {@param list2} respectively.
     */
    public static <E extends Comparable<E>> SingleLinkedList<E>[] getIntersectionAndUnion(SingleLinkedList<E> list1,
                                                                                          SingleLinkedList<E> list2) {

        SingleLinkedNode<E> curr1 = list1.head, curr2 = list2.head;
        SingleLinkedList<E> intersectionList = new SingleLinkedList<>(),
                unionList = new SingleLinkedList<>();

        MergeSort.mergeSort(curr1);
        MergeSort.mergeSort(curr2);

        while (curr1 != null || curr2 != null) {
            if (curr1 == null) {
                unionList.add(curr2.item);
                curr2 = curr2.next;
            } else if (curr2 == null) {
                unionList.add(curr1.item);
                curr1 = curr1.next;
            } else if (curr1.item.compareTo(curr2.item) < 0) {
                unionList.add(curr1.item);
                curr1 = curr1.next;
            } else if (curr1.item.compareTo(curr2.item) > 0) {
                unionList.add(curr2.item);
                curr2 = curr2.next;
            } else {
                unionList.add(curr1.item);
                intersectionList.add(curr1.item);
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
        }

        return new SingleLinkedList[]{intersectionList, unionList};
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
        System.out.println("Intersection:");
        getIntersectionAndUnion(linkedList1, linkedList2)[0].printList();
        System.out.println("Union:");
        getIntersectionAndUnion(linkedList1, linkedList2)[1].printList();
    }
}
