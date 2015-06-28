package me.ramswaroop.linkedlists;

import me.ramswaroop.common.SingleLinkedList;
import me.ramswaroop.common.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/27/15
 * @time: 8:47 PM
 */
public class MergeTwoSortedLists<E extends Comparable<E>> extends SingleLinkedList<E> {

    /**
     * Merges two sorted list {@param list1} and {@param list2} into
     * a list with values in ascending order.
     *
     * @param list1
     * @param list2
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> SingleLinkedList<E> mergeTwoSortedLists(SingleLinkedList<E> list1,
                                                                                    SingleLinkedList<E> list2) {
        SingleLinkedNode<E> curr1 = list1.getNode(0), curr2 = list2.getNode(0);
        SingleLinkedList<E> intersectedList = new SingleLinkedList<>();
        while (curr1 != null || curr2 != null) {
            // handle cases where either of the list run out first
            if (curr1 == null) {
                intersectedList.add(curr2.item);
                curr2 = curr2.next;
                continue;
            }
            if (curr2 == null) {
                intersectedList.add(curr1.item);
                curr1 = curr1.next;
                continue;
            }

            // advance the current pointer of the list having smaller {@code item}
            if (curr1.item.compareTo(curr2.item) < 0) {
                intersectedList.add(curr1.item);
                curr1 = curr1.next;
            } else if (curr1.item.compareTo(curr2.item) > 0) {
                intersectedList.add(curr2.item);
                curr2 = curr2.next;
            } else { // both nodes are equal so add both to the result
                intersectedList.add(curr1.item);
                intersectedList.add(curr1.item);
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
        }

        return intersectedList;
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
        mergeTwoSortedLists(linkedList1, linkedList2).printList();
    }
}
