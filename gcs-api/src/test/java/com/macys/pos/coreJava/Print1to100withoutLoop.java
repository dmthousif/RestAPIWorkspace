package com.macys.pos.coreJava;

public class Print1to100withoutLoop {


    public static void main(String[] args) {
        printnum(1);

    }

    public static void printnum(int num) {
        if (num <= 100) {
            System.out.println(num);
            num++;
            printnum(num);

        }


    }
}