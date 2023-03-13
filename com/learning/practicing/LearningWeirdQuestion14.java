package com.learning.practicing;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Student_{
    int roll;
    String name;
    Student_(int roll,String name){
        this.roll = roll;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        Student_ student = (Student_) o;
        return roll == student.roll;
    }

    @Override
    public int hashCode() {
        return roll;
    }
}

public class LearningWeirdQuestion14 {

    public static void main(String[] args) {
        Map<Student_,Integer> mp = new HashMap<>();
        mp.put(new Student_(10,"Manas"),3000);
        System.out.println(mp.get(new Student_(10,"Manas")));
    }

}
