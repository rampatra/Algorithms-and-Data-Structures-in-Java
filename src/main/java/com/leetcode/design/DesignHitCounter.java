package com.leetcode.design;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Medium
 * Problem Link: https://leetcode.com/problems/design-hit-counter/
 * Problem Description:
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 *
 * Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made
 * to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the
 * earliest timestamp starts at 1.
 *
 * It is possible that several hits arrive roughly at the same time.
 *
 * Example:
 *
 * HitCounter counter = new HitCounter();
 *
 * // hit at timestamp 1.
 * counter.hit(1);
 *
 * // hit at timestamp 2.
 * counter.hit(2);
 *
 * // hit at timestamp 3.
 * counter.hit(3);
 *
 * // get hits at timestamp 4, should return 3.
 * counter.getHits(4);
 *
 * // hit at timestamp 300.
 * counter.hit(300);
 *
 * // get hits at timestamp 300, should return 4.
 * counter.getHits(300);
 *
 * // get hits at timestamp 301, should return 3.
 * counter.getHits(301);
 *
 * Follow up:
 * What if the number of hits per second could be very large? Does your design scale?
 *
 * Runtime: <a href="https://leetcode.com/submissions/detail/248917167/">42 ms</a> (better than ~98%).
 *
 * @author rampatra
 * @since 2019-08-04
 */
public class DesignHitCounter {

    private int[] timestamps;
    private int[] hits;

    /**
     * Initialize your data structure here.
     */
    public DesignHitCounter() {
        this.timestamps = new int[300];
        this.hits = new int[300];
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        int bucket = timestamp % 300;
        if (timestamps[bucket] == timestamp) {
            hits[bucket]++;
        } else {
            timestamps[bucket] = timestamp;
            hits[bucket] = 1;
        }
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        int totalHits = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - 300 < timestamps[i]) {
                totalHits += hits[i];
            }
        }
        return totalHits;
    }

    public static void main(String[] args) {
        DesignHitCounter counter = new DesignHitCounter();

        // hit at timestamp 1.
        counter.hit(1);

        // hit at timestamp 2.
        counter.hit(2);

        // hit at timestamp 3.
        counter.hit(3);

        // get hits at timestamp 4, should return 3.
        assertEquals(3, counter.getHits(4));

        // hit at timestamp 300.
        counter.hit(300);

        // get hits at timestamp 300, should return 4.
        assertEquals(4, counter.getHits(300));

        // get hits at timestamp 301, should return 3.
        assertEquals(3, counter.getHits(301));
    }
}
