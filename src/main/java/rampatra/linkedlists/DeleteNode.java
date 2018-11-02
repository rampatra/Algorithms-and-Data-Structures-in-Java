package rampatra.linkedlists;

import com.rampatra.common.SingleLinkedList;
import com.rampatra.common.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/18/15
 * @time: 2:35 PM
 */
public class DeleteNode {

    /**
     * Given a pointer to a node, delete it.
     *
     * @param node
     * @param <E>
     */
    public static <E extends Comparable<E>> void deleteNode(SingleLinkedNode<E> node) {
        // assert node isn't the last node in the linked list
        node.item = node.next.item;
        node.next = node.next.next;
    }

    public static void main(String a[]) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(00);
        linkedList.add(11);
        linkedList.add(22);
        linkedList.printList();
        deleteNode(linkedList.getNode(1));
        linkedList.printList();
    }
}
