package com.learning.string;

public class LearningString {

    public static void main(String[] args) {

        checkSCP();

        checkImmutability();

    }

    public static void checkSCP(){

        String firstLanguage = "Java"; //made in string constant pool

        String secondLanguage = new String("Java");//made in heap but not in string pool

        String thirdLanguage = "Java";

        System.out.println(firstLanguage == secondLanguage);

        System.out.println(thirdLanguage == secondLanguage);

        System.out.println(firstLanguage == thirdLanguage);

        System.out.println(firstLanguage == getName());

    }

    public static String getName(){
//        return new String("Java");
        return "Java";

    }

    public static void checkImmutability() {

        String password1 = "Mihir";

        String password2 = "Mihir";

        System.out.println(password1);

        System.out.println(password2);

        System.out.println(password1 == password2);

        password2 += "Agrawal";//not in SCP from now onwards

        System.out.println(password1);

        System.out.println(password2);

        System.out.println(password1 == password2);

        String password3 = "MihirAgrawal";

        System.out.println(password2 == password3);

        String password4 = new String("Mihir");

        String password5 = new String("Mihir");

        System.out.println(password4 == password5);

        System.out.println(password4.charAt(0));

        System.out.println(password4.length());
        
    }

}
