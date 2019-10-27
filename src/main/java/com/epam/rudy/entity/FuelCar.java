package com.epam.rudy.entity;

import java.util.Objects;
import java.util.Random;

public class FuelCar extends CombustionFuelVehicle {

    public FuelCar(String id,
                   String model,
                   int yearOManufacture,
                   int enginePower,
                   CarBodyType carBodyType,
                   int engineCapacity) {
        super(id, VehicleType.FUEL_CAR, model, yearOManufacture, enginePower, carBodyType, engineCapacity);
    }

    public FuelCar(String model,
                   int yearOManufacture,
                   int enginePower,
                   CarBodyType carBodyType,
                   int engineCapacity) {
        super(VehicleType.FUEL_CAR, model, yearOManufacture, enginePower, carBodyType, engineCapacity);

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
        return "FuelCar{" + super.toString() + "}";
    }
}
