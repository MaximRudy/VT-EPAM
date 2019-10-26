package com.epam.rudy.entity;

import java.util.Objects;

public abstract class EngineVehicle extends Vehicle {

    /**  */
    private final int enginePower;

    public EngineVehicle(String id,
                         VehicleType vehicleType,
                         String model,
                         int yearOfManufacture,
                         int enginePower) {
        super(id, vehicleType, model, yearOfManufacture);
        this.enginePower = enginePower;
    }

    public EngineVehicle(VehicleType vehicleType,
                         String model,
                         int yearOfManufacture,
                         int enginePower) {
        super(vehicleType, model, yearOfManufacture);
        this.enginePower = enginePower;
    }

    public int getEnginePower() {
        return enginePower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof EngineVehicle))
            return false;
        if (!super.equals(o))
            return false;
        EngineVehicle that = (EngineVehicle) o;
        return enginePower == that.enginePower;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), enginePower);
    }

    @Override
    public String toString() {
        return super.toString() + ", enginePower='" + enginePower + "\'";
    }
}
