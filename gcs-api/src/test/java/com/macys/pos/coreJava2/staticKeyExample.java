package com.macys.pos.coreJava2;

import org.junit.Test;

public class staticKeyExample {



    static void show() {
        System.out.println("Static method WITHOUT arguement");
    }

    static void show(int i) {
        System.out.println("Static method WITH arguement");
    }

    //method overloading is possible with StaticMethods

    public static void main(String[] args) {
        //staticKeyExample.show(50);
    }

}

class ChildStaticKeyExample extends staticKeyExample {
    //method overlRiding is possible with StaticMethods
    static void show(int i) {
        System.out.println("CHILD --- Static method WITH arguement");
    }

    public static void main(String[] args) {
        ChildStaticKeyExample.show(50);

        ChildStaticKeyExample child = new ChildStaticKeyExample();
        child.test();

    }

    public void test(){
        ChildStaticKeyExample.show(50);
    }
}