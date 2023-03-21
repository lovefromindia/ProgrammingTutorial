package com.learning.justChilling;

interface Action{
    public void perform();
}

public class AnonymousObjectInternals {
    public static void main(String[] args) {

        Action action = new Action() {
            @Override
            public void perform() {
                System.out.println("I am Performing");
            }
        };
        action.perform();

    }
}
