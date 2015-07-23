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

    public static void removeMiddlePointsFromLineSegments(SingleLinkedNode<Point> node) {

        SingleLinkedNode<Point> curr1 = node, curr2 = node;

        while (curr1 != null && curr1.next != null) {
            // vertical line
            if (curr1.item.x == curr1.next.item.x) {
                while (curr2.next != null && curr2.next.item.x == curr1.item.x) {
                    curr2 = curr2.next;
                }
                curr1.next = curr2;
            } else if (curr1.item.y == curr1.next.item.y) { // horizontal line
                while (curr2.next != null && curr2.next.item.y == curr1.item.y) {
                    curr2 = curr2.next;
                }
                curr1.next = curr2;
            } else {
                return;
            }
            curr1 = curr1.next;
        }
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
