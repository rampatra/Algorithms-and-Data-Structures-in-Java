package me.ramswaroop.linkedlists;

import me.ramswaroop.common.SingleLinkedList;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 7/7/15
 * @time: 1:04 PM
 */
public class IntersectionAndUnionOf2Lists {

    public static <E extends Comparable<E>> SingleLinkedList<E>[] getIntersectionAndUnion(SingleLinkedList<E> list1,
                                                                                          SingleLinkedList<E> list2) {



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
        linkedList1.printList();
        SingleLinkedList<Integer> linkedList2 = new SingleLinkedList<>();
        linkedList2.add(21);
        linkedList2.add(33);
        linkedList2.add(44);
        linkedList2.add(55);
        linkedList2.add(67);
        linkedList2.add(89);
        linkedList2.printList();
        getIntersectionAndUnion(linkedList1, linkedList2)[0].printList();
        getIntersectionAndUnion(linkedList1, linkedList2)[1].printList();
    }
}
