package com.rampatra.linkedlists;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * A simple LRU cache using {@link LinkedHashMap}. A special
 * LinkedHashMap(capacity, loadFactor, accessOrderBoolean) constructor is
 * provided to create a linked hash map whose order of iteration is the
 * order in which its entries were last accessed, from least-recently
 * accessed to most-recently. Invoking the put or get method results
 * in an access to the corresponding entry. If the enclosing Map is
 * access-ordered, it moves the entry to the end of the list; otherwise,
 * it does nothing.
 * See <a href="http://javarticles.com/2012/06/linkedhashmap.html">Javarticles.com</a>.
 *
 * @author rampatra
 * @since 7/8/15
 */
public class LRUCache<E, V> {

    private LinkedHashMap<E, V> linkedHashMap;

    // initialize cache
    LRUCache(final int size) {
        this.linkedHashMap = new LinkedHashMap<E, V>(size, .75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > size;
            }
        };
    }

    V add(E key, V value) {
        return linkedHashMap.put(key, value);
    }

    V get(E key) {
        return linkedHashMap.get(key);
    }

    private void print() {
        Iterator<E> iterator = linkedHashMap.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ((iterator.hasNext()) ? "," : "\n"));
        }
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> cache = new LRUCache<>(3);
        cache.add(1, 1);
        cache.add(2, 2);
        cache.add(3, 3);
        cache.print(); // initial cache contents

        cache.add(4, 4); // should remove 1 as it was accessed last
        cache.print();

        cache.get(2);
        cache.add(5, 5); // should remove 3 as 2 was recently accessed
        cache.print();
    }
}
