package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/2/15
 * @time: 1:20 PM
 */
public class AddNumbersInTwoLists {

    /**
     * Adds two numbers represented by two linked lists {@param list1}
     * and {@param list2} (where first node is the least significant
     * digit) and stores them in another list.
     * <p/>
     * Example:
     * <p/>
     * Input:
     * First List: 5->6->3              // represents number 365
     * Second List: 8->4->2             // represents number 248
     * Output:
     * Resultant list: 3->1->6          // represents number 613
     * <p/>
     * Input:
     * First List: 7->5->9->4->6        // represents number 64957
     * Second List: 8->4                // represents number 48
     * Output:
     * Resultant list: 5->0->0->5->6    // represents number 65005
     *
     * @param list1
     * @param list2
     * @return list containing the sum of numbers in {@param list1} and {@param list2}.
     */
    public static SingleLinkedList<Integer> addWithNode1LSD(SingleLinkedList<Integer> list1,
                                                            SingleLinkedList<Integer> list2) {

        int sum, carry = 0;
        SingleLinkedNode<Integer> curr1 = list1.head, curr2 = list2.head;
        SingleLinkedList<Integer> resultList = new SingleLinkedList<>();

        // loop till both of the list runs out
        while (curr1 != null || curr2 != null) {

            // if either of the list runs out first
            int a = (curr1 != null) ? curr1.item : 0;
            int b = (curr2 != null) ? curr2.item : 0;

            sum = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;
            resultList.add(sum);

            if (curr1 != null) curr1 = curr1.next;
            if (curr2 != null) curr2 = curr2.next;
        }

        // if there is any carry left over, add it to the result
        if (carry != 0) resultList.addFirst(carry);

        return resultList;
    }

    /**
     * Adds two numbers represented by two linked lists {@param list1}
     * and {@param list2} (where first node is the most significant
     * digit) and stores them in another list.
     * <p/>
     * Example:
     * <p/>
     * Input:
     * First List: 5->6->3              // represents number 563
     * Second List: 8->4->2             // represents number 842
     * Output:
     * Resultant list: 1->4->0->5       // represents number 1405
     * <p/>
     * Input:
     * First List: 7->5->9->4->6        // represents number 75946
     * Second List: 8->4                // represents number 84
     * Output:
     * Resultant list: 7->6->0->3->0    // represents number 76030
     *
     * @param list1
     * @param list2
     * @return
     */
    public static SingleLinkedList<Integer> addWithNode1MSD(SingleLinkedList<Integer> list1,
                                                            SingleLinkedList<Integer> list2) {
        ReverseSingleLinkedList.reverseList(list1);
        ReverseSingleLinkedList.reverseList(list2);

        SingleLinkedList<Integer> resultList = addWithNode1LSD(list1, list2);

        ReverseSingleLinkedList.reverseList(resultList);

        return resultList;
    }

    /**
     * Adds the numbers in two lists (where first node is the least significant
     * digit) and prints the sum.
     * <p>
     * Example:
     * <p/>
     * Input:
     * First List: 5->6->3              // represents number 365
     * Second List: 8->4->2             // represents number 248
     * Output:
     * 613                              // represents number 613
     *
     * @param l1
     * @param l2
     */
    private static void printSumWithNode1LSD(SingleLinkedList<Integer> l1, SingleLinkedList<Integer> l2) {
        System.out.println(convertToInt(l1) + convertToInt(l2));
    }

    private static int convertToInt(SingleLinkedList<Integer> list) {
        int num = 0;
        int baseValue = 1;
        SingleLinkedNode<Integer> temp = list.head;
        while (temp != null) {
            num += (temp.item * baseValue);
            baseValue *= 10;
            temp = temp.next;
        }
        return num;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList1 = new SingleLinkedList<>();
        linkedList1.add(7);
        linkedList1.add(5);
        linkedList1.add(9);
        linkedList1.add(4);
        linkedList1.add(6);
        linkedList1.printList();
        SingleLinkedList<Integer> linkedList2 = new SingleLinkedList<>();
        linkedList2.add(8);
        linkedList2.add(4);
        linkedList2.printList();
        addWithNode1LSD(linkedList1, linkedList2).printList();
        System.out.println("--------------");
        addWithNode1MSD(linkedList1, linkedList2).printList();
        System.out.println("--------------");
        printSumWithNode1LSD(linkedList1, linkedList2);
    }
}
