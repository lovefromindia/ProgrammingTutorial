package com.learning.chaining;

import com.sun.net.httpserver.Filter;

import java.nio.channels.Channel;

public class Chaining {

    public Chaining walk(){
        System.out.println("I am walking");
        return this;
    }

    public Chaining sing(){
        System.out.println("I am singing");
        return this;
    }

    public static void main(String[] args) {

        Chaining obj = new Chaining();
        obj.walk().sing().sing().walk();

    }

}


