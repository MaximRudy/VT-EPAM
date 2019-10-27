package com.epam.rudy.entity;

import java.util.Objects;
import java.util.Random;

public class Bus extends CombustionFuelVehicle {

    /**  */
    private final int numberOfAxles;

    public Bus(String id,
               String model,
               int yearOManufacture,
               int enginePower,
               int engineCapacity,
               int numberOfAxles) {
        super(id, VehicleType.BUS, model, yearOManufacture, enginePower, CarBodyType.WAGON, engineCapacity);
        this.numberOfAxles = numberOfAxles;
    }

    public Bus(String model,
               int yearOManufacture,
               int enginePower,
               int engineCapacity,
               int numberOfAxles) {
        super(VehicleType.BUS, model, yearOManufacture, enginePower, CarBodyType.WAGON, engineCapacity);
        this.numberOfAxles = numberOfAxles;
    }

    public int getNumberOfAxles() {
        return numberOfAxles;
    }

    @Override
    protected void doInitialPreparation() {
        checkEngine();
    }

    private void checkEngine() {
        Random rand = new Random();
        setEngineEcoTestPassed((rand.nextInt() % 2 == 0) ? true : false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Bus))
            return false;
        if (!super.equals(o))
            return false;
        Bus bus = (Bus) o;
        return numberOfAxles == bus.numberOfAxles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfAxles);
    }

    @Override
    public String toString() {
        return "Bus{" + super.toString() + ", numberOfAxles='" + numberOfAxles + "'}";
    }
}
