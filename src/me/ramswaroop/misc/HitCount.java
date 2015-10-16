package me.ramswaroop.misc;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 10/16/15
 * @time: 8:40 AM
 */
public class HitCount {

    public static String getIPWithMaxHitCount(List<String> inputList) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for (int i = 0; i < inputList.size(); i++) {
            String input = inputList.get(i);
            String ip = input.substring(0, input.indexOf(" "));
            if (hashMap.get(ip) == null) {
                hashMap.put(ip, 1);
            } else {
                hashMap.put(ip, hashMap.get(ip) + 1);
            }
        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(hashMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue()); // desc order
            }
        });
        
        return list.get(0).getKey();        
    }

    public static void main(String a[]) {
        List<String> inputList = new ArrayList<>();
        inputList.add("10.1.2.23 http://we.sdfdsf.sdf");
        inputList.add("10.1.2.24 http://we.sdfdsf.sdf");
        inputList.add("10.1.2.24 http://we.sdfdsf.sdf");
        inputList.add("10.1.2.24 http://we.sdfdsf.sdf");
        inputList.add("10.1.2.24 http://we.sdfdsf.sdf");
        inputList.add("10.1.2.23 http://we.sdfdsf.sdf");
        inputList.add("10.1.2.23 http://we.sdfdsf.sdf");
        System.out.println(getIPWithMaxHitCount(inputList));
    }
}
