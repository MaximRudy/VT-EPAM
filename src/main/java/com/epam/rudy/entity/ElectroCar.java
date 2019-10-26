package com.epam.rudy.entity;

import java.util.Random;

public class ElectroCar extends ElectroVehicle {

    public ElectroCar(String id,
                      String model,
                      int yearOfManufacture,
                      int enginePower,
                      int timeToCharge) {
        super(id, VehicleType.ELECTRO_CAR, model, yearOfManufacture, enginePower, timeToCharge);
    }

    public ElectroCar(String model,
                      int yearOfManufacture,
                      int enginePower,
                      int timeToCharge) {
        super(VehicleType.ELECTRO_CAR, model, yearOfManufacture, enginePower, timeToCharge);
    }

    @Override
    protected void doInitialPreparation() {
        checkEngine();
    }

    private void checkEngine() {
        Random rand = new Random();
        setEngineCircuitPassRateGood((rand.nextInt() % 2 == 0) ? true : false);
    }

    @Override
    public String toString() {
        return "ElectroCar{" + super.toString() + "}";
    }
}