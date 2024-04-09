package com.macys.pos.coreJava;

public class CapitalChangeCase {


    public static void main(String[] args) {
        String str = "thousif";
        String modifiedStr = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (i % 2 == 0) {
                modifiedStr += Character.toUpperCase(ch);
            } else {
                modifiedStr += ch;
            }


        }
        System.out.println(modifiedStr);
    }
}
