package javaActivity1;

public class Activity1_1 {

    public static void main(String[] args) {
        Car toyota = new Car();
        toyota.make = 2014;
        toyota.color = "Black";
        toyota.transmission = "Manual";
        
        //call methods
        toyota.displayCharacterstics();
        toyota.accelerate();
        toyota.brake();
    }

}