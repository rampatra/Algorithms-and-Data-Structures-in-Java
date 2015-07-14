package me.ramswaroop.linkedlists;

import me.ramswaroop.common.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 7/15/15
 * @time: 12:12 AM
 */
public class MaximumSumLinkedList {

    /**
     * Constructs a linked list that contains maximum sum path from start to end
     * from two linked lists starting at {@param node1} and {@param node2}.
     *
     * Example,
     * Input:
     * List1 =  1->3->30->90->120->240->511
     * List2 =  0->3->12->32->90->125->240->249
     *
     * Output: Following is maximum sum linked list out of two input lists
     * List =  1->3->12->32->90->125->240->511
     *
     * NOTE: We switch at 3 and 240 to get above maximum sum linked list
     *
     * @param node1
     * @param node2
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> SingleLinkedNode<E> maximumSumLinkedList(SingleLinkedNode<E> node1,
                                                                                     SingleLinkedNode<E> node2) {

        SingleLinkedNode<E> node = node1, curr1 = node1, curr2 = node2;

        while (curr1 != null && curr2 != null) {


            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return node;
    }

    public static void main(String a[]) {

    }
}
