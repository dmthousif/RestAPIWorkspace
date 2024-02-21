package com.macys.pos.coreJava;



public class Singleton {

    //1
    private static Singleton instance;

    private Singleton() {

    }

    //Lazy singleton
    public static  Singleton getInstance() {


        if (instance == null)
            synchronized (Singleton.class){
                instance = new Singleton();
                System.out.print("Object Created");
            }

        return null;
    }


    public static void main(String[] args) {
        Singleton.getInstance();
        Singleton singleton = new Singleton();

    }



}

