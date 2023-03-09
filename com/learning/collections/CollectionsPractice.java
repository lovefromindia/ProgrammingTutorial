package com.learning.collections;

import java.util.*;


public class CollectionsPractice {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(4);
        arrayList.add(1);
        arrayList.add(3);


        Collections.sort(arrayList);
        System.out.println(arrayList);
        System.out.println(Collections.binarySearch(arrayList,4));

        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student("mihir",3));
        studentArrayList.add(new Student("mihir",2));
        studentArrayList.add(new Student("mahir",2));
        studentArrayList.add(new Student("mhir",2));
        Collections.sort(studentArrayList, new Comparator<Student>() {

            @Override
            public int compare(Student student, Student t1) {
                //first compare students by name and if same name then roll number comparison
                return student.name.equals(t1.name)?student.roll-t1.roll:student.name.compareTo(t1.name);

            }

        });

        System.out.println(studentArrayList);

    }

}
