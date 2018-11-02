package rampatra.linkedlists;

import com.rampatra.common.SingleLinkedList;
import com.rampatra.common.SingleLinkedNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/18/15
 * @time: 2:35 PM
 */
public class RemoveDuplicates {

    /**
     * Removes duplicates from a sorted linked list
     * by traversing it once.
     *
     * @param list
     * @param <E>
     */
    public static <E extends Comparable<E>> void removeDuplicates(SingleLinkedList<E> list) {
        SingleLinkedNode<E> curr = list.getNode(0);
        int index = 0;
        while (curr != null) {
            // inner while loop for removing multiple duplicates
            while (curr.next != null && curr.item == curr.next.item) {
                list.remove(index + 1);
            }
            index++;
            curr = curr.next;
        }
    }

    /**
     * Removes duplicates from an unsorted linked list.
     * <p/>
     * This method uses {@link HashMap}, another
     * way is that you can sort it using merge sort and then
     * call {@link #removeDuplicates}.
     *
     * @param list
     * @param <E>
     */
    public static <E extends Comparable<E>> void removeDuplicatesFromUnsortedList(SingleLinkedList<E> list) {
        SingleLinkedNode<E> curr = list.getNode(0);
        Map<E, Boolean> map = new HashMap<>();
        int index = 0;
        while (curr != null) {
            if (map.get(curr.item) == null) {
                map.put(curr.item, true);
                index++;
            } else {
                list.remove(index);
            }
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

        SingleLinkedList<Integer> linkedList2 = new SingleLinkedList<>();
        linkedList2.add(00);
        linkedList2.add(00);
        linkedList2.add(22);
        linkedList2.add(11);
        linkedList2.add(44);
        linkedList2.add(22);
        linkedList2.add(66);
        linkedList2.add(77);
        linkedList2.add(66);
        linkedList2.printList();
        removeDuplicatesFromUnsortedList(linkedList2);
        linkedList2.printList();
    }
}
