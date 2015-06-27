package me.ramswaroop.linkedlists;

import me.ramswaroop.common.SingleLinkedList;
import me.ramswaroop.common.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/27/15
 * @time: 5:27 PM
 */
public class DeleteAlternateNodes<E extends Comparable<E>> extends SingleLinkedList<E> {

    public static <E extends Comparable<E>> void deleteAlternateNodes(SingleLinkedList<E> list) {
        deleteAlternateNodes(list.head);
    }

    public static <E extends Comparable<E>> void deleteAlternateNodes(SingleLinkedNode<E> node) {
        if (node == null || node.next == null) return;

        node.next = node.next.next;

        deleteAlternateNodes(node.next);
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
        deleteAlternateNodes(linkedList1);
        linkedList1.printList();

    }
}
