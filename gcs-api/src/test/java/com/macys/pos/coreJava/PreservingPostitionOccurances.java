package com.macys.pos.coreJava;

public class PreservingPostitionOccurances {

    public static void main(String[] args) {
        String str = "aaabbacccccccccthousif";
        char temp = str.charAt(0);
        int counter = 0;
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            if (temp == str.charAt(i))
                counter++;
            else {
                res = res + temp + counter;
                counter = 0;
                temp = str.charAt(i);
                counter++;
            }
        }
        res = res + temp + counter; // Adding the last character and its count
        System.out.println("input::" + str);
        System.out.println("output::" + res);
    }

}
