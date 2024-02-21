package com.macys.pos.coreJava;

import org.junit.Test;

import java.util.Scanner;

class PalindromeExample {

    public static void main(String args[]) {

        palindrome(454);
        palindrome();
    }

    static void palindrome(Integer number) {
        int r, sum = 0, temp;
        int n = number;//It is the number variable to be checked for palindrome
        temp = n;
        while (n > 0) {
            r = n % 10;  //getting remainder
            sum = (sum * 10) + r;
            n = n / 10;
        }
        if (temp == sum)
            System.out.println("palindrome number ");
        else
            System.out.println("not palindrome");
    }
    static void palindrome() {
        String original, reverse = ""; // Objects of String class
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string/number to check if it is a palindrome");
        original = in.nextLine();
        int length = original.length();
        for (int i = length - 1; i >= 0; i--)
            reverse = reverse + original.charAt(i);
        if (original.equals(reverse))
            System.out.println("Entered string/number is a palindrome.");
        else
            System.out.println("Entered string/number isn't a palindrome.");
    }
}


