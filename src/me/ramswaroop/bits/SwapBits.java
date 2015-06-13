package me.ramswaroop.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/13/15
 * @time: 4:45 PM
 */
public class SwapBits {

    /**
     * Swaps {@param length} bits in {@param n} starting from
     * {@param pos1} with bits starting from {@param pos2}.
     * <p/>
     * For example,
     * x = 28 (11100)
     * p1 = 0 (Start from first bit from right side)
     * p2 = 3 (Start from 4th bit from right side)
     * l = 2 (No of bits to be swapped)
     * Output:
     * 7 (00111)
     *
     * @param n
     * @param pos1   starts from 0
     * @param pos2   starts from 0
     * @param length
     * @return
     */
    public static int swapBitRangeInNumber(int n, int pos1, int pos2, int length) {
        int set1 = (n >> pos1) & ((1 << length) - 1); // 1st set of bits to be swapped
        int set2 = (n >> pos2) & ((1 << length) - 1); // 2nd set of bits to be swapped
        int xor = set1 ^ set2; // difference pattern between the bits to be swapped

        return n ^ (xor << pos1) ^ (xor << pos2);   // XORing the difference pattern at the appropriate
        // position of the bits to be swapped gives us the result
        // (this logic is similar to swapping bits using XOR)
    }

    public static void main(String a[]) {
        System.out.println(swapBitRangeInNumber(47, 1, 5, 3));
        System.out.println(swapBitRangeInNumber(28, 0, 3, 2));
        System.out.println(swapBitRangeInNumber(269, 1, 3, 2));
    }
}
