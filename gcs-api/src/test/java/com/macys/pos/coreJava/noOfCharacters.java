package com.macys.pos.coreJava;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class noOfCharacters {
    public static void main(String[] args) {
// Input value which needs to be passed in the below method.





        characterCount("rahulshettyacademy");
        characterCountUsingTraditionWay("rahulshettyacademy");

    }
    static void characterCount(String inputString) {
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
// Print the hashmap object which gives the number of each character in String.
        System.out.println(map);

    }



    private static void characterCountUsingTraditionWay(String str) {

        char [] chrarr = str.toCharArray();

        for(char ch: chrarr){
            int count=0;
            for(char c: chrarr){

                if(ch==c){
                    count++;
                }

            }
            System.out.print(ch+"="+count+",");

        }
    }


}


