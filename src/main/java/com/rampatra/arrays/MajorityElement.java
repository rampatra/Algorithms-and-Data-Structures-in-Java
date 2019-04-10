package com.rampatra.arrays;

/**
 * The algorithm for finding a possible candidate
 * works in O(n) which is known as Moore’s Voting Algorithm.
 * Basic idea of the algorithm is if we cancel out each
 * occurrence of an element e with all the other elements
 * that are different from e then e will exist until end
 * if it is a majority element.
 * <p/>
 * Time Complexity: O(n)
 * Auxiliary Space : O(1)
 * 
 * @author rampatra
 * @since 5/20/15
 */
public class MajorityElement {

    /**
     * Uses Moore’s Voting Algorithm to
     * get a candidate for majority element.
     *
     * @param a
     * @return
     */
    public static int findCandidate(int[] a) {
        int candidate = a[0], count = 1;
        for (int i = 1; i < a.length; i++) {
            if (candidate == a[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                candidate = a[i];
                count = 1;
            }
        }
        return candidate;
    }

    public static void majorityElement(int[] a) {
        int candidate = findCandidate(a),
                count = 0;

        // check if the candidate is really a majority element
        for (int i = 0; i < a.length; i++) {
            if (candidate == a[i]) {
                count++;
            }
        }
        if (count > a.length / 2) {
            System.out.print(candidate);
        } else {
            System.out.print("NONE");
        }
    }

    public static void main(String[] args) {
        majorityElement(new int[]{1, 6, 2, 2, 2, 1, 2, 2, 7, 2});
    }
}