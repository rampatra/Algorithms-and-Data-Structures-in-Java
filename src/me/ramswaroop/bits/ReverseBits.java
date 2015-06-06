package me.ramswaroop.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/5/15
 * @time: 4:26 PM
 * @link http://stackoverflow.com/questions/746171/best-algorithm-for-bit-reversal-from-msb-lsb-to-lsb-msb-in-c
 * @link http://graphics.stanford.edu/~seander/bithacks.html#BitReverseObvious
 */
public class ReverseBits {

    public static int getNumberByReversingBits(int n) {
        System.out.println(Integer.toBinaryString(n));

        int m;
        // assume 32-bit number
        m = 0x55555555; // 1-bit swap
        n = ((n & m) << 1) | ((n & ~m) >> 1);

        m = 0x33333333; // 2-bits swap
        n = ((n & m) << 2) | ((n & ~m) >> 2);

        m = 0x0f0f0f0f; // 4-bits swap
        n = ((n & m) << 4) | ((n & ~m) >> 4);

        m = 0x00ff00ff; // 8-bits swap
        n = ((n & m) << 8) | ((n & ~m) >> 8);

        n = (n << 16) | (n >> 16); // 16-bits swap

        System.out.println(Integer.toBinaryString(n));
        return n;
    }

    public static void main(String a[]) {
        System.out.println(getNumberByReversingBits(7));
    }
}
