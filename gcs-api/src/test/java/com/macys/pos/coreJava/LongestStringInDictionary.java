package com.macys.pos.coreJava;

import java.util.*;

public class LongestStringInDictionary {

    public static String findLongestWord(String s, String[] dictionary) {
        String longestWord = "";
        for (String word : dictionary) {
            if (isSubsequence(word, s)) {
                if (word.length() > longestWord.length() ||
                        (word.length() == longestWord.length() && word.compareTo(longestWord) < 0)) {
                    longestWord = word;
                }
            }
        }
        return longestWord;
    }

    private static boolean isSubsequence(String word, String s) {
        int i = 0, j = 0;
        while (i < word.length() && j < s.length()) {
            if (word.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == word.length();
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        String[] dictionary = {"ale", "apple", "monkey", "plea"};
        System.out.println("Output: " + findLongestWord(s, dictionary)); // Output: "apple"
    }
}
