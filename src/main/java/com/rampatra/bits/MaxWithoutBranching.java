package com.rampatra.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/8/15
 * @time: 5:41 PM
 * @link: http://graphics.stanford.edu/~seander/bithacks.html#IntegerMinOrMax
 */
public class MaxWithoutBranching {

    public static int getMinWithoutBranching(int a, int b) {
        return b ^ ((a ^ b) & -((a < b) ? 1 : 0));
    }

    public static int getMaxWithoutBranching(int a, int b) {
        return a ^ ((a ^ b) & -((a < b) ? 1 : 0));
    }

    public static void main(String[] args) {
        System.out.println(getMinWithoutBranching(5, 6));
        System.out.println(getMinWithoutBranching(-5, -6));
        System.out.println(getMinWithoutBranching(-5, 6));
        System.out.println(getMinWithoutBranching(5, -6));
        System.out.println(getMinWithoutBranching(0, 0));

        System.out.println(getMaxWithoutBranching(5, 6));
        System.out.println(getMaxWithoutBranching(-5, -6));
        System.out.println(getMaxWithoutBranching(-5, 6));
        System.out.println(getMaxWithoutBranching(5, -6));
        System.out.println(getMaxWithoutBranching(0, 0));
    }
}

/**
 * EXPLANATION:
 * On some rare machines where branching is very expensive and no condition move
 * instructions exist, the above expression might be faster than the obvious
 * approach, r = (x < y) ? x : y, even though it involves two more instructions.
 * (Typically, the obvious approach is best, though.) It works because if x < y,
 * then -(x < y) will be all ones, so r = y ^ (x ^ y) & ~0 = y ^ x ^ y = x.
 * Otherwise, if x >= y, then -(x < y) will be all zeros, so r = y ^ ((x ^ y) & 0) = y.
 * On some machines, evaluating (x < y) as 0 or 1 requires a branch instruction,
 * so there may be no advantage.
 */
