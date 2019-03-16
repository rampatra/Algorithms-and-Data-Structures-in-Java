package com.rampatra.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/10/15
 * @time: 6:08 PM
 */
public class NextHigherNumber {

    /**
     * The main logic is to flip the bits in the first '01' bit pattern
     * of {@param n} from the right and then push all 1 bits to the right
     * of '01' to the extreme right.
     * <p>
     * <p>
     * For example,
     * <p>
     * 3    (0000011)  =   5    (0000101)
     * 6    (0000110)  =   9    (0001001)
     * 23   (0010111)  =   27   (0011011)
     * 24   (0011000)  =   33   (0100001)
     * 46   (0101110)  =   51   (0110011)
     *
     * @param n
     * @return
     */
    public static int getNextHigherNumberWithSameSetBits(int n) {
        int leftPattern = 1, rightPattern = 0, count = 0;

        while (n > 0) {
            count++;
            if (((n & 1) == 1)) {

                rightPattern <<= 1;
                rightPattern |= 1;

                if (((n >> 1) & 1) == 0) {
                    n >>>= 1;
                    break;
                }
            }
            n >>>= 1;
        }

        return (n << count) | (leftPattern << count) | (rightPattern >> 1);
    }

    public static void main(String[] args) {
        System.out.println(getNextHigherNumberWithSameSetBits(0));//doesn't work for 0
        System.out.println(getNextHigherNumberWithSameSetBits(4));//8
        System.out.println(getNextHigherNumberWithSameSetBits(5));//6
        System.out.println(getNextHigherNumberWithSameSetBits(6));//9
        System.out.println(getNextHigherNumberWithSameSetBits(23));//27
        System.out.println(getNextHigherNumberWithSameSetBits(24));//33
        System.out.println(getNextHigherNumberWithSameSetBits(44));//49
        System.out.println(getNextHigherNumberWithSameSetBits(46));//51
    }
}
