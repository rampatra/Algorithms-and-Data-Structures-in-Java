package com.rampatra.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 8/28/15
 * @time: 10:32 AM
 */
public class ConsecutiveElements {

    /**
     * Given an unsorted array of numbers, write a function that returns true if array consists of consecutive numbers.
     * <p/>
     * Examples:
     * a) If array is {5, 2, 3, 1, 4}, then the function should return true because the array has consecutive numbers
     * from 1 to 5.
     * b) If array is {34, 23, 52, 12, 3 }, then the function should return false because the elements are not consecutive.
     * c) If the array is {7, 6, 5, 5, 3, 4}, then the function should return false because 5 and 5 are not consecutive.
     * <p/>
     * ALGORITHM:
     * The idea is to check for following two conditions. If following two conditions are true, then return true.
     * 1) max – min + 1 = n where max is the maximum element in array, min is minimum element in array and n is the number
     * of elements in array.
     * 2) All elements are distinct.
     * <p/>
     * To check if all elements are distinct, we can create a visited[] array of size n. We can map the ith element of input
     * array arr[] to visited array by using arr[i] – min as index in visited[]. So we need O(n) auxiliary space.
     *
     * @param a
     * @return
     */
    public static boolean areConsecutiveElements(int[] a) {
        int min = a[0], max = a[0];
        int[] visitedArray = new int[a.length];

        // find min and max element
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }

        // diff of max and min should be equal to length of array
        if (a.length != max - min + 1) {
            return false;
        }

        // check for distinct elements
        for (int i = 0; i < a.length; i++) {
            if (visitedArray[a[i] - min] == 0) {
                visitedArray[a[i] - min] = a[i];
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * This approach is similar to {@link ConsecutiveElements#areConsecutiveElements(int[])} but
     * requires O(1) auxiliary space instead of O(n). But the only con of this method is that it modifies the original
     * input array {@param a}.
     *
     * @param a
     * @return
     */
    public static boolean areConsecutiveElementsInO1Space(int[] a) {
        int min = a[0], max = a[0];

        // find min and max element
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }

        // diff of max and min should be equal to length of array
        if (a.length != max - min + 1) {
            return false;
        }

        // check for distinct elements
        for (int i = 0; i < a.length; i++) {
            if (a[Math.abs(a[i]) - min] >= 0) {
                a[Math.abs(a[i]) - min] = -(a[Math.abs(a[i]) - min]);
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(areConsecutiveElements(new int[]{5, 4, 3, 2, 1}));
        System.out.println(areConsecutiveElements(new int[]{67, 68, 69, 72, 70, 71}));
        System.out.println(areConsecutiveElements(new int[]{67, 68, 69, 72, 70, 71, 70}));
        System.out.println(areConsecutiveElements(new int[]{8, 5, 2, 4, 3, 1}));
        System.out.println("==============");
        System.out.println(areConsecutiveElementsInO1Space(new int[]{5, 4, 3, 2, 1}));
        System.out.println(areConsecutiveElementsInO1Space(new int[]{67, 68, 69, 72, 70, 71}));
        System.out.println(areConsecutiveElementsInO1Space(new int[]{67, 68, 69, 72, 70, 71, 70}));
        System.out.println(areConsecutiveElementsInO1Space(new int[]{8, 5, 2, 4, 3, 1}));
    }
}
