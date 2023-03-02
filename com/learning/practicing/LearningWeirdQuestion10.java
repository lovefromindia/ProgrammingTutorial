package com.learning.practicing;

class LessBalance extends Exception{

    private String message = null;

    LessBalance(String message){

//        super(message); //**You can also do this instead of having our own message string and overriding getMessage()
        this.message = message;

    }

    public String getMessage(){
        return this.message;
    }

}

public class LearningWeirdQuestion10 {

    public static boolean check(Double amount) throws LessBalance{

        if(amount < 1000)

            throw new LessBalance("Less than 1000");

        else

            return true;

    }

    public static void main(String[] args) {

        try {

            ABC ref = new DEF();

            ref = null;

            System.gc();

//            check(100d);
        }catch (Exception e){

            System.out.println(e.getMessage());

            System.out.println(e.getStackTrace());

        }

    }

}

class ABC{

    ABC(){
        System.out.println("ABC creating");
    }

    protected void finalize(){
        System.out.println("ABC destroying");
    }

}

class DEF extends ABC{

    DEF(){
        System.out.println("DEF creating");
    }
    @Override
    protected void finalize(){

        System.out.println("DEF destroying");

        super.finalize();

    }

}
