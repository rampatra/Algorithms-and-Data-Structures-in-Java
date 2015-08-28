package me.ramswaroop.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 8/28/15
 * @time: 10:32 AM
 */
public class ConsecutiveElements {

    /**
     * 
     * @param a
     * @return
     */
    public static boolean areConsecutiveElements(int[] a) {
        int min = a[0], max = a[0];
        int[] visitedArray = new int[a.length];

        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }

        if (a.length != max - min + 1) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (visitedArray[a[i] - min] == 0) {
                visitedArray[a[i] - min] = a[i];
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String a[]) {
        System.out.println(areConsecutiveElements(new int[]{5, 4, 3, 2, 1}));
        System.out.println(areConsecutiveElements(new int[]{67, 68, 69, 72, 70, 71}));
        System.out.println(areConsecutiveElements(new int[]{67, 68, 69, 72, 70, 71, 70}));
        System.out.println(areConsecutiveElements(new int[]{8, 5, 2, 4, 3, 1}));
    }
}
