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
public class IsPalindrome<E> extends SingleLinkedList<E> {

    /**
     * Recursive function to test whether a linked list
     * is palindrome or not.
     * <p/>
     * NOTE: This method moves the head reference. (disadvantage)
     *
     * @param node
     * @return
     */
    public boolean isPalindrome(SingleLinkedNode<E> node) {
        if (node == null) return true;

        boolean isPalindrome = isPalindrome(node.next);

        if (head.item == node.item) {
            head = head.next;
            return isPalindrome;
        } else {
            return false;
        }
    }

    public static void main(String a[]) {
        IsPalindrome<Integer> linkedList = new IsPalindrome<>();
        linkedList.add(00);
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(11);
        linkedList.add(00);
        linkedList.printList();
        System.out.println(linkedList.isPalindrome(linkedList.getNode(0)));
    }
}
