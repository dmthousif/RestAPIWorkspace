package com.macys.pos.coreJava;


class A {
    public A() {
        System.out.println("A");
    }

    public A(int i) {
        System.out.println("Int A");
    }

}

class B extends A {
    public B() {
        System.out.println("B");
    }

    public B(int i) {
        super();
        System.out.println("Int B");
    }
}


public class superExample {

    A obj = new A(21);
}