package com.learning.practicing;

class Foo{

    static{

        System.out.println("Static block of Foo");

    }

    {

        System.out.println("Instance block of Foo");

    }

}

class Bar extends Foo{

    static{

        System.out.println("Static block of Bar");

    }

    {

        System.out.println("Instance block of Bar");

    }

}

class Zoo extends Bar{

    static{

        System.out.println("Static block of Zoo");

    }

    {

        System.out.println("Instance block of Zoo");

    }

}

interface Animal{

    static void eat(){

        System.out.println("In Animal");

    }

}

class FooBar implements Animal{

    static void eat(){

        System.out.println("In FooBar");

    }

}


public class LearningWeirdQuestion11 {

    public static void main(String[] args) {

        Foo f = new Zoo();

        Animal animal = new FooBar();
//        animal.eat(); ***This will give Error as Static methods in
//        Interface can be only invoked only by Interface Class and not any reference of Interface
        Animal.eat();

        FooBar foobar = null;

        foobar.eat();

    }

}

