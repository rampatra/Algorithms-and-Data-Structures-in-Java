package com.rampatra.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/5/15
 * @time: 4:26 PM
 * @link: http://stackoverflow.com/questions/746171/best-algorithm-for-bit-reversal-from-msb-lsb-to-lsb-msb-in-c
 * @link: http://graphics.stanford.edu/~seander/bithacks.html#BitReverseObvious
 */
public class ReverseBits {

    public static int getNumberByReversingBits(int n) {

        int m;
        // assume 32-bit number
        m = 0x55555555; // 1-bit swap
        n = ((n & m) << 1) | ((n & ~m) >>> 1);

        m = 0x33333333; // 2-bits swap
        n = ((n & m) << 2) | ((n & ~m) >>> 2);

        m = 0x0f0f0f0f; // 4-bits swap
        n = ((n & m) << 4) | ((n & ~m) >>> 4);

        m = 0x00ff00ff; // 8-bits swap
        n = ((n & m) << 8) | ((n & ~m) >>> 8);

        n = (n << 16) | (n >>> 16); // 16-bits swap

        return n;
    }

    /**
     * Checks for set bits in {@param n} and sets them
     * from the left end in {@code reverseNum}.
     * <p/>
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     *
     * @param n
     * @return
     */
    public static int getNumberByReversingBitsV1(int n) {

        int reverseNum = 0, i = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                reverseNum |= 1 << 31 - i;
            }
            n >>>= 1;
            i++;
        }

        return reverseNum;
    }

    /**
     * This method is similar to {@link #getNumberByReversingBitsV1(int)} but here we put
     * the set bits of {@param n} in {@code reverse number} and keep on shifting the reverse number
     * left until {@param n} becomes {@code zero} and finally shift left for the remaining number of
     * bits used to represent the number.
     * <p/>
     * Time complexity: O(log n) (as we are dividing 'n' by 2 in each iteration)
     * Space Complexity: O(1)
     *
     * @param n
     * @return
     */
    public static int getNumberByReversingBitsV2(int n) {
        int noOfBits = 32;
        int reverse = 0;

        while (n > 0) {
            reverse <<= 1;
            reverse |= n & 1;
            n >>>= 1;
            noOfBits--;
        }
        reverse <<= noOfBits;
        return reverse;
    }

    public static void main(String[] args) {
        System.out.println(getNumberByReversingBits(79876));
        System.out.println(getNumberByReversingBitsV1(79876));
        System.out.println(getNumberByReversingBitsV2(79876));
        System.out.println(getNumberByReversingBitsV2(5));
    }
}
