package com.macys.pos.coreJava;

import org.junit.Test;

import java.util.*;

public class Duplicate {

    int[] intArr = {1, 2, 3, 4, 5, 3, 2, 1, 7, 8, 9, 0};

    @Test
    public void removeDuplicates() {
        TreeSet treeset = new TreeSet();
        for (int i : intArr) {
            treeset.add(i);
        }
        System.out.println(treeset);
    }

    //remove Duplicates
    @Test
    public void countDuplicatesUsingList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i : intArr) {
            if (!linkedList.contains(i)) {
                linkedList.add(i);
            }
        }
        System.out.println(linkedList);
        Collections.sort(linkedList);
        System.out.println(linkedList);
    }
    //FindDuplicate

    @Test
    public void findDuplicate() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        for (int i : intArr) {
            if (!linkedList.contains(i)) {
                linkedList.add(i);
            } else {
                linkedList2.add(i);
            }
        }
        System.out.println(linkedList2);
        Collections.sort(linkedList2);
        System.out.println(linkedList2);
    }

    @Test
    public void findDuplicate2() {
        String inputString = "rahulshettyacademy";
// Creating a hashmap object.
        HashMap<Character, Integer> map = new HashMap<>();
        char[] strArray = inputString.toCharArray();
        for (char c : strArray) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

        }
// Store the key values in a set and then get the number of each duplicate character.
        Set<Character> keys = map.keySet();
        for (char c : keys) {
            if (map.get(c) > 1) {
                System.out.println(c + "-->" + map.get(c));
            }
        }

    }


}
