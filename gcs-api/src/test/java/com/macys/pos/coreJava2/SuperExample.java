package com.macys.pos.coreJava2;

public class SuperExample {
    public String myname = "Thousif";

    void thousif() {
        System.out.println("SuperExampleParent");
    }

    void Arif() {
        System.out.println("Parent-Arif");
    }
}

class SuperExampleChild extends SuperExample {


    public static void main(String[] args) {
        SuperExampleChild superExampleChild = new SuperExampleChild();
        superExampleChild.thousif(); //Method overRiding


    }

    void Arif() {
        System.out.println("Child-Arif");
    }

    void thousif() {
        super.thousif(); // calling parent method using super key
        super.thousif();
        System.out.println(super.myname);
        this.Arif();
        System.out.println("SuperExampleChild");
    }
}