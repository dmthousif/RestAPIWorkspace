package com.macys.pos.coreJava;

import org.junit.Test;

import java.util.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class FindDuplicates {
    public static void main(String[] args) {
        List<Integer> listWithDuplicates = new ArrayList<>(List.of(1, 2, 3, 3, 4, 5, 5));
        Set<Integer> uniqueElements = new HashSet<>();
        Set<Integer> duplicateElements = new HashSet<>();
        for (int num : listWithDuplicates) {
            if (!uniqueElements.add(num)) {
                duplicateElements.add(num);
            }
        }
        System.out.println("Duplicate elements: " + duplicateElements);
    }
}


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
    public void removeDuplicatesUsingList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i : intArr) {
            if (!linkedList.contains(i)) {
                linkedList.add(i);
            }
        }
        System.out.println(linkedList);
        Collections.sort(linkedList);   //Collections class
        System.out.println(linkedList);
    }


    //FindDuplicate

    @Test
    public void findDuplicate() {
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        for (int i : intArr) {
            if (!linkedList1.contains(i)) {
                linkedList1.add(i);
            } else {
                linkedList2.add(i);
            }
        }
        System.out.println(linkedList2);
        Collections.sort(linkedList2);
        System.out.println(linkedList2);
        Collections.reverse(linkedList2);
        System.out.println("reverse"+linkedList2);
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


    public static void main(String[] args) {
        int[] intArr = {1, 2, 3, 4, 5, 3, 2, 1, 7, 8, 9, 0};

        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();

        for (int num : intArr) {
            if (!seen.add(num)) {
                // If number already exists in 'seen', it's a duplicate
                duplicates.add(num);
            }
        }

        // Print the duplicates found
        System.out.println("Duplicates found:");
        for (int num : duplicates) {
            System.out.println(num);
        }
    }


}
