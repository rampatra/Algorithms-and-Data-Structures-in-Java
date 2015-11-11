package me.ramswaroop.misc;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 11/3/15
 * @time: 2:21 PM
 */
public class ReplaceAll {

    public static String replaceAll(String str, String regex, String replacement) {
        return str.replaceAll(regex, replacement);
    }

    public static void main(String a[]) {
        System.out.println(replaceAll("ram s", "\\s+", ""));
    }
}


