package com.macys.pos.coreJava2;

public class ThisExample {

    public ThisExample() {
        this(20);
    }

    private ThisExample(int i) {
        System.out.print("Constructor with int argument");
    }

    public static void main(String[] args) {
        new ThisExample();
    }
}
