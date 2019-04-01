package com.rampatra.strings;

/**
 * @author rampatra
 * @since 2019-04-01
 */
public class IntegerToString {

    private static final int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999,
            999999999, Integer.MAX_VALUE};

    private static String getStringFromInteger(int num) {
        boolean isNegative = num < 0;
        num = isNegative ? -num : num;
        int size = getStringSize(num);
        size = isNegative ? size + 1 : size;
        char[] chars = new char[size];

        int rem;
        for (int i = size - 1; isNegative ? i > 0 : i >= 0; i--) {
            rem = num % 10;
            num = num / 10;
            chars[i] = (char) (rem + '0');
        }

        if (isNegative) {
            chars[0] = '-';
        }

        return new String(chars);
    }

    private static int getStringSize(int num) {
        if (num == Integer.MAX_VALUE) return 10;

        for (int i = 0; ; i++) {
            if (num < sizeTable[i]) {
                return i + 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(getStringFromInteger(0));
        System.out.println(getStringFromInteger(123));
        System.out.println(getStringFromInteger(+123));
        System.out.println(getStringFromInteger(-123));
        System.out.println(getStringFromInteger(Integer.MAX_VALUE));
        System.out.println(getStringFromInteger(Integer.MIN_VALUE)); // not working
    }
}