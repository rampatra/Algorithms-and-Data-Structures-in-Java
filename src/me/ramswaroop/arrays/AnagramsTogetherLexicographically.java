package me.ramswaroop.arrays;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 10/11/15
 * @time: 7:56 PM
 */
public class AnagramsTogetherLexicographically {

    // todo lexicographic for the entire output
    public static void printAnagramsTogether(String[] s) {

        TreeMap<String, List<Integer>> treeMap = new TreeMap<>();

        for (int i = 0; i < s.length; i++) {
            String removeSpaces = s[i].replaceAll("\\s+", "");
            char[] chars = removeSpaces.toCharArray();
            Arrays.sort(chars);

            List<Integer> indexes = treeMap.get(String.valueOf(chars));
            if (indexes == null) {
                indexes = new ArrayList<>();
            }
            indexes.add(i);
            treeMap.put(String.valueOf(chars), indexes);
        }

        for (Map.Entry<String, List<Integer>> entry : treeMap.entrySet()) {
            List<String> anagrams = new ArrayList<>();
            for (int i = 0; i < entry.getValue().size(); i++) {
                anagrams.add(s[entry.getValue().get(i)]);
            }

            // print anagrams lexicographically within a single line
            Collections.sort(anagrams);
            
            for (int i = 0; i < anagrams.size(); i++) {
                System.out.print(anagrams.get(i));
                if (anagrams.size() - i > 1) System.out.print(",");
            }
            System.out.println();
        }
    }

    public static void main(String a[]) {
        Scanner in = new Scanner(System.in);
        List<String> strings = new ArrayList<>();
        while (in.hasNextLine()) {
            strings.add(in.nextLine());
        }
        printAnagramsTogether(strings.toArray(new String[0]));
    }
}
