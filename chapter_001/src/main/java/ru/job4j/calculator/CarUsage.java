package ru.job4j.calculator;

public class CarUsage {
    public static void main(String[] args) {
        Car audi = new Car();
        String enginesound;
        boolean driving = audi.canDrive();
        if (driving == true) {
            enginesound = "brrr...drrrr" ;
        } else {enginesound = "puh...puh";
        }
        System.out.println("Start engine... trum, trum..."+enginesound);
        System.out.println("i need to add gasoline!");
        int gas = 30;
        audi.fill(gas);
        driving = audi.canDrive();
        if (driving == true) {
            enginesound = "brrr...drrrr" ;
        } else {enginesound = "puh...puh";
        }
        System.out.println("Start engine again "+enginesound);
        System.out.println("let's go to the country grillbar");
        System.out.println("It's 50 km from here!");
        int distance = 50;
        audi.drive(distance);
        audi.gasinfo();


    }
}
