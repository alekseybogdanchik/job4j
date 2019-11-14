package ru.job4j.poly;

public class Bus implements Transport {
    Bus bus = new Bus();
    int fuel = 200;
    int fuelCons = 15;
    int fuelLeft;
    int distance;
    boolean gasStation;
    boolean busStop;
    int passengersOut;
    int passengersIn;
    int totalPass;
    int literPrice = 45;

    @Override
    public void drive() {
        while (fuelLeft > 0) {
            fuelLeft = fuel - (fuelCons / 100 * distance);
            if (busStop) {
                passengersOut--;
                passengersIn++;
                bus.passengers(passengersIn);
            }
            if (fuelLeft == 0) {
                bus.refuel(fuel - fuelLeft);
            }
        }
    }

    @Override
    public void passengers(int count) {
        totalPass += passengersIn;
    }

    @Override
    public int refuel(int litres) {
        int refuelPrise = 0;
        if (gasStation) {
            refuelPrise = litres * literPrice;
        }
        return refuelPrise;
    }
}
