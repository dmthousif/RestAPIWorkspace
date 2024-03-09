package com.macys.pos.coreJava;

public class reverseString {


    public static void main(String[] args) {
        String str = "thousif";
        StringBuilder sb = new StringBuilder(str);
        StringBuffer sbf = new StringBuffer(str);
        char charr[] = str.toCharArray();
        String reverse1 = "";
        String reverse2 = "";
        for (int i = charr.length-1; i >= 0; i--) {
            reverse1 += charr[i];
            reverse2 += str.charAt(i);
        }
        System.out.println(reverse1);
        System.out.println(reverse2);
        System.out.println(sb.reverse());
        System.out.println(sbf.reverse());

    }


}
