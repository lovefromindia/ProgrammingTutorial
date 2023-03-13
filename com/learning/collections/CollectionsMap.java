package com.learning.collections;

import java.util.*;

class Teacher{

    int id;

    String name;

    Teacher(String name,int id) {

        this.name = name;

        this.id = id;

    }



//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Teacher teacher = (Teacher) o;
//        return id == teacher.id;
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
}

class TeacherComparator implements Comparator<Teacher>{

    @Override
    public int compare(Teacher teacher, Teacher t1) {

        return teacher.id-t1.id;

    }

}

public class CollectionsMap {

    public static void main(String[] args) {

        Map<Teacher, Double> salaryMap = new TreeMap<>(new TeacherComparator());
//        salaryMap.put(null,1000.0);
        salaryMap.put(new Teacher("Mihir",800),1200.0);
        salaryMap.put(new Teacher("Mihir",300),1000.0);
        salaryMap.put(new Teacher("Mahir",400),500.0);
        System.out.println(salaryMap);

        salaryMap = new HashMap<>();
        System.out.println(new Teacher("Mihir",300));
        System.out.println(new Teacher("Mihir",300));
        salaryMap.put(new Teacher("Mihir",300),1000.0);
        salaryMap.put(new Teacher("Mihir",300),1200.0);
        salaryMap.put(new Teacher("Mahir",400),500.0);
        salaryMap.put(null, 40.0);
        System.out.println(salaryMap.get(null));
        System.out.println(salaryMap);

        salaryMap = new LinkedHashMap<>();
        salaryMap.put(new Teacher("Mihir",500),1000.0);
        salaryMap.put(new Teacher("Mihir",600),1200.0);
        salaryMap.put(new Teacher("Mahir",400),500.0);
        System.out.println(salaryMap);

        Map<String,Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("Mihir", 40);
        stringIntegerMap.put("Mihir", 50);
        stringIntegerMap.put(new String("Mihir"), 60);
        stringIntegerMap.put(null, 40);
        System.out.println(stringIntegerMap.containsKey(null));
        System.out.println(stringIntegerMap.get("lol"));
        System.out.println(stringIntegerMap.remove(null));
        System.out.println(stringIntegerMap);

    }

}