package me.ramswaroop.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/10/15
 * @time: 6:08 PM
 */
public class NextHigherNumber {

    /**
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

        /*System.out.println("n: " + Integer.toBinaryString(n << count));
        System.out.println("Left pattern: " + Integer.toBinaryString(leftPattern << count));
        System.out.println("Right pattern: " + Integer.toBinaryString(rightPattern >> 1));*/

        return (n << count) | (leftPattern << count) | (rightPattern >> 1);
    }

    public static void main(String a[]) {
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
