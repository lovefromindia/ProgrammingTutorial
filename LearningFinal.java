import java.util.Scanner;

public class LearningFinal {

    final static int age = Integer.valueOf(12);

    final static int size = factorial(5);

    final static String name = getName();

    public static void main(String[] args) {

        System.out.printf("Name: " + (name.intern()) + (name == "Hello") + " " + age + " " + size);

    }

    public static int factorial(int n){

        return n == 0 ? 1: n * factorial(n-1);

    }

    public static String getName(){

        String s1 = "Hel";

        String s2 = "lo";

        return s1 + s2;

    }

}
