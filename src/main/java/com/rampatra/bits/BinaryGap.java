package com.rampatra.bits;

/**
 * Created by rampatra on 30/05/2016.
 */
public class BinaryGap {

    /**
     * A binary gap of a positive integer N is any maximal
     * sequence of consecutive zeros that is surrounded by ones
     * at both ends in the binary representation of N.
     *
     * @param n
     * @return
     */
    public static int findBinaryGap(long n) {
        int gap = 0;
        int maxGap = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                while (n >>> 1 > 0 && (n >>> 1 & 1) == 0) {
                    gap++;
                    n = n >>> 1;
                }
                if (gap > maxGap) {
                    maxGap = gap;
                }
                gap = 0;
            }
            n = n >>> 1;
        }

        return maxGap;
    }

    public static int findMaxNoOf0sBetweenTwo1s(long n) {
        return findBinaryGap(n);
    }

    public static void main(String[] args) {
        System.out.println(findBinaryGap(2));
        System.out.println(findBinaryGap(8));
        System.out.println(findBinaryGap(9));
        System.out.println(findBinaryGap(16));
        System.out.println(findBinaryGap(17));
        System.out.println(findMaxNoOf0sBetweenTwo1s(121));
        System.out.println(findMaxNoOf0sBetweenTwo1s(1041));
        System.out.println(findMaxNoOf0sBetweenTwo1s(2_147_483_64889L));
    }
}
