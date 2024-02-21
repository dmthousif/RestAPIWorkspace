package com.macys.pos.coreJava;

import java.util.HashSet;
import java.util.Set;

public class findFirstRepeated {


    public static void main(String[] args) {
        int[] program = {3, 7, 8, 1, 8, 7};
        int firstRepeated = findFirstRepeated(program);
        System.out.println("First repeated character: " + firstRepeated);
    }

    public static int findFirstRepeated(int[] program) {
        Set<Integer> seen = new HashSet<>();
        for (int num : program) {
            if (seen.contains(num)) {
                return num; // Found the first repeated character
            }
            seen.add(num);
        }
        return -1; // No repeated character found
    }


}
