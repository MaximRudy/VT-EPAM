package com.epam.rudy.entity;

import java.util.Random;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Trailer extends MechanicalVehicle {

    @JsonCreator
    public Trailer(@JsonProperty("id") String id,
        @JsonProperty("vehicleType") VehicleType type,
        @JsonProperty("model") String model,
        @JsonProperty("yearOfManufacture") int yearOfManufacture,
        @JsonProperty("isIndependentVehicle") boolean isIndependentVehicle) {
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
