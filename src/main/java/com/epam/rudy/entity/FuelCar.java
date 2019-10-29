package com.epam.rudy.entity;

import java.util.Objects;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FuelCar extends CombustionFuelVehicle {

    @JsonCreator
    public FuelCar(@JsonProperty("id") String id,
        @JsonProperty("vehicleType") VehicleType vehicleType,
        @JsonProperty("model") String model,
        @JsonProperty("yearOfManufacture") int yearOfManufacture,
        @JsonProperty("enginePower") int enginePower,
        @JsonProperty("carBodyType") CarBodyType carBodyType,
        @JsonProperty("engineCapacity") int engineCapacity) {
        super(id, VehicleType.FUEL_CAR, model, yearOfManufacture, enginePower, carBodyType, engineCapacity);
    }

    public FuelCar(String model,
                   int yearOfManufacture,
                   int enginePower,
                   CarBodyType carBodyType,
                   int engineCapacity) {
        super(VehicleType.FUEL_CAR, model, yearOfManufacture, enginePower, carBodyType, engineCapacity);

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
