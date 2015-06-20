package me.ramswaroop.linkedlists;

import me.ramswaroop.common.SingleLinkedList;
import me.ramswaroop.common.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/18/15
 * @time: 2:35 PM
 */
public class DeleteNode<E> extends SingleLinkedList<E> {

    public void deleteNode(SingleLinkedNode<E> node) {
        // assert node isn't the last node in the linked list
        node.item = node.next.item;
        node.next = node.next.next;
    }

    public static void main(String a[]) {
        DeleteNode<Integer> linkedList = new DeleteNode<>();
        linkedList.add(00);
        linkedList.add(11);
        linkedList.add(22);
        linkedList.printList();
        linkedList.deleteNode(linkedList.getNode(1));
        linkedList.printList();
    }
}
