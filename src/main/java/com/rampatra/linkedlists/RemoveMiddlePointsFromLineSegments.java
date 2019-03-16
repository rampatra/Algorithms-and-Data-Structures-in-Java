package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/23/15
 * @time: 11:18 PM
 */
public class RemoveMiddlePointsFromLineSegments {

    /**
     * Given a linked list of co-ordinates representing line segments, we have
     * to remove those nodes which represent the middle points.
     * <p/>
     * Example:
     * Input:
     * (0,10)-> (1,10)-> (3,10)-> (10,10)-> (10,8)-> (10,5)-> (20,5)-> (40,5)
     * Output:
     * (0,10)-> (10,10)-> (10,5)-> (40,5)
     * <p/>
     * Input:
     * (2,3)->(4,3)->(6,3)->(10,3)->(12,3)
     * Output:
     * (2,3)->(12,3)
     *
     * @param node
     */
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
                System.out.println("Linked list doesn't represent line segments!");
                return;
            }
            curr1 = curr1.next;
        }
    }

    public static void main(String[] args) {
        // test case 1
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

        // test case 2
        SingleLinkedList<Point> linkedList2 = new SingleLinkedList<>();
        linkedList2.add(new Point(2, 3));
        linkedList2.add(new Point(4, 3));
        linkedList2.add(new Point(6, 3));
        linkedList2.add(new Point(10, 3));
        linkedList2.add(new Point(12, 3));
        linkedList2.printList();
        removeMiddlePointsFromLineSegments(linkedList2.head);
        linkedList2.printList();
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
