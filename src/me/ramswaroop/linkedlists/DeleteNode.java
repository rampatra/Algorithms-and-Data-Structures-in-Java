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

    }

    public static void main(String a[]) {
        DeleteNode<Integer> linkedList = new DeleteNode<>();
        linkedList.add(34);
        linkedList.add(64);
        linkedList.add(43);
        linkedList.deleteNode(linkedList.getNode(1));
        linkedList.printList();
    }
}
