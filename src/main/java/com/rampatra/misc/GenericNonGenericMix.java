package com.rampatra.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: rampatra
 * Date: 3/26/15
 * Time: 3:06 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class GenericNonGenericMix {
    static List add(ArrayList list) {
        list.add(new String("100"));
        list.add(new Integer(10)); // will throw exception at runtime
        return list;
    }

    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("ram");
        add(stringArrayList);
        for (String s : stringArrayList) {
            System.out.println(s);
        }
    }
}
