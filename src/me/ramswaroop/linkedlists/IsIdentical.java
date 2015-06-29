package me.ramswaroop.linkedlists;

import me.ramswaroop.common.SingleLinkedList;
import me.ramswaroop.common.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/29/15
 * @time: 9:42 AM
 */
public class IsIdentical {

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
    public static <E extends Comparable<E>> boolean isIdentical(SingleLinkedList<E> list1,
                                                                SingleLinkedList<E> list2) {

        // base cases
        if (list1.size != list2.size) {
            return false;
        } else if (list1.size == 0 && list2.size == 0) {
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

    public static void main(String a[]) {
        SingleLinkedList<Integer> linkedList1 = new SingleLinkedList<>();
        linkedList1.add(00);
        linkedList1.add(11);
        linkedList1.add(22);
        linkedList1.add(33);
        linkedList1.add(44);
        linkedList1.add(55);
        linkedList1.add(66);
        linkedList1.printList();
        SingleLinkedList<Integer> linkedList2 = new SingleLinkedList<>();
        linkedList2.add(00);
        linkedList2.add(11);
        linkedList2.add(22);
        linkedList2.add(33);
        linkedList2.add(44);
        linkedList2.add(55);
        linkedList2.add(66);
        linkedList2.printList();
        System.out.println(isIdentical(linkedList1, linkedList2));
    }
}
