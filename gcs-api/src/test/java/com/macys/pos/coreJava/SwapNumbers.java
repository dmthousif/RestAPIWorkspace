package com.macys.pos.coreJava;

public class SwapNumbers {



        public static void main(String[] args) {

            int num1 = 70;
            int num2 = 20;

// Logic to swap 2 numbers.
       num1 = num1+num2;
       num2 = num1-num2;
       num1 = num1-num2;

            System.out.println("num1 = " + num1);
            System.out.println("num2 = " + num2);
        }


}
