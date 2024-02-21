package com.macys.pos.coreJava;

import org.junit.Test;

public class StringsExample {

    @Test
    public void reverseAString() {
        String name = "Thousif is a automation tester";
        String reversedName = "";
        for (int i = name.length() - 1; i >= 0; i--) {
            reversedName += name.charAt(i);
        }
        System.out.println(reversedName);

    }

    @Test
    public void reverseASentence() {
        //reverse words
        String name = "Thousif is a automation tester";
        String wordsArr[] = name.split(" ");
        String reverseSentence = "";
        for (int j = 0; j < wordsArr.length; j++) {
            String temp = wordsArr[j];
            for (int i = temp.length() - 1; i >= 0; i--) {
                reverseSentence += temp.charAt(i);
            }
            reverseSentence += " ";
        }
        System.out.println(reverseSentence);
    }

    @Test
    public void swapSrings(){
        String s1 = "Thousif";
        String s2 = "Danki";
        s1 = s1 + s2;
        s2 = s1.substring(0, s1.length() - s2.length());
        s1 = s1.substring(s2.length());

        System.out.println("s1 =" + s1);
        System.out.println("s2 =" + s2);


    }
}




