package me.ramswaroop.misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 9/15/15
 * @time: 11:15 PM
 */
public class Parenthesis {

    public static String isWellFormed(String input) {
        int len = input.length();
        for (int i = 0; i < len / 2; i++) {
            if (input.charAt(i) != input.charAt(len - i - 1)) {
                return "False";
            }
        }
        return "True";
    }

    public static void areParenthesisWellFormed(String filename) {
        List<String> input = readFile(filename);
        for (int i = 0; i < input.size(); i++) {
            System.out.println(isWellFormed(input.get(i)));
        }
    }

    public static List<String> readFile(String filename) {

        List<String> input = new ArrayList<>();
        BufferedReader br = null;

        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(filename));

            while ((sCurrentLine = br.readLine()) != null) {
                input.add(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return input;
    }

    public static void main(String a[]) {
        areParenthesisWellFormed(a[0]);
        System.exit(0);
    }
}
