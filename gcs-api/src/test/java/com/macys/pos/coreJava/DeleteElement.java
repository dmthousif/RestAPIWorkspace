package com.macys.pos.coreJava;

public class DeleteElement
{

        static int[] arr = {2, 3, 5, 3, 8, 4, 5, 3, 9};
        static int[] newArr = new int[arr.length];
        static int index = 0;
        static int elementToDelete = 3;

        public static void main(String[] args) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != elementToDelete) {
                    newArr[index] = arr[i];
                    index++;
                }
            }

            for (int i = 0; i < index; i++) {
                System.out.println(newArr[i]);
            }
        }
}
