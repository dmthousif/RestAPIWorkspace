package com.macys.pos.coreJava;

import java.util.*;

public class SecondLargestElementOfArray {

    static void secondLargest(int[] arr){
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);

        }
       Object [] Newarr = set.toArray();





    }
    public static void main(String[] args) {

        int[] arr = {2, 3, 1, 6, 9, 9,9,9,9,9};
        SecondLargestElementOfArray.secondLargest(arr);


        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] != arr[arr.length - 1]) {
                System.out.println("The second largest element " + arr[i]);
                break;
            }
        }

    }

}
