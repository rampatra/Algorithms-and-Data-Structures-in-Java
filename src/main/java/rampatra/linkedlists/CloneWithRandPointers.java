package rampatra.linkedlists;

import com.rampatra.common.DoubleLinkedList;
import com.rampatra.common.DoubleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/20/15
 * @time: 1:00 PM
 * @see: http://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/
 */
public class CloneWithRandPointers {

    /**
     * Clones a linked list with next pointer pointing to the
     * next node and prev pointer pointing to any random node.
     *
     * @param list
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> DoubleLinkedList<E> clone(DoubleLinkedList<E> list) {
        DoubleLinkedNode<E> firstNode = list.getNode(0);
        DoubleLinkedNode<E> curr = firstNode;

        // copy each node and insert after it
        while (curr != null) {
            DoubleLinkedNode<E> newNode = new DoubleLinkedNode<>(null, curr.item, curr.next);
            curr.next = newNode;
            curr = curr.next.next;
        }

        // copy all random pointers from original node to the copied node
        curr = firstNode;
        while (curr != null && curr.next != null) {
            curr.next.prev = (curr.prev != null) ? curr.prev.next : null;
            curr = curr.next.next;
        }

        // separate the copied nodes into a different linked list
        curr = firstNode;
        DoubleLinkedNode<E> cloneHead = firstNode.next;
        DoubleLinkedNode<E> dupNode;
        while (curr != null && curr.next != null) {
            dupNode = curr.next;
            curr.next = (dupNode != null) ? dupNode.next : null;
            dupNode.next = (curr.next != null) ? curr.next.next : null;
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
        linkedList.getNode(0).prev = null;
        linkedList.getNode(1).prev = linkedList.getNode(2);
        linkedList.getNode(2).prev = linkedList.getNode(0);
        linkedList.getNode(3).prev = linkedList.getNode(1);
        System.out.println("======Original======");
        linkedList.printList();
        DoubleLinkedList<Integer> clonedList = clone(linkedList);
        System.out.println("======Cloned======");
        clonedList.printList();
        System.out.println("======Cloned (Modified)======");
        clonedList.set(0, 234);
        clonedList.set(1, 567);
        clonedList.printList();
        System.out.println("======Original======");
        linkedList.printList();
    }
}
