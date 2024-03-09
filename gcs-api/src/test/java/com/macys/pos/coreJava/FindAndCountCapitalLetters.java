package com.macys.pos.coreJava;

import org.junit.Test;

public class FindAndCountCapitalLetters {

    @Test
    public void getCapsWordsInString() {
        String inputString = "ajsdbALSDNIAWDWAsdaswdq11";
        int counter = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) >= 'A' && inputString.charAt(i) <= 'Z') {
                System.out.print(inputString.charAt(i)+"::");
                counter++;
            }
        }
        System.out.println(counter);
    }

}
