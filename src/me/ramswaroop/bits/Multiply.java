package me.ramswaroop.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/3/15
 * @time: 11:35 PM
 */

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * <p/>
 * Note: Works only for positive integers.
 */
public class Multiply {

    /**
     * Multiplies a number with 8 by performing 3 left shifts.
     *
     * @param n
     * @return
     */
    public static long multiplyBy8(long n) {
        return (n << 3);
    }

    /**
     * 3 left shifts gives us 8n but we want 7n, so we subtract
     * 1n from it. Similarly we can do any multiplication by shifting
     * and then adding/subtracting.
     *
     * @param n
     * @return
     */
    public static long multiplyBy7(long n) {
        return (n << 3) - n;
    }

    public static void main(String a[]) {
        System.out.println(multiplyBy7(4));
        System.out.println(multiplyBy7(6));
        System.out.println(multiplyBy7(7));
        System.out.println(multiplyBy8(4));
        System.out.println(multiplyBy8(6));
        System.out.println(multiplyBy8(7));
    }
}
