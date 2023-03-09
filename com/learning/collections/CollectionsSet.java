package com.learning.collections;

import java.util.*;

class Student{

    int roll;

    String name;

    Student(String name,int roll) {

        this.name = name;

        this.roll = roll;

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return roll == student.roll;

    }

    @Override
    public int hashCode() {

        return roll;

    }

    @Override
    public String toString() {
        return "Student{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                '}';
    }

}

public class CollectionsSet {

    public static void main(String[] args) {

//        Set<Integer> set = new HashSet<>();

//        Set<Integer> set = new LinkedHashSet<>();

        Set<Student> set1 = new TreeSet<>((student, t1) -> student.roll-t1.roll);
        set1.add(null);
        System.out.println(set1);

        Set<Integer> set = new TreeSet<>();
        set.add(34);
        System.out.println(set.add(34));
        set.add(24);
        set.add(14);
        set.add(null);
        System.out.println(set.add(04));
        System.out.println(set);
        System.out.println(set.remove(04));

        System.out.println(set);

        Set<Student> studentSet = new HashSet<>();
        studentSet.add(null);
        studentSet.add(new Student("mihir",20));
        studentSet.add(new Student("mihir",20));
        studentSet.add(new Student("mihir",20));
        System.out.println(studentSet.contains(new Student("mihir",20)));
        System.out.println(new Student("mihir",20).equals(new Student("mihir",20)));
        System.out.println(studentSet);
        System.out.println(new Student("naman",30).hashCode());
        System.out.println(new Student("naman",30).hashCode());

    }

}
