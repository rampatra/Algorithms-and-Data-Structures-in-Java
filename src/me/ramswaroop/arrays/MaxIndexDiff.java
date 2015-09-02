package me.ramswaroop.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 9/1/15
 * @time: 10:21 PM
 */
public class MaxIndexDiff {

    /**
     * @param a
     * @return
     */
    public static int maxDiff(int[] a) {
        int maxDiff = -1;
        int[] leftMin = new int[a.length], rightMax = new int[a.length];

        leftMin[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            leftMin[i] = Math.min(a[i], leftMin[i - 1]);
        }

        rightMax[a.length - 1] = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(a[i], rightMax[i + 1]);
        }

        for (int i = 0, j = 0; i < a.length && j < a.length; ) {
            if (rightMax[j] > leftMin[i]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else {
                i++;
            }
        }
        return maxDiff;
    }

    public static void main(String a[]) {
        System.out.println(maxDiff(new int[]{34, 8, 10, 3, 2, 80, 30, 33, 1}));
        System.out.println(maxDiff(new int[]{9, 2, 3, 4, 5, 6, 7, 8, 18, 0}));
        System.out.println(maxDiff(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(maxDiff(new int[]{6, 5, 4, 3, 2, 1}));
        System.out.println(maxDiff(new int[]{10, 11, 12, 13, 14, 6, 9, 7, 5, 3}));
    }
}
