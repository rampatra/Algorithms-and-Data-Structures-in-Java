package com.rampatra.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 8/22/15
 * @time: 11:56 AM
 */
public class EquilibriumIndex {

    /**
     * EQUILIBRIUM INDEX of an array is an index such that the sum of elements at lower
     * indexes is equal to the sum of elements at higher indexes.
     * <p/>
     * For example, in an array A = {-7, 1, 5, 2, -4, 3, 0}
     * <p/>
     * 3 is an equilibrium index, because
     * A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
     * <p/>
     * 6 is also an equilibrium index, because sum of zero elements is zero,
     * i.e., A[0] + A[1] + A[2] + A[3] + A[4] + A[5] = 0
     * <p/>
     * 7 is not an equilibrium index, because it is not a valid index of array A.
     *
     * @param a
     * @return equilibrium index of array {@param a}.
     */
    public static int getEquilibriumIndex(int[] a) {
        int totalSum = 0, leftSum = 0;

        for (int i = 0; i < a.length; i++) {
            totalSum += a[i];
        }

        for (int i = 0; i < a.length; i++) {
            totalSum -= a[i]; // totalSum now holds the right sum from ith index to end
            if (leftSum == totalSum) {
                return i; // left sum == right sum
            }
            leftSum += a[i]; // update left sum
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(getEquilibriumIndex(new int[]{-7, 1, 5, 2, -4, 3, 0}));
        System.out.println(getEquilibriumIndex(new int[]{-7, 1, 5, 0, 0, 0, 0, 1, 2, -4, 1, 3, 0}));
        System.out.println(getEquilibriumIndex(new int[]{4, 5, 2, 1, 6, 7, 8, 0, 1}));
        System.out.println(getEquilibriumIndex(new int[]{0}));
        System.out.println(getEquilibriumIndex(new int[]{0, 0, 0}));
        System.out.println(getEquilibriumIndex(new int[]{1, 1}));
        System.out.println(getEquilibriumIndex(new int[]{1, 1, 1}));
    }
}
