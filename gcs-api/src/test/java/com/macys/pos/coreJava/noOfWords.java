package com.macys.pos.coreJava;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class noOfWords {

    public static void main(String[] args) {
        String str = "Sky is blue blue sky blue ";
        String[] strArr = str.split(" ");
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        for (String key : strArr) {
            if (!map.containsKey(key) ) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        String stringWithoutDuplicates = "";
        for (String key : map.keySet()) {
            if (map.get(key) <= 1)
                stringWithoutDuplicates = stringWithoutDuplicates+key+" ";

        }
        System.out.println("stringWithDuplicates::" + str);
        System.out.println("stringWithoutDuplicates::" + stringWithoutDuplicates);
    }

    void remove_Duplicates() {
        String str = "I am about to find the number of words present in the sentence";
        String[] strArr = str.split(" ");
        str.contains("am");


    }

}
