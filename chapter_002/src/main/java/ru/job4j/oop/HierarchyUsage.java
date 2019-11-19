package ru.job4j.oop;

public class HierarchyUsage {
    public static void main(String[] args) {
        Car car = new Car();
        Transport tr = car;
        Object obj = car;
        Object objCar = new Car();
        Car carFromObject = (Car) objCar;

        Object bicycle = new Bicycle();
        //Car cb = (Car) bicycle;

        System.out.println(new Car());
        System.out.println(new Bicycle());
        System.out.println(new Object());
    }
}
