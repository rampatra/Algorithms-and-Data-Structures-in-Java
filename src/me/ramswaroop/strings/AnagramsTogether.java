package me.ramswaroop.strings;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 9/23/15
 * @time: 8:11 PM
 */
public class AnagramsTogether {

    public static void printAnagramsTogether(String[] s) {

        HashMap<String, List<Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < s.length; i++) {
            char[] chars = s[i].toCharArray();
            Arrays.sort(chars);
            
            List<Integer> indexes = hashMap.get(String.valueOf(chars));
            if (indexes == null) {
                indexes = new ArrayList<>();
            }
            indexes.add(i);
            hashMap.put(String.valueOf(chars), indexes);
        }

        for (Map.Entry<String, List<Integer>> entry : hashMap.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.println(s[entry.getValue().get(i)]);
            }
            System.out.println("------");
        }
    }

    public static void main(String a[]) {
        printAnagramsTogether(new String[]{"cat", "dog", "tac", "god", "act"});
        printAnagramsTogether(new String[]{"cat", "tac", "act", "god", "dog"});
    }
}
