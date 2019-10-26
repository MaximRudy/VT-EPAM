package com.epam.rudy.entity;

import java.util.Random;

public class Motorbike extends CombustionFuelVehicle {

    public Motorbike(String id,
                     String model,
                     int yearOManufacture,
                     int enginePower,
                     int engineCapacity) {
        super(id, VehicleType.MOTORBIKE, model, yearOManufacture, enginePower, engineCapacity);
    }

    public Motorbike(String model,
                     int yearOManufacture,
                     int enginePower,
                     int engineCapacity) {
        super(VehicleType.MOTORBIKE, model, yearOManufacture, enginePower, engineCapacity);
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
    public String toString() {
        return "Motorbike{" + super.toString() + "}";
    }
}
