package com.rampatra.linkedlists;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * <p/>
 * A simple LRU cache using {@link LinkedHashMap}.
 *
 * @author: ramswaroop
 * @date: 7/8/15
 * @time: 5:40 PM
 * @see: http://javarticles.com/2012/06/linkedhashmap.html
 */
public class LRUCache<E> {

    LinkedHashMap linkedHashMap;

    // initialize cache
    LRUCache(final int size) {
        this.linkedHashMap = new LinkedHashMap(size, .75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > size;
            }
        };
    }

    void add(E item) {
        linkedHashMap.put(item, null);
        printCache();
    }

    E get(E item) {
        E itemFromCache = (E) linkedHashMap.get(item);
        if (itemFromCache == null) {
            add(item);
            return item;
        }
        printCache();
        return itemFromCache;
    }

    void printCache() {
        Iterator<E> iterator = linkedHashMap.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ((iterator.hasNext()) ? "," : "\n"));
        }
    }

    public static void main(String a[]) {
        LRUCache<Integer> cache = new LRUCache<>(3);
        cache.add(1);
        cache.add(2);
        cache.add(3);
        cache.get(null);
        cache.add(4);
        cache.add(5);
        cache.get(null);
    }
}
