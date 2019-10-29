package com.epam.rudy.entity;

import java.util.Random;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Bicycle extends MechanicalVehicle {

    @JsonCreator
    public Bicycle(@JsonProperty("id") String id,
        @JsonProperty("vehicleType") VehicleType type,
        @JsonProperty("model") String model,
        @JsonProperty("yearOfManufacture") int yearOfManufacture,
        @JsonProperty("isIndependentVehicle") boolean isIndependentVehicle) {
        super(id, VehicleType.BICYCLE, model, yearOfManufacture, isIndependentVehicle);
    }

    public Bicycle(String model,
                   int yearOfManufacture,
                   boolean isIndependentVehicle) {
        super(VehicleType.BICYCLE, model, yearOfManufacture, isIndependentVehicle);
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
