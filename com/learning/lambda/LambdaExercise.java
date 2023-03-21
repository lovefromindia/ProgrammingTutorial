package com.learning.lambda;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;


class Person {

    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}

interface Condition{
    boolean test(Person p);
}

interface Perform{
    void perform(Person p);
}

public class LambdaExercise {

    static void printConditionally(List<Person> person, Condition selectionCondition){
        for (Person p :
                person) {
            if(selectionCondition.test(p)){
                System.out.println(p);
            }
        }
    }

    //performs given function on values selected by selection function
    static void performConditionally(List<Person> person, Condition selectionCondition, Perform perform){
        for (Person p :
                person) {
            if(selectionCondition.test(p)){
                perform.perform(p);
            }
        }
    }

    static void performConditionally(List<Person> person, Predicate<Person> selectionCondition, Consumer<Person> perform){
        for (Person p :
                person) {
            if(selectionCondition.test(p)){
                perform.accept(p);
            }
        }
    }

    public static void main(String[] args) {
        List<Person> list = Arrays.asList(
                new Person("Charles","Dickens",60),
                new Person("Lewis","Caroll",42),
                new Person("Thomas","Caryle",51),
                new Person("Charlotte","Bronte",45),
                new Person("Matthew","Arnold",39)
                );

        //1. Sort list by last name(use function interface to pass to sort)

        list.sort((p,other)->{
            return p.getLastName().compareTo(other.getLastName());
        });


        //2. Create method that prints all people in the list
        printConditionally(list, new Condition() {
            @Override
            public boolean test(Person p) {
                return true;//as all person have to printed
            }
        });


        //3. Create method that prints all people in list with lastName begin with 'C'
        System.out.println("\nPrinting all people with lastName begin with C by function and passing functional interface");

        printConditionally(list,p->p.getLastName().startsWith("C"));


        System.out.println("\nPrinting all people with lastName begin with C and works by lambdas and predicate");

        list.stream().filter(new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getLastName().charAt(0) == 'C';
            }
        }).forEach((Person person)->{
            System.out.println(person);
        });

        performConditionally(list, p -> true, new Perform() {
            @Override
            public void perform(Person p) {
                System.out.println(p.getLastName());
            }
        });
        performConditionally(list, p -> true, (Perform) p -> System.out.println(p.getLastName()));

    }

}
