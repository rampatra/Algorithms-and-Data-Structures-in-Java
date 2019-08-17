package com.leetcode.graphs;

import javafx.util.Pair;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Hard
 * Link: https://leetcode.com/problems/word-ladder-ii/
 * Description:
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s)
 * from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * <p>
 * Note:
 * - Return an empty list if there is no such transformation sequence.
 * - All words have the same length.
 * - All words contain only lowercase alphabetic characters.
 * - You may assume no duplicates in the word list.
 * - You may assume beginWord and endWord are non-empty and are not the same.
 * <p>
 * Example 1:
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output:
 * [
 *  ["hit","hot","dot","dog","cog"],
 *  ["hit","hot","lot","log","cog"]
 * ]
 * <p>
 * <p>
 * Example 2:
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * Output: []
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 * @author rampatra
 * @since 2019-08-15
 */
public class WordLadderII {

    /**
     * The approach is same as {@link WordLadder}. We calculate the {@code minDistance} from start to end word and also
     * keep a map of words and its adjacent words (i.e, with only character difference). After we are done calculating
     * the {@code mindistance}, we perform a dfs on the map upto depth {@code minDistance} and if the last word at this
     * depth is equal to the end word then we add all words to the result.
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();
        List<List<String>> ladders = new LinkedList<>();
        Map<String, Set<String>> transformedToOriginalWordMap = new HashMap<>();
        Queue<Pair<String, Integer>> queue = new LinkedList<>();

        wordList.forEach(word -> {
                    String transformedWord;
                    for (int i = 0; i < L; i++) {
                        transformedWord = word.substring(0, i) + "*" + word.substring(i + 1, L);
                        transformedToOriginalWordMap.putIfAbsent(transformedWord, new HashSet<>());
                        transformedToOriginalWordMap.get(transformedWord).add(word);
                    }
                }
        );

        int minDistance = -1;
        Set<String> visited = new HashSet<>();
        queue.add(new Pair<>(beginWord, 1));
        visited.add(beginWord);

        HashMap<String, Set<String>> connectedNodes = new HashMap<>();

        while (!queue.isEmpty()) {
            Pair<String, Integer> currPair = queue.poll();
            String word = currPair.getKey();
            Integer level = currPair.getValue();

            if (word.equals(endWord) && minDistance == -1) {
                minDistance = level - 1;
            }

            String transformedWord;
            for (int i = 0; i < L; i++) {
                transformedWord = word.substring(0, i) + "*" + word.substring(i + 1, L);

                for (String originalWord : transformedToOriginalWordMap.getOrDefault(transformedWord, Collections.emptySet())) {
                    if (!visited.contains(originalWord)) {
                        queue.add(new Pair<>(originalWord, level + 1));
                        visited.add(originalWord);
                    }

                    if (!word.equals(originalWord)) {
                        connectedNodes.putIfAbsent(word, new HashSet<>());
                        connectedNodes.get(word).add(originalWord);
                    }
                }
            }
        }

        dfs(ladders, new LinkedHashSet<>(), connectedNodes, beginWord, endWord, 0, minDistance);

        return ladders;
    }

    /**
     * Perform dfs on the map which contains words and its adjacent words.
     *
     * @param ladders
     * @param ladder
     * @param connectedNodes
     * @param startNode
     * @param endNode
     * @param distance
     * @param minDistance
     */
    private static void dfs(List<List<String>> ladders, Set<String> ladder, Map<String, Set<String>> connectedNodes,
                            String startNode, String endNode, int distance, int minDistance) {
        if (distance == minDistance && startNode.equals(endNode)) {
            ladder.add(endNode);
            ladders.add(new ArrayList<>(ladder));
            return;
        } else if (distance > minDistance) {
            return;
        }

        ladder.add(startNode);
        for (String nextNode : connectedNodes.getOrDefault(startNode, new HashSet<>())) {
            if (!ladder.contains(nextNode)) {
                dfs(ladders, new LinkedHashSet<>(ladder), connectedNodes, nextNode, endNode, distance + 1, minDistance);
            }
        }
    }

    public static void main(String[] args) {
        assertEquals("[[hit, hot, lot, log, cog], [hit, hot, dot, dog, cog]]", findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")).toString());
        // TODO Fix this test case System.out.println(findLadders("cet", "ism", Arrays.asList("kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay", "sip", "kay", "per", "val", "mes", "ohs", "now", "boa", "cet", "pal", "bar", "die", "war", "hay", "eco", "pub", "lob", "rue", "fry", "lit", "rex", "jan", "cot", "bid", "ali", "pay", "col", "gum", "ger", "row", "won", "dan", "rum", "fad", "tut", "sag", "yip", "sui", "ark", "has", "zip", "fez", "own", "ump", "dis", "ads", "max", "jaw", "out", "btu", "ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie", "toy", "fat", "cal", "lie", "noh", "sew", "ono", "tam", "flu", "mgm", "ply", "awe", "pry", "tit", "tie", "yet", "too", "tax", "jim", "san", "pan", "map", "ski", "ova", "wed", "non", "wac", "nut", "why", "bye", "lye", "oct", "old", "fin", "feb", "chi", "sap", "owl", "log", "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax", "hip", "jib", "mel", "hus", "sob", "ifs", "tab", "ara", "dab", "jag", "jar", "arm", "lot", "tom", "sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk", "far", "mew", "wit", "doe", "gas", "rte", "ian", "pot", "ask", "wag", "hag", "amy", "nag", "ron", "soy", "gin", "don", "tug", "fay", "vic", "boo", "nam", "ave", "buy", "sop", "but", "orb", "fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod", "yam", "pew", "web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon", "dog", "bib", "rub", "ere", "dig", "era", "cat", "fox", "bee", "mod", "day", "apr", "vie", "nev", "jam", "pam", "new", "aye", "ani", "and", "ibm", "yap", "can", "pyx", "tar", "kin", "fog", "hum", "pip", "cup", "dye", "lyx", "jog", "nun", "par", "wan", "fey", "bus", "oak", "bad", "ats", "set", "qom", "vat", "eat", "pus", "rev", "axe", "ion", "six", "ila", "lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap", "lop", "may", "shy", "rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj", "hue", "thy", "ava", "rap", "den", "fla", "auk", "cox", "ibo", "hey", "saw", "vim", "sec", "ltd", "you", "its", "tat", "dew", "eva", "tog", "ram", "let", "see", "zit", "maw", "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow", "cod", "bed", "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao", "aug", "mum", "hoe", "bah", "hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem", "who", "bet", "gos", "son", "ear", "spy", "kit", "boy", "due", "sen", "oaf", "mix", "hep", "fur", "ada", "bin", "nil", "mia", "ewe", "hit", "fix", "sad", "rib", "eye", "hop", "haw", "wax", "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our", "ado", "sin", "mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui", "yak", "bay", "poi", "yep", "bun", "try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe", "dee", "wig", "sly", "rip", "geo", "cog", "pas", "zen", "odd", "nan", "lay", "pod", "fit", "hem", "joy", "bum", "rio", "yon", "dec", "leg", "put", "sue", "dim", "pet", "yaw", "nub", "bit", "bur", "sid", "sun", "oil", "red", "doc", "moe", "caw", "eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid", "pun", "ton", "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil", "jig", "hub", "low", "did", "tin", "get", "gte", "sox", "lei", "mig", "fig", "lon", "use", "ban", "flo", "nov", "jut", "bag", "mir", "sty", "lap", "two", "ins", "con", "ant", "net", "tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop", "tot", "sow", "sal", "sic", "ted", "wot", "del", "imp", "cob", "way", "ann", "tan", "mci", "job", "wet", "ism", "err", "him", "all", "pad", "hah", "hie", "aim", "ike", "jed", "ego", "mac", "baa", "min", "com", "ill", "was", "cab", "ago", "ina", "big", "ilk", "gal", "tap", "duh", "ola", "ran", "lab", "top", "gob", "hot", "ora", "tia", "kip", "han", "met", "hut", "she", "sac", "fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala", "ape", "rig", "cid", "god", "duo", "lin", "aid", "gel", "awl", "lag", "elf", "liz", "ref", "aha", "fib", "oho", "tho", "her", "nor", "ace", "adz", "fun", "ned", "coo", "win", "tao", "coy", "van", "man", "pit", "guy", "foe", "hid", "mai", "sup", "jay", "hob", "mow", "jot", "are", "pol", "arc", "lax", "aft", "alb", "len", "air", "pug", "pox", "vow", "got", "meg", "zoe", "amp", "ale", "bud", "gee", "pin", "dun", "pat", "ten", "mob")));
    }
}
