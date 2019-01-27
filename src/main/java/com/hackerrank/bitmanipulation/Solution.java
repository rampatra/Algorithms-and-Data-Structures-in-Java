package com.hackerrank.bitmanipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/24/15
 * @time: 10:25 PM
 */
public class Solution {
    private final static byte BITS;
    private final static long[] BIT_COUNT_TO_BIT;

    static {
        BITS = 32;
        BIT_COUNT_TO_BIT = new long[BITS + 1];
        BIT_COUNT_TO_BIT[0] = 1;
        for (byte i = 1; i <= BITS; i++) {
            BIT_COUNT_TO_BIT[i] = ((BIT_COUNT_TO_BIT[i - 1] - 1L) << 1) + (1L << (i - 1)) + 1L;
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (short T = Short.parseShort(br.readLine()); T > 0; T--) {
            String[] temp = br.readLine().split(" ");
            int A = Integer.parseInt(temp[0]);
            int B = Integer.parseInt(temp[1]);
            long bits = bitCountToNum(B) - bitCountToNum(A) + getHammingWeight(A);
            bits += (A < 0 && B >= 0) ? BIT_COUNT_TO_BIT[BITS] - 1L : 0;
            sb.append(bits + "\n");
        }
        System.out.print(sb);
    }

    //Bit count in number
    private static int getHammingWeight(int n) {
        byte count = 0;
        while (n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }

    //Bit count to number, inclusive
    private static long bitCountToNum(int n) {
        long count = 0;
        for (byte b = BITS; n != 0; ) {
            int x = 1 << --b;
            if ((n & x) != 0) {
                n &= ~x;
                count += BIT_COUNT_TO_BIT[b] + n;
            }
        }
        return count;
    }
}
