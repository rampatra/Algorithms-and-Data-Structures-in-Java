package com.leetcode.linkedlists;

/**
 * @author rampatra
 * @since 21/11/2018
 */
class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }

    public void print() {
        Node curr = this;
        while (curr.next != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println(curr.val);
    }
}
