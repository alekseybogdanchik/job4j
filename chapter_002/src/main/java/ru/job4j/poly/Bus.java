package ru.job4j.poly;

public class Bus implements Transport {
    private int fuel;
    private int fuelCons;
    private int totalPass;

    public Bus(int fuel, int fuelCons, int totalPass) {
        this.fuel = fuel;
        this.fuelCons = fuelCons;
        this.totalPass = totalPass;
    }

    public static void main(String[] args) {
        Bus bus = new Bus(200, 15, 0);
        bus.drive();
        int passengersIn = 50;
        bus.passengers(passengersIn);
        int litres = 200;
        int refuelPrise = bus.refuel(litres);
    }

    @Override
    public void drive() {
        int fuelLeft = fuel;
        int distance = 0;
        int passengersOut = 0;
        int passengersIn = 0;
        while (fuelLeft > 0) {
            distance++;
            fuelLeft = fuel - (fuelCons / 100 * distance);
            if (distance % 10 == 0) {
                passengersOut--;
                passengersIn++;
            }
        }
    }

    @Override
    public void passengers(int count) {
        totalPass = totalPass + count;
    }

    @Override
    public int refuel(int litres) {
        int literPrice = 45;
        int refuelPrise = litres * literPrice;
        return refuelPrise;
    }
}
