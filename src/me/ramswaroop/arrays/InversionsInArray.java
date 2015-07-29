package me.ramswaroop.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 7/29/15
 * @time: 8:37 PM
 */
public class InversionsInArray {

    /**
     * Naive approach.
     * <p/>
     * INVERSION COUNT for an array indicates how far (or close) the array is from being
     * sorted. If array is already sorted then inversion count is 0. If array is sorted in
     * reverse order then inversion count is the maximum.
     * <p/>
     * Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
     * <p/>
     * Example:
     * The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
     *
     * @param a
     * @return
     */
    public static int getInversionCountNaive(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length - 2; i++) {
            for (int j = 1; j < a.length - 1; j++) {
                if (a[i] > a[j]) count++;
            }
        }
        return count;
    }

    public static int getInversionCount(int[] a) {
        return 0;
    }

    public static void main(String a[]) {
        System.out.println(getInversionCountNaive(new int[]{2, 4, 1, 3, 5}));
    }
}
