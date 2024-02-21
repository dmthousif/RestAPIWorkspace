package com.macys.pos.coreJava;

public class trickyReverseFirstAndLastWords {
    //Reverse  word


        public static void main(String[] args) {
            String str = "My name is thousif";
            String[] words = str.split(" ");
            if (words.length >= 2) {
                // Reverse the first and last words
                String firstWord = words[0];
                String lastWord = words[words.length - 1];
                words[0] = reverseWord(firstWord);
                words[words.length - 1] = reverseWord(lastWord);
                // Reconstruct the string with reversed first and last words
                String result = String.join(" ", words);
                System.out.println(result);
            } else {
                System.out.println(str); // If there's only one word, return the original string
            }
        }

        private static String reverseWord(String word) {
            char[] chars = word.toCharArray();
            int length = chars.length;
            for (int i = 0; i < length / 2; i++) {
                char temp = chars[i];
                chars[i] = chars[length - i - 1];
                chars[length - i - 1] = temp;
            }
            return new String(chars);
        }



}
