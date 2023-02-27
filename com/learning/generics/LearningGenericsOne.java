package com.learning.generics;


class Printer<T>{
    T thingToPrint;

    Printer(T thingToPrint){

        this.thingToPrint =  thingToPrint;

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

        System.out.println(integerPrinter.getter() == 45);

        VehicleCar vehicleCar = new VehicleCar("GJ06-5043",4,3999999.0);

        Printer<VehicleCar> vehicleCarPrinter = new Printer<>(vehicleCar);

        System.out.println(vehicleCarPrinter.getter());

    }

}
