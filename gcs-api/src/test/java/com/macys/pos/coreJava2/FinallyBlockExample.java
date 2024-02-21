package com.macys.pos.coreJava2;

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class FinallyBlockExample {
    public static void main(String[] args) throws CustomException {
        try {
            throwCustomException();
        } finally {
            System.out.println("Finally block executed.");
        }
    }

    public static void throwCustomException() throws CustomException {
        throw new CustomException("Custom exception thrown.");
    }
}
