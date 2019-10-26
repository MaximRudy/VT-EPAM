package com.epam.rudy.entity;

import java.util.Objects;
import java.util.Random;

public class FuelCar extends CombustionFuelVehicle {

    /**  */
    private final CarBodyType carBodyType;

    public FuelCar(String id,
                   String model,
                   int yearOManufacture,
                   int enginePower,
                   int engineCapacity,
                   CarBodyType carBodyType) {
        super(id, VehicleType.CAR, model, yearOManufacture, enginePower, engineCapacity);
        this.carBodyType = carBodyType;
    }

    public FuelCar(String model,
                   int yearOManufacture,
                   int enginePower,
                   int engineCapacity,
                   CarBodyType carBodyType) {
        super(VehicleType.CAR, model, yearOManufacture, enginePower, engineCapacity);
        this.carBodyType = carBodyType;
    }

    public CarBodyType getCarBodyType() {
        return carBodyType;
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
        if (!(o instanceof FuelCar))
            return false;
        if (!super.equals(o))
            return false;
        FuelCar fuelCar = (FuelCar) o;
        return carBodyType == fuelCar.carBodyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), carBodyType);
    }

    @Override
    public String toString() {
        return "FuelCar{" + super.toString() + ", carBodyType='" + carBodyType + "'}";
    }
}
