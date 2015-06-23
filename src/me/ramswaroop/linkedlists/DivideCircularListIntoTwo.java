package me.ramswaroop.linkedlists;

import me.ramswaroop.common.CircularSingleLinkedList;
import me.ramswaroop.common.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/23/15
 * @time: 6:01 PM
 */
public class DivideCircularListIntoTwo<E extends Comparable<E>> extends CircularSingleLinkedList<E> {

    public static <E extends Comparable<E>> CircularSingleLinkedList[] divideIntoTwoHalves(CircularSingleLinkedList<E> list) {
        SingleLinkedNode<E> middleNode = list.getNode(list.size >> 1),
                lastNode = list.getNode(list.size - 1),
                secondHead = middleNode.next;

        lastNode.next = middleNode.next;
        middleNode.next = list.head;

        return new CircularSingleLinkedList[]{getLinkedList(list.head), getLinkedList(secondHead)};
    }

    public static void main(String a[]) {
        CircularSingleLinkedList<Integer> linkedList = new CircularSingleLinkedList<>();
        linkedList.add(00);
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(44);
        CircularSingleLinkedList<Integer> linkedLists[] = divideIntoTwoHalves(linkedList);
        linkedLists[0].printList();
        linkedLists[1].printList();
    }
}
