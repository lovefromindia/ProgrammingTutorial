package com.learning.generics;


class Printer<T>{

    T thingToPrint;

    Printer(T thingToPrint){

        this.thingToPrint =  thingToPrint;

    }

    void setter(T thingToPrint){

        this.thingToPrint = thingToPrint;

    }

    public void print(){

        System.out.println(thingToPrint);

    }

    public T getter(){

        return thingToPrint;

    }

}

class VehicleCar{

    private String licensePlate;

    private Integer tyres;

    private Double price;

    VehicleCar(String licensePlate,Integer tyres, Double price){

        this.licensePlate = licensePlate;

        this.tyres = tyres;

        this.price = price;

    }

    public String toString(){

        return this.licensePlate + " " + this.tyres + " " + this.price;

    }

}

public class LearningGenericsOne {

    public static void main(String[] args) {

        Printer<String> stringPrinter = new Printer<>("Mihir");

        System.out.println(stringPrinter.getter() == "Mihir");

//        Printer<int>
        Printer<Integer> integerPrinter = new Printer<>(Integer.valueOf(45));

//        integerPrinter.setter("lol");
        Integer temp = integerPrinter.getter();

        System.out.println(integerPrinter.getter() == 45);

        VehicleCar vehicleCar = new VehicleCar("GJ06-5043",4,3999999.0);

        Printer<VehicleCar> vehicleCarPrinter = new Printer<>(vehicleCar);

        System.out.println(vehicleCarPrinter.getter());

        StringPrinter obj = new StringPrinter(2.0);

        StringPrinter obj2 = new StringPrinter("String");

        String str = (String)obj2.getter();

        obj.print();

        obj2.print();

    }

}

class StringPrinter{

    private Object thingToPrint;

    public StringPrinter(Object thingToPrint){

        this.thingToPrint = thingToPrint;

    }

    public Object getter(){

        return this.thingToPrint;

    }

    public void print(){

        System.out.println("Thing is: " + thingToPrint);

    }

}

