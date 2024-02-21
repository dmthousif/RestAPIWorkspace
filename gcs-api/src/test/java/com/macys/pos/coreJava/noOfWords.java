package com.macys.pos.coreJava;

import java.util.HashMap;
import java.util.Map;

public class noOfWords {

    public static void main(String[] args) {
        String str = "I am about to find the number of words present in the sentence";
        String[] strArr = str.split(" ");
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String key : strArr) {
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        System.out.println(map);
    }

}
