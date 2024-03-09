package com.macys.pos.coreJava;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;


import java.util.HashSet;
import java.util.Set;

class RemoveFromHashSet {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Set.of(1, 2, 3, 4, 5));
        System.out.println("Original HashSet: " + set);
        int elementToRemove = 3;
        set.remove(elementToRemove);
        System.out.println("HashSet after removing " + elementToRemove + ": " + set);
    }
}

public class setExample {
    static Set<Object> set1 = new HashSet<>();
    static Set<Object> set2 = new LinkedHashSet();
    static Set<Object> set3 = new TreeSet<>(); //Sorted set
    static Set<Object> set4 = new CopyOnWriteArraySet<>(); //ThreadSafe

    public static void main(String[] args) {
        set1.add("Thousif");
        set1.add(33);
        set1.add("Epam Systems");
        set1.add("8.01YOE");
        set1.add("8.01YOE");
        set1.add("Epam Systems");
        set1.add("Thousif");
        System.out.println(set1);
        set2.addAll(set1);
        System.out.println(set2);
        set3.add(11);
        set3.add(7);
        set3.add(0);
        set3.add(7);
        System.out.println(set3);

        set4.add(11);
        set4.add(7);
        set4.add(7);
        set4.add("thf");

        System.out.println(set4);

        for(Object obj : set4){
            System.out.println("iterate using for each loop:::"+obj);
        }

        System.out.println("SetCompare::"+set1.equals(set2));

        Set<Integer> sett1 = new HashSet<>(Set.of(1, 2, 3, 4, 5));
        Set<Integer> sett2 = new HashSet<>(Set.of(4, 5, 6, 7, 8));
        sett1.addAll(sett2);   // Union of sets
        System.out.println("Union of sets::"+sett1);

        Set<Integer> sete1 = new HashSet<>(Set.of(1, 2, 3, 4, 5));
        Set<Integer> sete2 = new HashSet<>(Set.of(4, 5, 6, 7, 8));
        sete1.retainAll(sete2);   // Intersection of sets
        System.out.println("Intersection of sets::"+sete1);



        sete1.containsAll(sete2);
        System.out.println("SetCompare+containsAll::"+set3.containsAll(set4));
    }


}
