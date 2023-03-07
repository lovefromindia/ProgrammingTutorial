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
    public boolean equals(Object o) {g
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return roll == student.roll;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roll);
    }
}

public class CollectionsSet {

    public static void main(String[] args) {

//        Set<Integer> set = new HashSet<>();

//        Set<Integer> set = new LinkedHashSet<>();

        Set<Integer> set = new TreeSet<>();

        set.add(34);
        System.out.println(set.add(34));

        set.add(24);

        set.add(14);

        System.out.println(set.add(04));

        System.out.println(set);

        System.out.println(set.remove(04));

        System.out.println(set);

        Set<Student> studentSet = new HashSet<>();
        studentSet.add(new Student("mihir",20));
        studentSet.add(new Student("mihir",20));
        studentSet.add(new Student("mihir",20));
        System.out.println(studentSet.contains(new Student("mihir",20)));
        System.out.println(studentSet);
    }

}
