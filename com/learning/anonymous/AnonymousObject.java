package com.learning.anonymous;

interface Greeting{
    void method();
}

class Animal{
    public void walk(){
        System.out.println("Animal is walking");
    }
}
public class AnonymousObject {

    public static void main(String[] args) {

        Greeting g = new Greeting() {
            @Override
            public void method() {
                System.out.println("Hello World");
            }
        };

        Animal bird = new Animal(){
          public void walk(){
              System.out.println("Animal is flying");
          }

          public void run(){
              System.out.println("");
          }
        };

//        ***run gives compilation error
//        bird.run();

    }

}
