package com.epam.rudy.entity;

import java.util.Random;

public class Trailer extends MechanicalVehicle {

    public Trailer(String id,
                   String model,
                   int yearOfManufacture,
                   boolean isIndependentVehicle) {
        super(id, VehicleType.TRAILER, model, yearOfManufacture, isIndependentVehicle);
    }

    public Trailer(String model,
                   int yearOfManufacture,
                   boolean isIndependentVehicle) {
        super(VehicleType.TRAILER, model, yearOfManufacture, isIndependentVehicle);
    }

    @Override
    protected void doInitialPreparation() {
        checkEngine();
    }

    private void checkEngine() {
        Random rand = new Random();
        setLightingSystemGood((rand.nextInt() % 2 == 0) ? true : false);
    }
}
