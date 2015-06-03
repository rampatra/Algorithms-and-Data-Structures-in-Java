package me.ramswaroop.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/3/15
 * @time: 1:18 PM
 */
public class MultipleOf3 {

    /**
     * 1) Get count of all set bits at odd positions (For 23 it’s 3).
     * 2) Get count of all set bits at even positions (For 23 it’s 1).
     * 3) If difference of above two counts is a multiple of 3 then number is also a multiple of 3.
     * <p/>
     * NOTE: Binary representation of 23 is 00..10111
     *
     * @param n
     * @return
     */
    public static boolean isMultipleOf3(long n) {
        int oddCount = 0, evenCount = 0;

        n = Math.abs(n);

        if (n == 0) return true;
        if (n == 1) return false;

        while (n > 0) {
            if ((n & 1) == 1) oddCount++;
            n >>= 1;

            if ((n & 1) == 1) evenCount++;
            n >>= 1;
        }

        return isMultipleOf3(oddCount - evenCount);

    }

    public static void main(String a[]) {
        System.out.println(isMultipleOf3(0));
        System.out.println(isMultipleOf3(1));
        System.out.println(isMultipleOf3(2));
        System.out.println(isMultipleOf3(3));
        System.out.println(isMultipleOf3(18));
        System.out.println(isMultipleOf3(-18)); // works for -ve numbers as well
        System.out.println(isMultipleOf3(-17));
    }
}
