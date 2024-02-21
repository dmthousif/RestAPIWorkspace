package com.macys.pos.coreJava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class listExample {

    @Test
    public void reverseAList() {
        ArrayList<String> arrlist = new ArrayList<String>();
//Adding elements to ArrayList object
        arrlist.add("Nokia");
        arrlist.add("Samsung");
        arrlist.add("iPhone");
        arrlist.add("One+");
        System.out.println("BeforeReverse::" + arrlist);
        Collections.reverse(arrlist);
        System.out.println("AfterReverse::" + arrlist);
        Collections.reverse(arrlist);

        // Converting LinkedList to ArrayList
        LinkedList<String> linkedlist = new LinkedList<String>();
        ArrayList<String> list = new ArrayList<String>(linkedlist);
        System.out.println(list);
// Converting ArrayList to LinkedList
        List<String> list1 = new LinkedList<String>(list);
        System.out.println(list);




        }
    @Test
    public void getLowestAndHighestNumber(){
        LinkedList < Integer > list = new LinkedList < Integer > ();
        list.add(44);
        list.add(11);
        list.add(22);
        list.add(33);

        System.out.println(Collections.min(list));
        System.out.println(Collections.max(list));

        Collections.sort(list);
        System.out.println("LowestNumber::"+list.get(0));
        System.out.println("HighestNumber::"+list.get(list.size()-1));

    }

    //collection read-only
    //list = Collections.unmodifiableList(list);
    //set = Collections.unmodifiableSet(set);
    // map = Collections.unmodifiableMap(map);
}
