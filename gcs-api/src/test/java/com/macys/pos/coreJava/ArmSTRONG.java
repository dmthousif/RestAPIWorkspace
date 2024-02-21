package com.macys.pos.coreJava;

public class ArmSTRONG {


    public static void main(String[] args) {
        int num = 371;
        int actualnum = num;
        double result = 0;
        while (actualnum != 0) {
            int n = actualnum % 10;
            ///result = result + Math.pow(n, 3);
            result = result + n*n*n;
            actualnum = actualnum / 10;
        }
        if (result == num) {
            System.out.println(num + " is an Armstrong number");
        } else {
            System.out.println(num + " is not an Armstrong number");
        }

    }

}



