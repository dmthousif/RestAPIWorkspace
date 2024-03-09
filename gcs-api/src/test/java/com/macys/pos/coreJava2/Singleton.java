package com.macys.pos.coreJava2;

public class Singleton {

    //Declare
    private static Singleton instance;

    //Declare constructor private
    private Singleton() {

    }

    //Lazy singleton
    public static  Singleton getInstance() {

//if there is no object create a object
        if (instance == null)
            synchronized (Singleton.class){
                instance = new Singleton();
                System.out.print("Object Created");
            }

        return null;
    }


    public static void main(String[] args) {
        Singleton.getInstance();
        //Singleton singleton = new Singleton();

    }



}

