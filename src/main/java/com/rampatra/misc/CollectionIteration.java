package com.rampatra.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

/**
 * Created by IntelliJ IDEA.
 * <p/>
 * All possible ways of iterating different collections in Java.
 * Level: Basics
 *
 * @author rampatra
 * @since 10/16/15
 * @time: 9:24 AM
 */
public class CollectionIteration {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        // 1st way
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            out.println("List: " + iterator.next());
        }
        // 2nd way
        for (int i = 0; i < list.size(); i++) {
            out.println("List: " + list.get(i));
        }

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);
        // 1st way
        Iterator<Map.Entry<String, Integer>> iterator1 = hashMap.entrySet().iterator(); // iterator only iterates on 
        // lists or set and not on maps
        while (iterator1.hasNext()) {
            Map.Entry<String, Integer> entry = iterator1.next();
            out.println("HashMap: " + entry.getKey() + "->" + entry.getValue());
        }
        // 2nd way
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {   // entrySet() returns a Set of Entry objects 
            // stored in HashMap
            out.println("HashMap: " + entry.getKey() + "->" + entry.getValue());
        }
    }
}
