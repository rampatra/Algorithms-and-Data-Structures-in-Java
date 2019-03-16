package com.ctci.bitmanipulation;

/**
 * @author rampatra
 * @since 2019-03-16
 */
public class BinaryToString {

    /**
     * Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print the binary representation.
     * If the number cannot be represented accurately in binary with at most 32 characters, print "ERROR."
     *
     * @param realNum a real number between 0 and 1 (for ex. 0.75)
     * @return binary string of the real number
     * @see <a href="http://cs.furman.edu/digitaldomain/more/ch6/dec_frac_to_bin.htm">how to convert decimal fraction to binary</a>
     */
    private static String decimalFractionToBinaryString(double realNum) {
        if (realNum <= 0 || realNum >= 1) {
            return "ERROR";
        }

        int binaryBit;
        StringBuilder sb = new StringBuilder();
        sb.append("0.");

        while (realNum > 0) {
            if (sb.length() == 32) {
                return "ERROR";
            }
            realNum = realNum * 2;
            // the binary bit is the whole number part (left to the decimal)
            binaryBit = (int) realNum;
            // we only have to take the part after the decimal (right to the decimal) for the next iteration
            if (binaryBit == 1) {
                realNum -= 1;
            }
            sb.append(binaryBit);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(decimalFractionToBinaryString(0.625));
        System.out.println(decimalFractionToBinaryString(0.75));
        System.out.println(decimalFractionToBinaryString(0.72));
        System.out.println(decimalFractionToBinaryString(0.10));
    }
}
