package com.learning.serialize;

import java.io.*;

import java.util.HashMap;

import java.util.Map;

class Student implements Serializable{

    int roll;

    String name;

    int std;

    transient  float stipend;

    Student(int roll,String name,int std,float stipend){

        this.roll = roll;

        this.name = name;

        this.std = std;

        this.stipend = stipend;

    }

    @Override
    public String toString(){

        return this.roll + ":" + this.name + ":" + this.std + ":" + this.stipend + "\n";

    }

}

public class SerializationPractice{

    public static void main(String[] args) {

        try {

            FileOutputStream ofs = new FileOutputStream("StudentInfo.txt");
            ObjectOutputStream oos = new ObjectOutputStream(ofs);
            oos.writeObject(new Student(1,"Mihir",1,1.0f));

            Map<String,Integer> mp = new HashMap<>();
            mp.put("Mihir", 300);
            oos.writeObject(mp);

            FileInputStream ifs = new FileInputStream("StudentInfo.txt");
            ObjectInputStream ois = new ObjectInputStream(ifs);
            // Method for deserialization of object
            Student s1 = (Student)ois.readObject();
            System.out.println(s1);

            //Method for getting deserializing and getting map
            mp = (Map<String, Integer>) ois.readObject();
            System.out.println(mp);

        }catch (Exception e){

            System.out.println("here" + e.getMessage());

        }

    }

}
