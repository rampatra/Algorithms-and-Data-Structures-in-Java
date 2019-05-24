package com.rampatra.misc;

/**
 * @author rampatra
 * @since 11/3/15
 */
public class RegexReplaceAllSpaces {

    public static String replaceAll(String str, String regex, String replacement) {
        return str.replaceAll(regex, replacement);
    }

    public static void main(String[] args) {
        System.out.println(replaceAll("ram s", "\\s+", ""));
    }
}


