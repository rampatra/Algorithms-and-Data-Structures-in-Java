package me.ramswaroop.linkedlists;

import me.ramswaroop.common.DoubleLinkedList;
import me.ramswaroop.common.DoubleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/20/15
 * @time: 1:00 PM
 */
public class CloneWithRandPointers<E> extends DoubleLinkedList<E> {

    public static <E> DoubleLinkedList<E> clone(DoubleLinkedNode<E> node) {
        DoubleLinkedNode<E> curr = node;

        // copy node and insert after it
        while (curr != null && curr.next != null) {
            DoubleLinkedNode<E> newNode = new DoubleLinkedNode<>(null, curr.item, curr.next);
            curr.next = newNode;
            curr = curr.next.next;
        }

        curr = node;

        // copy all random pointers
        while (curr != null && curr.next != null) {
            curr.next.prev = curr.prev;
            curr = curr.next.next;
        }

        curr = node;
        DoubleLinkedNode<E> cloneHead = node.next;
        DoubleLinkedNode<E> dupNode;
        // separate the copy nodes into a different linked list
        while (curr != null) {
            dupNode = curr.next;
            curr.next = (dupNode != null) ? dupNode.next : null;
            if (dupNode != null) {
                dupNode.next = (curr.next != null) ? curr.next.next : null;
            }
            curr = curr.next;
        }
        return DoubleLinkedList.getLinkedList(cloneHead);
    }

    public static void main(String a[]) {
        DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
        linkedList.add(00);
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.getNode(0).prev = linkedList.getNode(2);
        linkedList.getNode(1).prev = linkedList.getNode(3);
        linkedList.getNode(2).prev = linkedList.getNode(0);
        linkedList.getNode(3).prev = linkedList.getNode(1);
        linkedList.printList();
        DoubleLinkedList<Integer> clonedList = clone(linkedList.getNode(0));
        clonedList.printList();
    }
}
