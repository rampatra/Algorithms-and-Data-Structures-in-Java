package com.rampatra.misc;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author rampatra
 * @since 9/12/15
 */
public class RegexValidateLatLong {

    /**
     * Validates latitude/longitude in the form (+75, 180) etc.
     *
     * @param s
     * @return
     */
    public static String validateLatLong(String s) {
        String regex_coords = "^(\\(\\-?\\d+(\\.\\d+)?),\\s*(\\-?\\d+(\\.\\d+)?\\))$";
        Pattern compiledPattern2 = Pattern.compile(regex_coords, Pattern.CASE_INSENSITIVE);
        Matcher matcher2 = compiledPattern2.matcher(s);
        while (matcher2.find()) {
            return "Valid";
        }
        return "Invalid";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = Integer.parseInt(in.nextLine());
        String[] in_ar = new String[t];

        for (int i = 0; i < t; i++) {
            in_ar[i] = in.nextLine();
        }

        for (String i : in_ar) {
            System.out.println(validateLatLong(i));
        }
    }
}
