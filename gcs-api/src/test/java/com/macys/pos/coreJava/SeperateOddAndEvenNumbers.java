package com.macys.pos.coreJava;

public class SeperateOddAndEvenNumbers {

    static int[] arr = {2, 3, 5, 68, 8, 4, 5, 79, 9};
    static int[] a = new int[arr.length];
    static int index = 0;

    public static void main(String[] args) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                a[index] = arr[i];
                index++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                a[index] = arr[i];
                index++;
            }
        }

        for (int i = 0; i < index; i++) {
            System.out.print(a[i] + ",");
        }
    }
}
