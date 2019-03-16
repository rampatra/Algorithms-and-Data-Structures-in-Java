package com.rampatra.dynamicprogramming;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 9/20/15
 * @time: 1:18 PM
 */
public class MinimumJumpsToReachEnd {

    /**
     * Given an array of integers where each element represents the max number of steps that
     * can be made forward from that element. Write a function to return the minimum number
     * of jumps to reach the end of the array (starting from the first element). If an element
     * is 0, then we cannot move through that element.
     * <p/>
     * A naive approach is to start from the first element and recursively call for all the elements
     * reachable from first element. The minimum number of jumps to reach end from first can be calculated
     * using minimum number of jumps needed to reach end from the elements reachable from first.
     * <p/>
     * minJumps(start, end) = Min ( minJumps(k, end) ) for all k reachable from start
     *
     * @param a
     * @param l
     * @param h
     * @return
     */
    public static int getMinimumJumpsToReachEndNaive(int[] a, int l, int h) {
        // base cases
        if (l == h) return 0;
        if (a[l] == 0) return Integer.MAX_VALUE;

        int minJumps = Integer.MAX_VALUE;
        for (int i = l + 1; i <= h && i <= a[l] + l; i++) {
            int jumps = getMinimumJumpsToReachEndNaive(a, i, h);
            if (jumps + 1 < minJumps) {
                minJumps = jumps + 1;
            }
        }
        return minJumps;
    }

    // TODO dp approach

    public static void main(String[] args) {
        int[] ar = new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(getMinimumJumpsToReachEndNaive(ar, 0, ar.length - 1));
        ar = new int[]{5, 4, 3, 2, 1};
        System.out.println(getMinimumJumpsToReachEndNaive(ar, 0, ar.length - 1));
        ar = new int[]{1, 2, 3, 4, 5};
        System.out.println(getMinimumJumpsToReachEndNaive(ar, 0, ar.length - 1));
        ar = new int[]{1, 2};
        System.out.println(getMinimumJumpsToReachEndNaive(ar, 0, ar.length - 1));
        ar = new int[]{1, 1, 1, 1, 1};
        System.out.println(getMinimumJumpsToReachEndNaive(ar, 0, ar.length - 1));
    }
}
