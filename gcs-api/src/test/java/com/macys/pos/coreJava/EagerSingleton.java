package com.macys.pos.coreJava;

public class EagerSingleton {
    // Private static variable to hold the single instance of the class
    private static final EagerSingleton instance = new EagerSingleton();

    // Private constructor to prevent instantiation from outside the class
    private EagerSingleton() {
        // Optional: You can initialize instance variables here
    }

    // Public static method to get the single instance of the class
    public static EagerSingleton getInstance() {
        // Since the instance is already initialized, directly return it
        return instance;
    }
    // Optional: Add other methods or variables here
}
