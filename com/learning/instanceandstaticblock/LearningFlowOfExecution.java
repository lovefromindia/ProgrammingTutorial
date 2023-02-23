package com.learning.instanceandstaticblock;

class class1 {
    class1() {
        System.out.println("class1 constructor invoked");
    }

    {
        System.out.println("class1 instance block");
    }
}

class class2 extends class1 {
    class2() {
        System.out.println("class2 constructor invoked");
    }

    {
        System.out.println("class2 instance block");
    }
}

class class3 extends class2 {
    class3() {
        super();
        System.out.println("class3 constructor invoked");
    }
    
    {
        System.out.println("class3 instance block");
    }
}

public class LearningFlowOfExecution {
    public static void main(String args[]) {
        class3 object = new class3();
    }
}