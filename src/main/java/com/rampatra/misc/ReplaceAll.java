package com.rampatra.misc;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 11/3/15
 * @time: 2:21 PM
 */
public class ReplaceAll {

    public static String replaceAll(String str, String regex, String replacement) {
        return str.replaceAll(regex, replacement);
    }

    public static void main(String[] args) {
        System.out.println(replaceAll("ram s", "\\s+", ""));
    }
}


