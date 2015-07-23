package me.ramswaroop.linkedlists;

import me.ramswaroop.common.SingleLinkedList;
import me.ramswaroop.common.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 7/23/15
 * @time: 11:18 PM
 */
public class RemoveMiddlePointsFromLineSegments {

    public static <E extends Comparable<E>> void removeMiddlePointsFromLineSegments(SingleLinkedNode<E> node) {

    }


    public static void main(String a[]) {
        SingleLinkedList<Point> linkedList = new SingleLinkedList<>();
        linkedList.add(new Point(0, 10));
        linkedList.add(new Point(1, 10));
        linkedList.add(new Point(3, 10));
        linkedList.add(new Point(10, 10));
        linkedList.add(new Point(10, 8));
        linkedList.add(new Point(10, 5));
        linkedList.add(new Point(20, 5));
        linkedList.add(new Point(40, 5));
        linkedList.printList();
        removeMiddlePointsFromLineSegments(linkedList.head);
        linkedList.printList();
    }
}

class Point implements Comparable<Point> {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public int compareTo(Point o) {
        return 0;
    }
}
