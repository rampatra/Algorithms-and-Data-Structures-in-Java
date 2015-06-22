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
public class RemoveDuplicates<E extends Comparable<E>> extends SingleLinkedList<E> {

    /**
     * Removes duplicates in a sorted linked list
     * by traversing it once.
     *
     * @param list
     * @param <E>
     */
    public static <E extends Comparable<E>> void removeDuplicates(SingleLinkedList<E> list) {
        SingleLinkedNode<E> firstNode = list.getNode(0), curr = firstNode;
        int index = 0;
        while (curr != null) {
            while (curr.next != null && curr.item == curr.next.item) {
                list.remove(index + 1);
            }
            index++;
            curr = curr.next;
        }
    }

    public static void main(String a[]) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(00);
        linkedList.add(00);
        linkedList.add(00);
        linkedList.add(11);
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(22);
        linkedList.add(22);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(33);
        linkedList.add(33);
        linkedList.add(33);
        linkedList.printList();
        removeDuplicates(linkedList);
        linkedList.printList();
    }
}
