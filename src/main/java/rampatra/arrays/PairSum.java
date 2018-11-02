package rampatra.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 5/18/15
 * @time: 10:24 PM
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array ar[] of n numbers and
 * another number x, determine whether or not there
 * exists two elements in ar[] whose sum is exactly x.
 */
public class PairSum {

    /**
     * Using sorting. If we use Merge Sort or Heap Sort
     * then (-)(nlogn) in worst case. If we use Quick Sort
     * then O(n^2) in worst case.
     *
     * @param ar
     * @param x
     * @return
     */
    static boolean pairSum(int ar[], int x) {
        Arrays.sort(ar);

        int len = ar.length;

        for (int i = 0, j = len - 1; i < j; ) {
            if (ar[i] + ar[j] == x) {
                return true;
            } else if (ar[i] + ar[j] < x) { // approach towards larger elements
                i++;
            } else { // approach towards smaller elements
                j--;
            }
        }
        return false;
    }

    /**
     * Using hashmap in O(n) time
     *
     * @param ar
     * @param x
     * @param map
     * @return
     */
    static boolean pairSum(int ar[], int x, Map<Integer, Integer> map) {
        for (int i = 0; i < ar.length; i++) {
            if (map.containsKey(x - ar[i])) {
                return true;
            }
            map.put(ar[i], 1);
        }
        return false;
    }

    public static void main(String a[]) {
        System.out.println(pairSum(new int[]{-3, 4, -6, 1, 1}, -2));
        System.out.println(pairSum(new int[]{-3, 4, -6, 1, 1}, -2, new HashMap<Integer, Integer>()));
    }
}
