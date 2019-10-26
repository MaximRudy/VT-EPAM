package com.epam.rudy.entity;

import java.util.Random;

public class Minibus extends CombustionFuelVehicle {

    public Minibus(String id,
                   String model,
                   int yearOManufacture,
                   int enginePower,
                   int engineCapacity) {
        super(id, VehicleType.MINIBUS, model, yearOManufacture, enginePower, engineCapacity);
    }

    public Minibus(String model,
                   int yearOManufacture,
                   int enginePower,
                   int engineCapacity) {
        super(VehicleType.MINIBUS, model, yearOManufacture, enginePower, engineCapacity);
    }

    @Override
    public String toString() {
        return "Minibus{" + super.toString() + "}";
    }

    @Override
    protected void doInitialPreparation() {
        checkEngine();
    }

    private void checkEngine() {
        Random rand = new Random();
        setEngineEcoTestPassed((rand.nextInt() % 2 == 0) ? true : false);
    }
}
