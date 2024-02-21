package com.macys.pos.coreJava;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

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


        System.out.println("SetCompare::"+set1.equals(set2));
        set1.addAll(set2);
        System.out.println("SetCocatenate::"+set2);
        set1.containsAll(set2);
        System.out.println("SetCompare+containsAll::"+set3.containsAll(set4));
    }


}
