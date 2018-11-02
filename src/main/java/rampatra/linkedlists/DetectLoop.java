package rampatra.linkedlists;

import com.rampatra.common.SingleLinkedList;
import com.rampatra.common.SingleLinkedNode;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/19/15
 * @time: 9:24 AM
 */
public class DetectLoop {

    /**
     * Uses Flyod's Cycle Finding algorithm.
     * <p/>
     * This is the fastest method. Traverse
     * linked list using two pointers. Move one
     * pointer by one and other pointer by two.
     * If these pointers meet at some node then
     * there is a loop. If pointers do not meet
     * then linked list does not have loop.
     * <p/>
     * Time:    O(n)
     * Space:   O(1)
     *
     * @param list
     * @return
     */
    public static <E extends Comparable<E>> boolean isLoopPresent(SingleLinkedList<E> list) {
        SingleLinkedNode<E> slow = list.head, fast = slow.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    /**
     * Uses HashMap to store visited nodes.
     * <p/>
     * Time:    O(n)
     * Space:   O(n)
     *
     * @param node
     * @return
     */
    public static <E extends Comparable<E>> boolean isLoopPresentUsingHashMap(SingleLinkedNode<E> node) {
        HashMap<SingleLinkedNode<E>, Boolean> map = new HashMap<>();
        SingleLinkedNode<E> curr = node;
        while (curr != null) {
            if (map.get(curr) != null && map.get(curr) == true) {
                return true;
            }
            map.put(curr, true);
            curr = curr.next;
        }
        return false;
    }

    public static void main(String a[]) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(00);
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(44);
        linkedList.add(55);
        linkedList.getNode(4).next = linkedList.getNode(3);
        System.out.println(isLoopPresent(linkedList));
    }
}
