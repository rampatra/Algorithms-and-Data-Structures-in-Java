package com.rampatra.linkedlists;

import com.rampatra.arrays.ReservoirSampling;
import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/21/15
 * @time: 12:57 PM
 */
public class RandomNode {

    /**
     * Returns a random node from linked list with each node having an equal probability.
     * <p>
     * This method uses the simplified version of Reservoir Sampling ({@link ReservoirSampling})
     * where k = 1.
     *
     * @param node
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> SingleLinkedNode<E> getRandomNode(SingleLinkedNode<E> node) {
        SingleLinkedNode<E> result = node, curr = node;
        for (int i = 2; curr != null; i++) {

            int rand = new Random().nextInt(i);

            if (rand % i == 0) result = curr;

            curr = curr.next;
        }

        return result;
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
        linkedList.add(77);
        linkedList.add(88);
        System.out.println(getRandomNode(linkedList.head).item);
    }
}
