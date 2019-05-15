package com.rampatra.misc;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rampatra
 * @since 2019-05-15
 */
public class MapWithTimestamp<K, V> {

    private final Map<K, Map<Long, V>> map = new HashMap<>();

    public V get(K key, Long timestamp) {
        Map<Long, V> entry = map.get(key);

        return entry != null ? entry.get(timestamp) : null;
    }

    public void put(K key, Long timestamp, V value) {
        Map<Long, V> entry = map.get(key);

        if (entry == null) {
            map.put(key, new HashMap<Long, V>() {{
                put(timestamp, value);
            }});
        } else {
            entry.put(timestamp, value);
        }
    }

    public static void main(String[] args) throws Exception {
        MapWithTimestamp<Integer, Integer> mapWithTimestamp = new MapWithTimestamp<>();
        long timestamp1;
        long timestamp2;
        long timestamp3;

        mapWithTimestamp.put(1, timestamp1 = new Date().getTime(), 10_0);
        mapWithTimestamp.put(2, timestamp2 = new Date().getTime(), 20_0);
        Thread.sleep(100);
        mapWithTimestamp.put(2, new Date().getTime(), 20_1);
        Thread.sleep(100);
        mapWithTimestamp.put(2, new Date().getTime(), 20_2);
        mapWithTimestamp.put(3, timestamp3 = new Date().getTime(), 30_0);
        System.out.println(mapWithTimestamp.get(2, timestamp2));
        System.out.println(mapWithTimestamp.get(3, timestamp2));
        System.out.println(mapWithTimestamp.get(3, timestamp3));
    }
}