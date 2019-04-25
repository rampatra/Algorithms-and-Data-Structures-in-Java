package com.leetcode.hashtables;

/**
 * Level: Learning Cards
 * Problem Link: https://leetcode.com/explore/learn/card/hash-table/182/practical-applications/1139/
 * Runtime: https://leetcode.com/submissions/detail/224872991/
 *
 * @author rampatra
 * @since 2019-04-24
 */
public class MyHashSet {

    private final int SIZE = 10000;
    private final Entry[] entries;

    class Entry {
        int key;
        Entry next;

        Entry(int key) {
            this.key = key;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        entries = new Entry[SIZE];
    }

    public void add(int key) {
        if (contains(key)) return;

        Entry newEntry = new Entry(key);
        int bucket = key % SIZE;

        newEntry.next = entries[bucket];
        entries[bucket] = newEntry;
    }

    public void remove(int key) {
        int bucket = key % SIZE;
        Entry entry = entries[bucket];

        if (entry != null && entry.key == key) {
            entries[bucket] = entry.next;
            return;
        }

        Entry curr = new Entry(0);
        curr.next = entry;

        while (curr.next != null && curr.next.key != key) {
            curr = curr.next;
        }

        if (curr.next != null) {
            curr.next = curr.next.next;
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int bucket = key % SIZE;
        Entry entry = entries[bucket];

        while (entry != null) {
            if (entry.key == key) {
                return true;
            }
            entry = entry.next;
        }

        return false;
    }

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set.contains(1));
        System.out.println(set.contains(2));
        set.remove(2);
        System.out.println(set.contains(2));
        System.out.println(set.contains(3));
        set.remove(3);
        System.out.println(set.contains(3));
    }
}