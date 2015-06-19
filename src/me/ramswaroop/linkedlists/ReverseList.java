package me.ramswaroop.linkedlists;

import me.ramswaroop.common.SingleLinkedList;
import me.ramswaroop.common.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/19/15
 * @time: 9:24 AM
 */
public class ReverseList<E> extends SingleLinkedList<E> {

    public void reverseList(SingleLinkedNode<E> node) {
        SingleLinkedNode<E> prev = node;
        SingleLinkedNode<E> curr = node.next;
        prev.next = null; // this will be the last node after reversal, so make next of node = null
        while (curr != null) {
            SingleLinkedNode<E> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String a[]) {
        ReverseList<Integer> linkedList = new ReverseList<>();
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(44);
        linkedList.add(55);
        linkedList.printList();
        linkedList.reverseList(linkedList.getNode(0));
        linkedList.printList();
    }
}
