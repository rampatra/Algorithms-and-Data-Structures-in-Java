package com.rampatra.linkedlists;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * <p/>
 * A simple LRU cache using {@link LinkedHashMap}. A special
 * LinkedHashMap(capacity, loadFactor, accessOrderBoolean) constructor is
 * provided to create a linked hash map whose order of iteration is the
 * order in which its entries were last accessed, from least-recently
 * accessed to most-recently. Invoking the put or get method results
 * in an access to the corresponding entry. If the enclosing Map is
 * access-ordered, it moves the entry to the end of the list; otherwise,
 * it does nothing.
 *
 * @author ramswaroop
 * @link http://javarticles.com/2012/06/linkedhashmap.html
 * @since 7/8/15
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
