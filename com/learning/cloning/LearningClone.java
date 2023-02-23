package com.learning.cloning;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

class Human{

    String name;Integer age = 0;public String[] family;

    private static BufferedReader br = null;

    static{
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    Human(){
        try {
            System.out.println("Enter the Name: ");
            this.name = br.readLine();
            System.out.println("Enter age: ");
            this.age = Integer.valueOf(br.readLine());
            System.out.println("Enter the number of family members: ");
            Integer n = Integer.valueOf(br.readLine());
            family = new String[n];
            for (int i = 0; i < n; i++) {
                System.out.println("Enter the name of family member: ");
                String name = br.readLine();
                family[i] = name;
            }
        }catch(Exception e){
            System.out.println("Something just got wrong");
        }

    }

    Human(String name,Integer age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name + "\n" + this.age + "\n" + Arrays.toString(family) + "\n";
    }

    @Override
    public Human clone()  {
        Human copy = new Human(this.name,this.age);
//        copy.family = this.family;//this line is shallow copying the array

        //below we are deep copying
        copy.family = new String[this.family.length];
        for(int i = 0;i < this.family.length;i++){
            copy.family[i] = this.family[i];
        }
        return copy;
    }

    @Override
    protected void finalize() throws Throwable {

        System.out.println("the object is getting destroyed");
    }

}

public class LearningClone {

    public static void main(String[] args) {

        Human h = new Human();

        System.out.println(h);

        Human mihir = h.clone();

        System.out.println(h);

        System.out.println(mihir);

        mihir.family[0] = "lol";

        mihir.age = 30;

        System.out.println(h);

        System.out.println(mihir);

        String []arr1 = {"name", "std"};

        String []arr2 = {"qualities", "don't"};
//        String []arr3 = arr1 + arr2;
//        System.out.println(Arrays.toString(arr1) + Arrays.toString(arr2));
    }


}
