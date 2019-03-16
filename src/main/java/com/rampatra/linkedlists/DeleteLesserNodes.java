package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/30/15
 * @time: 5:13 PM
 */
public class DeleteLesserNodes {

    /**
     * Delete a node from {@param list} if there are any nodes
     * with values greater than node on the right hand side of the list.
     * <p/>
     * Example:
     * <p/>
     * Input:   12->15->10->11->5->6->2->3->NULL
     * Output:  15->11->6->3->NULL
     * <p/>
     * Input:   10->20->30->40->50->60->NULL
     * Output:  60->NULL
     * <p/>
     * Input:   60->50->40->30->20->10->NULL
     * Output:  60->50->40->30->20->10->NULL
     *
     * @param list
     * @param <E>
     */
    public static <E extends Comparable<E>> void deleteLesserNodes(SingleLinkedList<E> list) {

        // reverse the list
        ReverseSingleLinkedList.reverseList(list);

        E max;
        SingleLinkedNode<E> curr = list.getNode(0), prev = curr;

        max = curr.item;

        while (curr != null) {
            if (curr.item.compareTo(max) >= 0) {
                max = curr.item;
                prev = curr;
            } else {
                prev.next = curr.next;
            }

            curr = curr.next;
        }

        // reverse the list
        ReverseSingleLinkedList.reverseList(list);
    }


    /**
     * Recursive version of {@link #deleteLesserNodes(SingleLinkedList)}.
     *
     * @param node
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> SingleLinkedNode<E> deleteLesserNodes(SingleLinkedNode<E> node) {
        if (node == null) return null;

        SingleLinkedNode<E> next = deleteLesserNodes(node.next);
        node.next = next;

        if (next != null && node.item.compareTo(next.item) < 0) {
            return next;
        } else {
            return node;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(00);
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(44);
        linkedList.add(55);
        linkedList.add(66);
        linkedList.printList();
        deleteLesserNodes(linkedList);
        linkedList.printList();
        // for recursive version
        linkedList.add(00);
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(44);
        linkedList.add(55);
        linkedList.printList();
        linkedList.printList(deleteLesserNodes(linkedList.head));
    }
}
