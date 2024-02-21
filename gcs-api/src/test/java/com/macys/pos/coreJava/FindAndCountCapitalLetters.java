package com.macys.pos.coreJava;

import org.junit.Test;

public class FindAndCountCapitalLetters {

    @Test
    public void getCapsWordsInString() {
        String inputString = "ajsdbALSDNIAWDWAsdaswdq";
        int counter = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) >= 'A' && inputString.charAt(i) <= 'Z') {
                counter++;
            }
        }
        System.out.println(counter);
    }

}
