package me.ramswaroop.arrays;

import me.ramswaroop.arrays.sorting.QuickSort;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 10/30/15
 * @time: 11:01 AM
 */
public class NextLargerNumber {

    /**
     * Finds the closest number which is larger
     * than {@param n} by using only those digits
     * present in {@param n} and using any digit
     * only once.
     *
     * @param n
     * @return
     */
    public static int findNextLargerNumber(Integer n) {

        String str = n.toString();
        int len = str.length();
        int[] a = new int[len];
        int minIndex;

        // construct int array containing all 
        // digits in number {@param n}  
        for (int i = 0; i < len; i++) {
            a[i] = Integer.parseInt(str.charAt(i) + "");
        }

        int i = len - 1;
        while (i > 0) {
            if (a[i] > a[i - 1]) break;
            i--;
        }

        if (i <= 0) return -1;
        
        minIndex = i;
        int j = len - 1;
        while (j >= i) {
            if (a[j] < a[minIndex] && a[j] > a[i - 1]) {
                minIndex = j;
            }
            j--;
        }

        swap(a, i - 1, minIndex);

        QuickSort.quickSort(a, i, len - 1);

        StringBuilder builder = new StringBuilder();
        for (int k = 0; k < len; k++) {
            builder.append(a[k]);
        }

        return Integer.parseInt(builder.toString());
    }

    /**
     * Swaps variables in {@param a} at {@param index1} with {@param index2}.
     *
     * @param a
     * @param index1
     * @param index2
     */
    private static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    public static void main(String a[]) {
        System.out.println(findNextLargerNumber(56));
        System.out.println(findNextLargerNumber(65));
        System.out.println(findNextLargerNumber(3451));
        System.out.println(findNextLargerNumber(534976));
    }
}
