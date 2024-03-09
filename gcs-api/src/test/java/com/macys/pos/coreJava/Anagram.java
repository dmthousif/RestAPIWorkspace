package com.macys.pos.coreJava;

import java.util.Arrays;


    public class Anagram {
        public static void main(String[] args) {
            String str1 = "listen";
            String str2 = "silent";
            boolean isAnagram = false;
            if (str1.length() == str2.length()) {
                char[] arr1 = str1.toCharArray();
                char[] arr2 = str2.toCharArray();
                Arrays.sort(arr1);
                Arrays.sort(arr2);
                isAnagram = Arrays.equals(arr1, arr2);
            }
            if (isAnagram) {
                System.out.println(str1 + " and " + str2 + " are anagrams.");
            } else {
                System.out.println(str1 + " and " + str2 + " are not anagrams.");
            }
        }
    }

