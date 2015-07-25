package me.ramswaroop.linkedlists;

import me.ramswaroop.common.DoubleLinkedList;
import me.ramswaroop.common.DoubleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 7/24/15
 * @time: 3:16 PM
 */
public class SortedDLLToBBST {

    static <E extends Comparable<E>> int getLength(DoubleLinkedNode<E> node) {
        int l = 0;
        DoubleLinkedNode<E> curr = node;
        while (curr != null) {
            curr = curr.next;
            l++;
        }
        return l;
    }

    static <E extends Comparable<E>> void inOrder(DoubleLinkedNode<E> node) {
        if (node == null) return;
        inOrder(node.prev);
        System.out.print(node.item.toString());
        inOrder(node.next);
    }

    public static <E extends Comparable<E>> DoubleLinkedNode<E> sortedSLLToBBST(DoubleLinkedNode<E> node) {
        return sortedSLLToBBST(node, getLength(node));
    }

    public static <E extends Comparable<E>> DoubleLinkedNode<E> sortedSLLToBBST(DoubleLinkedNode<E> node, int n) {
        if (n <= 0) {
            return null;
        }

        DoubleLinkedNode<E> left = sortedSLLToBBST(node, n / 2);

        DoubleLinkedNode<E> root = node;
        root.prev = left;

        node = node.next;

        DoubleLinkedNode<E> right = sortedSLLToBBST(node, n - n / 2 - 1);
        root.next = right;

        return root;
    }

    public static void main(String a[]) {
        DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(44);
        linkedList.add(55);
        linkedList.add(66);
        linkedList.add(77);
        linkedList.printList();
        inOrder(sortedSLLToBBST(linkedList.head));
        System.out.println();
        linkedList.printList();
    }
}
