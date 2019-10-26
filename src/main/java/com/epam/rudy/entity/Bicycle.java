package com.epam.rudy.entity;

import java.util.Random;

public class Bicycle extends MechanicalVehicle {

    public Bicycle(String id,
                   VehicleType type,
                   String model,
                   int yearOfManufacture,
                   boolean isIndependentVehicle) {
        super(id, type, model, yearOfManufacture, isIndependentVehicle);
    }

    public Bicycle(VehicleType type,
                   String model,
                   int yearOfManufacture,
                   boolean isIndependentVehicle) {
        super(type, model, yearOfManufacture, isIndependentVehicle);
    }

    @Override
    protected void doInitialPreparation() {
        checkEngine();
    }

    private void checkEngine() {
        Random rand = new Random();
        setLightingSystemGood((rand.nextInt() % 2 == 0) ? true : false);
    }

    @Override
    public String toString() {
        return "Bicycle{" + super.toString() + "}";
    }
}
